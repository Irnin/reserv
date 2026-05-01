package site.komuna.reserv.auth.service

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import site.komuna.reserv.auth.exception.InvalidCredentialsException
import site.komuna.reserv.auth.model.AuthResponse
import site.komuna.reserv.user.repository.UserRepository
import java.time.OffsetDateTime

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    fun authenticate(email: String, password: String): Mono<AuthResponse> {

        return userRepository.findByEmail(email)
            .filter { passwordEncoder.matches(password, it.password) }
            .switchIfEmpty(Mono.error { InvalidCredentialsException()})
            .map { AuthResponse(accessToken = if (passwordEncoder.matches(password, it.password)) "OK" else "NO: "+it.password, expires = OffsetDateTime.now().plusMinutes(10)) }
    }

    fun testGetPassword(password: String): Mono<String> {
        return Mono.justOrEmpty(passwordEncoder.encode(password))
    }
}
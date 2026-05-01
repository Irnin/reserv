package site.komuna.reserv.auth

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import site.komuna.reserv.auth.model.AuthRequest
import site.komuna.reserv.auth.model.AuthResponse
import site.komuna.reserv.auth.service.AuthService
import java.time.OffsetDateTime

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService,
) {
    @PostMapping("/login")
    fun login(@RequestBody authRequest: AuthRequest): Mono<AuthResponse> {
        return authService.authenticate(authRequest.email, authRequest.password)
    }

    @PostMapping("/test")
    fun gegister(@RequestBody authRequest: AuthRequest): Mono<String> {
        return authService.testGetPassword(authRequest.password)
    }
}
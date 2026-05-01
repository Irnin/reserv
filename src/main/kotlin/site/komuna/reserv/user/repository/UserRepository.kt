package site.komuna.reserv.user.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono
import site.komuna.reserv.user.UserEntity

interface UserRepository : R2dbcRepository<UserEntity, Long> {

    fun findByEmail(email: String): Mono<UserEntity>
}
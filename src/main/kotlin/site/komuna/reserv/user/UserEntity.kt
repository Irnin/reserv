package site.komuna.reserv.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "users")
data class UserEntity(
    @Id val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
) {
}
package site.komuna.reserv.auth.model

import java.time.OffsetDateTime

data class AuthResponse(
    val accessToken: String? = null,
    val expires: OffsetDateTime? = null
) {

}
package site.komuna.reserv.reservation.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.time.Duration

class ReservationDto(
    @Id
    val id: Long? = null,
    val bandId: Long,
    val rehearsalRoomId: Long,
    var startAt: LocalDateTime,
    var duration: Duration,
) {
    constructor(reservation: ReservationEntity) : this(
        id = reservation.id,
        bandId = reservation.bandId,
        rehearsalRoomId = reservation.rehearsalRoomId,
        startAt = reservation.startAt,
        duration = Duration.ofMinutes(reservation.duration)
    )
}
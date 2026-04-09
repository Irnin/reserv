package site.komuna.reserv.reservation.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.time.Duration

@Table(name = "reservations")
class ReservationEntity(
    @Id
    val id: Long? = null,
    val bandId: Long,
    val rehearsalRoomId: Long,
    var startAt: LocalDateTime,
    var duration: Long,
) {
    constructor(reservationDto: ReservationDto) : this(
        id = reservationDto.id,
        bandId = reservationDto.bandId,
        rehearsalRoomId = reservationDto.rehearsalRoomId,
        startAt = reservationDto.startAt,
        duration = reservationDto.duration.toMinutes()
    )
}
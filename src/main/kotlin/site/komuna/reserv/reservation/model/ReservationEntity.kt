package site.komuna.reserv.reservation.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(name = "reservations")
class ReservationEntity(
    @Id
    val id: Long? = null,
    val customerId: Long,
    val roomId: Long,
    var startAt: LocalDateTime,
    var duration: Long,
) {
    constructor(reservationDto: ReservationDto) : this(
        id = reservationDto.id,
        customerId = reservationDto.customerId,
        roomId = reservationDto.roomId,
        startAt = reservationDto.startAt,
        duration = reservationDto.duration.toMinutes()
    )
}
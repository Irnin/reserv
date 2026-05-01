package site.komuna.reserv.reservation.model

import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.time.Duration

class ReservationDto(
    @Id
    val id: Long? = null,
    val customerId: Long,
    val roomId: Long,
    var startAt: LocalDateTime,
    var duration: Duration,
) {
    constructor(reservation: ReservationEntity) : this(
        id = reservation.id,
        customerId = reservation.customerId,
        roomId = reservation.roomId,
        startAt = reservation.startAt,
        duration = Duration.ofMinutes(reservation.duration)
    )
}
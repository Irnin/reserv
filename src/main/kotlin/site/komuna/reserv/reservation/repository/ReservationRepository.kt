package site.komuna.reserv.reservation.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import site.komuna.reserv.reservation.model.ReservationEntity
import java.time.LocalDateTime

@Repository
interface ReservationRepository: R2dbcRepository<ReservationEntity, Long> {
	fun findAllByRehearsalRoomId(roomId: Long): Flux<ReservationEntity>
	fun findAllByStartAtAfter(startAt: LocalDateTime): Flux<ReservationEntity>
	fun findAllByRehearsalRoomIdAndStartAtAfter(roomId: Long, startAt: LocalDateTime): Flux<ReservationEntity>
}
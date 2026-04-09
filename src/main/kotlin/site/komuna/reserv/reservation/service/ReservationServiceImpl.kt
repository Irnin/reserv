package site.komuna.reserv.reservation.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import site.komuna.reserv.reservation.model.ReservationDto
import site.komuna.reserv.reservation.model.ReservationEntity
import site.komuna.reserv.reservation.repository.ReservationRepository
import java.time.LocalDateTime

@Service
class ReservationServiceImpl(
    private val repository: ReservationRepository
): ReservationService {

    override fun createReservation(reservation: ReservationDto): Mono<ReservationDto> {
        return repository
            .save(ReservationEntity(reservation))
            .map { ReservationDto(it) }
    }

    override fun getReservationsForRoom(roomId: Long): Flux<ReservationDto> {
        return repository
            .findAllByRehearsalRoomId(roomId)
            .map { ReservationDto(it) }
    }

    override fun getFutureReservations(): Flux<ReservationDto> {
        return repository
            .findAllByStartAtAfter(LocalDateTime.now())
            .map { ReservationDto(it) }
    }

    override fun getFutureReservationsForRoom(roomId: Long): Flux<ReservationDto> {
        return repository
            .findAllByRehearsalRoomIdAndStartAtAfter(roomId, LocalDateTime.now())
            .map { ReservationDto(it) }
    }
}
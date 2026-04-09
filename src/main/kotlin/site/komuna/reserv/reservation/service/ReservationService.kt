package site.komuna.reserv.reservation.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import site.komuna.reserv.reservation.model.ReservationDto

interface ReservationService {

    fun createReservation(reservation: ReservationDto): Mono<ReservationDto>
    fun getReservationsForRoom(roomId: Long): Flux<ReservationDto>
    fun getFutureReservations(): Flux<ReservationDto>
    fun getFutureReservationsForRoom(roomId: Long): Flux<ReservationDto>
}
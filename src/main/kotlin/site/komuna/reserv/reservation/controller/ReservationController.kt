package site.komuna.reserv.reservation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import site.komuna.reserv.reservation.model.ReservationDto
import site.komuna.reserv.reservation.service.ReservationService

@RestController
@RequestMapping("/reservation")
class ReservationController(
    private val service: ReservationService
) {

    @PostMapping
    fun createReservation(@RequestBody reservation: ReservationDto): Mono<ReservationDto> {
        return service.createReservation(reservation)
    }

    @GetMapping("/room/{roomId}")
    fun findReservation(@PathVariable roomId: Long): Flux<ReservationDto> {
        return service.getReservationsForRoom(roomId)
    }

    @GetMapping("/future")
    fun findFutureReservations(): Flux<ReservationDto> {
        return service.getFutureReservations()
    }

    @GetMapping("/room/{roomId}/future")
    fun findFutureReservationsForRoom(@PathVariable roomId: Long): Flux<ReservationDto> {
        return service.getFutureReservationsForRoom(roomId)
    }
}
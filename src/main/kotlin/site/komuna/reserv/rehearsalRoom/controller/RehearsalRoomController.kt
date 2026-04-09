package site.komuna.reserv.rehearsalRoom.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import site.komuna.reserv.band.model.BandDto
import site.komuna.reserv.band.service.BandService
import site.komuna.reserv.rehearsalRoom.model.RehearsalRoomEntity
import site.komuna.reserv.rehearsalRoom.service.RehearsalRoomService

@RestController
@RequestMapping("/room")
class RehearsalRoomController(
    private val service: RehearsalRoomService
) {
    @GetMapping("/{room}")
    fun getRoom(@PathVariable room: Long): Mono<RehearsalRoomEntity> {
        return service.getRoom(room)
            .switchIfEmpty(Mono.empty())
    }
}
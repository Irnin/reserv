package site.komuna.reserv.room.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import site.komuna.reserv.room.model.RoomEntity
import site.komuna.reserv.room.service.RoomService

@RestController
@RequestMapping("/room")
class RoomController(
    private val service: RoomService
) {
    @GetMapping("/{room}")
    fun getRoom(@PathVariable room: Long): Mono<RoomEntity> {
        return service.getRoom(room)
            .switchIfEmpty(Mono.empty())
    }
}
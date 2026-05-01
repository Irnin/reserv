package site.komuna.reserv.room.service

import reactor.core.publisher.Mono
import site.komuna.reserv.room.model.RoomEntity

interface RoomService {

    fun getRoom(id: Long): Mono<RoomEntity>
}
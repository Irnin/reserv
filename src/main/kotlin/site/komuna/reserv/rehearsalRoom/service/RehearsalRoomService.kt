package site.komuna.reserv.rehearsalRoom.service

import reactor.core.publisher.Mono
import site.komuna.reserv.rehearsalRoom.model.RehearsalRoomEntity

interface RehearsalRoomService {

    fun getRoom(id: Long): Mono<RehearsalRoomEntity>
}
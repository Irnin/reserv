package site.komuna.reserv.room.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import site.komuna.reserv.room.exception.RoomNotFound
import site.komuna.reserv.room.model.RoomEntity
import site.komuna.reserv.room.repository.RoomRepository

@Service
class RoomServiceImpl(
    val repository: RoomRepository
) : RoomService {

    override fun getRoom(id: Long): Mono<RoomEntity> {
        return repository.findById(id)
            .switchIfEmpty(Mono.error{ RoomNotFound(id) })
    }
}
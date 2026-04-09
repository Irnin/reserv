package site.komuna.reserv.rehearsalRoom.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import site.komuna.reserv.rehearsalRoom.exception.RehearsalRoomNotFound
import site.komuna.reserv.rehearsalRoom.model.RehearsalRoomEntity
import site.komuna.reserv.rehearsalRoom.repository.RehearsalRoomRepository

@Service
class RehearsalRoomServiceImpl(
    val repository: RehearsalRoomRepository
) : RehearsalRoomService {

    override fun getRoom(id: Long): Mono<RehearsalRoomEntity> {
        return repository.findById(id)
            .switchIfEmpty(Mono.error{ RehearsalRoomNotFound(id) })
    }
}
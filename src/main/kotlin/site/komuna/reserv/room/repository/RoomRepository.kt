package site.komuna.reserv.room.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import site.komuna.reserv.room.model.RoomEntity

@Repository
interface RoomRepository: R2dbcRepository<RoomEntity, Long> {
}
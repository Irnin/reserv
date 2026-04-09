package site.komuna.reserv.rehearsalRoom.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import site.komuna.reserv.band.model.BandEntity
import site.komuna.reserv.rehearsalRoom.model.RehearsalRoomEntity

@Repository
interface RehearsalRoomRepository: R2dbcRepository<RehearsalRoomEntity, Long> {
}
package site.komuna.reserv.rehearsalRoom.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "rehearsal_rooms")
class RehearsalRoomEntity(
    @Id
    val id: Long? = null,
    val name: String
) {



}
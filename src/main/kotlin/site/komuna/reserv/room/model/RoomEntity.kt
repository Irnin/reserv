package site.komuna.reserv.room.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "rooms")
class RoomEntity(
    @Id
    val id: Long? = null,
    val name: String
) {



}
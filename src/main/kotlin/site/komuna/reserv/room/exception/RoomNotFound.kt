package site.komuna.reserv.room.exception

class RoomNotFound(id: Long) : RuntimeException("Rehearsal room not found: $id") {
}
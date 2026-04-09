package site.komuna.reserv.rehearsalRoom.exception

class RehearsalRoomNotFound(id: Long) : RuntimeException("Rehearsal room not found: $id") {
}
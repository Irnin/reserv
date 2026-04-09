package site.komuna.reserv.band.exception

class BandNotFound(id: Long) : RuntimeException("Band not found: $id") {
}
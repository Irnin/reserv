package site.komuna.reserv.customer.exception

class CustomerNotFound(id: Long) : RuntimeException("Band not found: $id") {
}
package site.komuna.reserv.customer.model

data class CustomerDto(
    var id: Long? = null,
    val name: String) {

    constructor(entity: CustomerEntity): this(
        id = entity.id,
        name = entity.name) {}
}
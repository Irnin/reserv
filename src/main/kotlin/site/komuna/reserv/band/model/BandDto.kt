package site.komuna.reserv.band.model

data class BandDto(
    var id: Long? = null,
    val name: String) {

    constructor(entity: BandEntity): this(
        id = entity.id,
        name = entity.name) {}
}
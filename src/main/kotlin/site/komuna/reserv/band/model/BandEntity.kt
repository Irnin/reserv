package site.komuna.reserv.band.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("bands")
data class BandEntity(
    @Id
    var id: Long?,
    var name: String
) {

    constructor(dto: BandDto): this(
        dto.id,
        dto.name
    )
}

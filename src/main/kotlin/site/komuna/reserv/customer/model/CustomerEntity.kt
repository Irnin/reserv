package site.komuna.reserv.customer.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("customer")
data class CustomerEntity(
    @Id
    var id: Long?,
    var name: String
) {

    constructor(dto: CustomerDto): this(
        dto.id,
        dto.name
    )
}

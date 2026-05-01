package site.komuna.reserv.customer.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import site.komuna.reserv.customer.model.CustomerEntity

@Repository
interface CustomerRepository : R2dbcRepository<CustomerEntity, Long> {

}
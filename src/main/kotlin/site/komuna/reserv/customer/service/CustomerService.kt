package site.komuna.reserv.customer.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import site.komuna.reserv.customer.model.CustomerDto

interface CustomerService {

    fun getBandById(id: Long): Mono<CustomerDto>
    fun getAllBands(): Flux<CustomerDto>
    fun createBand(dto: CustomerDto): Mono<CustomerDto>
    fun deleteBand(id: Long): Mono<Void>
}
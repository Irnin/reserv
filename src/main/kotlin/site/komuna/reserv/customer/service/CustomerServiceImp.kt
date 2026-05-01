package site.komuna.reserv.customer.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import site.komuna.reserv.customer.exception.CustomerNotFound
import site.komuna.reserv.customer.model.CustomerDto
import site.komuna.reserv.customer.model.CustomerEntity
import site.komuna.reserv.customer.repository.CustomerRepository

@Service
class CustomerServiceImp(
    val repository: CustomerRepository
): CustomerService {

    override fun getBandById(id: Long): Mono<CustomerDto> {
        return repository.findById(id)
            .mapNotNull { band ->
                CustomerDto(band.id, band.name)
            }
    }

    override fun getAllBands(): Flux<CustomerDto> {
        return repository.findAll()
            .map{ CustomerDto(it) }
    }

    override fun createBand(dto: CustomerDto): Mono<CustomerDto> {
        return repository.save(
            CustomerEntity(
                id = null,
                name = dto.name
            )
        )
            .map{ CustomerDto(it) }
    }


    override fun deleteBand(id: Long): Mono<Void> {
        return repository.findById(id)
            .switchIfEmpty(Mono.error { CustomerNotFound(id) })
            .flatMap { repository.deleteById(it.id!!) }
    }
}
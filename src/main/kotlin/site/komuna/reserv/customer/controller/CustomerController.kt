package site.komuna.reserv.customer.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import site.komuna.reserv.customer.model.CustomerDto
import site.komuna.reserv.customer.service.CustomerService

@RestController
@RequestMapping("/band")
class CustomerController(
    val service : CustomerService
) {
    @GetMapping("/{id}")
    fun getBands(@PathVariable id: Long): Mono<CustomerDto> {
        return service.getBandById(id)
    }

    @GetMapping("/")
    fun getAllBands(): Flux<CustomerDto> {
        return service.getAllBands()
    }

    @PostMapping
    fun postBand(@RequestBody dto: CustomerDto): Mono<CustomerDto> {
        return service.createBand(dto)
    }

    @DeleteMapping("/{id}")
    fun deleteBand(@PathVariable id: Long): Mono<Void> {
        return service.deleteBand(id)
    }
}
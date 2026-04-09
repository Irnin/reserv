package site.komuna.reserv.band.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import site.komuna.reserv.band.model.BandDto
import site.komuna.reserv.band.service.BandService

@RestController
@RequestMapping("/band")
class BandController(
    val service : BandService
) {
    @GetMapping("/{id}")
    fun getBands(@PathVariable id: Long): Mono<BandDto> {
        return service.getBandById(id)
    }

    @GetMapping("/")
    fun getAllBands(): Flux<BandDto> {
        return service.getAllBands()
    }

    @PostMapping
    fun postBand(@RequestBody dto: BandDto): Mono<BandDto> {
        return service.createBand(dto)
    }

    @DeleteMapping("/{id}")
    fun deleteBand(@PathVariable id: Long): Mono<Void> {
        return service.deleteBand(id)
    }
}
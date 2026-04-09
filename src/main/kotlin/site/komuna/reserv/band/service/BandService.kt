package site.komuna.reserv.band.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import site.komuna.reserv.band.model.BandDto

interface BandService {

    fun getBandById(id: Long): Mono<BandDto>
    fun getAllBands(): Flux<BandDto>
    fun createBand(dto: BandDto): Mono<BandDto>
    fun deleteBand(id: Long): Mono<Void>
}
package site.komuna.reserv.band.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import site.komuna.reserv.band.exception.BandNotFound
import site.komuna.reserv.band.model.BandDto
import site.komuna.reserv.band.model.BandEntity
import site.komuna.reserv.band.repository.BandRepository

@Service
class BandServiceImp(
    val repository: BandRepository
): BandService {

    override fun getBandById(id: Long): Mono<BandDto> {
        return repository.findById(id)
            .mapNotNull { band ->
                BandDto(band.id, band.name)
            }
    }

    override fun getAllBands(): Flux<BandDto> {
        return repository.findAll()
            .map{ BandDto(it) }
    }

    override fun createBand(dto: BandDto): Mono<BandDto> {
        return repository.save(
            BandEntity(
                id = null,
                name = dto.name
            )
        )
            .map{ BandDto(it) }
    }


    override fun deleteBand(id: Long): Mono<Void> {
        return repository.findById(id)
            .switchIfEmpty(Mono.error { BandNotFound(id) })
            .flatMap { repository.deleteById(it.id!!) }
    }
}
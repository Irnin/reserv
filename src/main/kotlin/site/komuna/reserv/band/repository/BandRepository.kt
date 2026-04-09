package site.komuna.reserv.band.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import site.komuna.reserv.band.model.BandEntity

@Repository
interface BandRepository : R2dbcRepository<BandEntity, Long> {

}
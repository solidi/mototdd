package com.mototdd.katana.speed

import com.mototdd.katana.location.api.*
import io.reactivex.*
import kotlin.math.*

// coord -> speed
// speed (m/s) -> (mi/h) / (km/h)
// locationRepository.speed() -> Long m/s
// SpeedUnit { KM_H, MI_H }
// speed(unit) -> Long unit

// single speed -> Long

// multiple speed -> List

// stream of speeds -> Observable

enum class SpeedUnit { KM_H, MI_H }

class SpeedProvider(
        private val locationRepo: LocationRepository
) {
    fun speed(unit: SpeedUnit): Observable<Int> = locationRepo.speed().map {
        (it * when (unit) {
            SpeedUnit.KM_H -> 3.6
            SpeedUnit.MI_H -> 2.24
        }).roundToInt()
    }
}
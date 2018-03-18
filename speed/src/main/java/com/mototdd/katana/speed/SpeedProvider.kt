package com.mototdd.katana.speed

import com.mototdd.katana.location.api.Coordinate

class SpeedProvider(
        private val windowSize: Int
) {

    init {
        require(windowSize >= 1)
    }

    fun speed(coordinate: List<Coordinate>): List<Long> = coordinate.map { 0L }
}
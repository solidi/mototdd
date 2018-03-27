package com.mototdd.katana.speed

import com.mototdd.katana.location.api.*
import com.nhaarman.mockito_kotlin.*
import io.reactivex.*
import org.junit.Test

import org.junit.Assert.*
import kotlin.math.*

class SpeedProviderTest {

    val metersPerSecond = (1..100)
    val locationRepository: LocationRepository = mock {
        on { speed() } doReturn Observable.fromIterable(metersPerSecond)
    }
    val testSubject = SpeedProvider(locationRepository)

    @Test
    fun `Given a speed and KM per H, when I ask for a speed, then I get a converted speed`() {
        // GIVEN
        val expected = metersPerSecond.map { (it * 3.6).roundToInt() }

        // WHEN
        val result = metersPerSecond.map { testSubject.speed(SpeedUnit.KM_H) }

        // THEN
        assertEquals(expected, result)
    }

    @Test
    fun `Given a speed and MI per H, when I ask for a speed, then I get a converted speed`() {
        // GIVEN
        val expected = metersPerSecond.map { (it * 2.24).roundToInt() }

        // WHEN
        val result = metersPerSecond.map { testSubject.speed(SpeedUnit.MI_H) }

        // THEN
        assertEquals(expected, result)
    }
}
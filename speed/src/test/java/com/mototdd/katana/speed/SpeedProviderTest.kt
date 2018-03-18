package com.mototdd.katana.speed

import com.mototdd.katana.location.api.*
import org.junit.Test

import org.junit.Assert.*

class SpeedProviderTest {

    val testSubject = SpeedProvider(1)

    @Test
    fun `Given a single coordinate, then speed is zero`() {
        // GIVEN
        val coord = Coordinate()

        // WHEN
        val result = testSubject.speed(listOf(coord))

        // THEN
        assertEquals(0L, result[0])
    }

    @Test
    fun `Given a list of the same coordinate, then all speeds are zero`() {
        // GIVEN
        val coord = Coordinate()
        val listOfCoords = (1..10).map { coord }

        // WHEN
        val result = testSubject.speed(listOfCoords)

        // THEN
        result.forEach {
            assertEquals(0L, it)
        }
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Given a windowSize less than 1, then IllegalArgumentException`() {
        // GIVEN
        val windowSize = 0

        // WHEN
        SpeedProvider(windowSize = windowSize)
    }

    @Test
    fun `Given window size 1, then speed count is same as coordinate count`() {
        // GIVEN
        val coords = (1..10).map { Coordinate() }

        // WHEN
        val result = testSubject.speed(coords)

        // THEN
        assertEquals(coords.size, result.size)
    }

    @Test
    fun `Given window size of x, then I get the expected speed count`() {
        // GIVEN
        val coords = (1..10).map { Coordinate() }
        val windowSizes = listOf(1, 2, 5, 6, 10)
        val expectedSize = listOf(10, 9, 6, 5, 1)

        // WHEN
        val results = windowSizes.map {
            val ts = SpeedProvider(it)
            ts.speed(coords)
        }

        // THEN
        results.zip(expectedSize) { r, s ->
            assertEquals(s, r.size)
        }
    }
}
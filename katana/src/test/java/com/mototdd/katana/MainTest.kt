package com.mototdd.katana

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class MainTest {
    @Test
    fun `Given nothing, then I expect a running test rig`() {
        assertTrue(true)
    }

    @Test
    fun `Give 1 and 1, when add, then returns 2`() {
        val e = Main()

        val result = e.add(1, 1)

        assertEquals(2, result)
    }
}

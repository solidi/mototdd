package com.mototdd.katana.location.api

import io.reactivex.*

interface LocationRepository {
    /**
     * @return Speed in Meters per Second
     */
    fun speed(): Observable<Int>
}
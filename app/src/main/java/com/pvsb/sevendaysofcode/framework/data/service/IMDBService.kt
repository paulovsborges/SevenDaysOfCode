package com.pvsb.sevendaysofcode.framework.data.service

import com.pvsb.core.model.IMDBResponse
import retrofit2.http.GET

interface IMDBService {

    @GET("Top250Movies/")
    suspend fun fetchData(): IMDBResponse
}
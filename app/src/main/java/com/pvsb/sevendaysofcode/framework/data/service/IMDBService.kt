package com.pvsb.sevendaysofcode.framework.data.service

import com.pvsb.core.model.IMDBResponse
import retrofit2.http.GET

interface IMDBService {

    @GET
    suspend fun fetchData(): IMDBResponse
}
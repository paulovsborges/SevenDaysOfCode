package com.pvsb.sevendaysofcode.framework.data.datasource

import com.pvsb.core.model.IMDBResponse

interface RemoteDataSource {

    suspend fun fetchData(): IMDBResponse
}
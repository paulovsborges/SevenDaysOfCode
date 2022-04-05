package com.pvsb.sevendaysofcode.framework.data.datasource

import com.pvsb.core.model.IMDBResponse
import com.pvsb.sevendaysofcode.framework.data.service.IMDBService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val service: IMDBService): RemoteDataSource {

    override suspend fun fetchData(): IMDBResponse {
        return service.fetchData()
    }
}
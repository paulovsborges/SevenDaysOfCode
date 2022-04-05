package com.pvsb.sevendaysofcode.framework.repository

import androidx.paging.PagingSource
import com.pvsb.core.model.IMDBDetails
import com.pvsb.sevendaysofcode.framework.data.datasource.RemoteDataSource
import com.pvsb.sevendaysofcode.framework.pagingdata.IMDBPagingData
import javax.inject.Inject

class IMDBRepositoryImpl @Inject constructor(private val remote : RemoteDataSource) : IMDBRepository{

    override suspend fun fetchData(): PagingSource<Int, IMDBDetails> {
        return IMDBPagingData(remote)
    }
}
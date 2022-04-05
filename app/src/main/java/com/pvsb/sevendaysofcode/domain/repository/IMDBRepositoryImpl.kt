package com.pvsb.sevendaysofcode.domain.repository

import androidx.paging.PagingSource
import com.pvsb.core.model.IMDBDetails
import com.pvsb.sevendaysofcode.framework.data.datasource.RemoteDataSource
import com.pvsb.sevendaysofcode.domain.pagingdata.IMDBPagingData
import javax.inject.Inject

class IMDBRepositoryImpl @Inject constructor(private val remote : RemoteDataSource) : IMDBRepository{

    override fun fetchData(): PagingSource<Int, IMDBDetails> {
        return IMDBPagingData(remote)
    }
}
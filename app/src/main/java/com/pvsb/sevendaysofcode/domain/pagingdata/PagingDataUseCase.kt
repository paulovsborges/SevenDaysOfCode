package com.pvsb.sevendaysofcode.domain.pagingdata

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pvsb.core.model.IMDBDetails
import com.pvsb.sevendaysofcode.domain.repository.IMDBRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PagingDataUseCase @Inject constructor(private val repository: IMDBRepository) {

    fun fetchData(config: PagingConfig): Flow<PagingData<IMDBDetails>> {

        val pagingSource = repository.fetchData()

        val response = Pager(config = config) {
            pagingSource
        }.flow

        return response
    }
}
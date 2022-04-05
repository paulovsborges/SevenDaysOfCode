package com.pvsb.sevendaysofcode.domain.pagingdata

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pvsb.core.model.IMDBDetails
import com.pvsb.sevendaysofcode.framework.data.datasource.RemoteDataSource
import javax.inject.Inject

class IMDBPagingData @Inject constructor(
    private val remote: RemoteDataSource
) : PagingSource<Int, IMDBDetails>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, IMDBDetails> {
        return try {

            val response = remote.fetchData()

            LoadResult.Page(
                response.items,
                null, null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, IMDBDetails>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(20) ?: anchorPage?.nextKey?.minus(20)
        }
    }
}
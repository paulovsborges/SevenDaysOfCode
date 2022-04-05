package com.pvsb.sevendaysofcode.framework.repository

import androidx.paging.PagingSource
import com.pvsb.core.model.IMDBDetails

interface IMDBRepository {

    fun fetchData(): PagingSource<Int, IMDBDetails>
}
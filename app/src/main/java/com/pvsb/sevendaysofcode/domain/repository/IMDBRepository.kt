package com.pvsb.sevendaysofcode.domain.repository

import androidx.paging.PagingSource
import com.pvsb.core.model.IMDBDetails

interface IMDBRepository {

    fun fetchData(): PagingSource<Int, IMDBDetails>
}
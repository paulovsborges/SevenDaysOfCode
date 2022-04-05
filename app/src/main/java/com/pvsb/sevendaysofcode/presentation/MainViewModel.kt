package com.pvsb.sevendaysofcode.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pvsb.core.model.IMDBDetails
import com.pvsb.sevendaysofcode.domain.pagingdata.PagingDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: PagingDataUseCase) : ViewModel() {

    fun fetchData(): Flow<PagingData<IMDBDetails>> {

        return useCase.fetchData(getPagingConfig())
            .cachedIn(viewModelScope)
    }

    private fun getPagingConfig(): PagingConfig {
        return PagingConfig(20)
    }
}
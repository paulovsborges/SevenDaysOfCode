package com.pvsb.sevendaysofcode.framework.data.di

import com.pvsb.sevendaysofcode.framework.data.datasource.RemoteDataSource
import com.pvsb.sevendaysofcode.framework.data.datasource.RemoteDataSourceImpl
import com.pvsb.sevendaysofcode.framework.repository.IMDBRepository
import com.pvsb.sevendaysofcode.framework.repository.IMDBRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideRemoteDataSourceImpl(impl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    fun provideRepositoryImpl(impl: IMDBRepositoryImpl): IMDBRepository
}
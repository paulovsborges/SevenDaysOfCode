package com.pvsb.sevendaysofcode.framework.data.di

import com.pvsb.sevendaysofcode.framework.data.service.IMDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Provides
    fun authInterceptor(): Interceptor = Interceptor {

        val originalReq = it.request()
        val url = originalReq.url.newBuilder()
            .addQueryParameter("apiKey", "k_3qxfv21y")
            .build()

        val request = originalReq.newBuilder()
            .url(url)
            .build()

        it.proceed(request)
    }

    @Provides
    fun provideOkHttp(): OkHttpClient = OkHttpClient().newBuilder().apply {
        connectTimeout(15L, TimeUnit.SECONDS)
        readTimeout(15L, TimeUnit.SECONDS)
        writeTimeout(15L, TimeUnit.SECONDS)
        addInterceptor(authInterceptor())

        val logInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        addInterceptor(logInterceptor)

    }.build()

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://imdb-api.com/en/API/Top250Movies/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideService(retrofit: Retrofit): IMDBService = retrofit.create(IMDBService::class.java)
}
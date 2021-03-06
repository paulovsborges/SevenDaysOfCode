package com.pvsb.sevendaysofcode.framework.data.di

import com.pvsb.sevendaysofcode.BuildConfig
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
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private fun authInterceptor(): Interceptor = Interceptor {

        val originalReq = it.request()
        val url = originalReq.url.newBuilder()
            .addQueryParameter("apiKey", BuildConfig.API_KEY)
            .build()

        val request = originalReq.newBuilder()
            .url(url)
            .build()

        it.proceed(request)
    }

    @Provides
    @Singleton
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
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideService(retrofit: Retrofit): IMDBService = retrofit.create(IMDBService::class.java)
}
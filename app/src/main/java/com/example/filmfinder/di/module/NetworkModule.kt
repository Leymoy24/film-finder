package com.example.filmfinder.di.module

import com.example.filmfinder.data.network.ApiRoutes
import com.example.filmfinder.data.network.ApiService
import com.example.filmfinder.data.source.Constants
import com.example.filmfinder.di.scope.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {
    @Provides
    @AppScope
    fun provideLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @AppScope
    fun provideOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()

            .addInterceptor(logger)
            .addInterceptor { chain ->
                try {
                    val request = chain.request().newBuilder().addHeader("X-API-KEY", Constants.API_KEY).build()
                    chain.proceed(request)
                } catch (e: SocketTimeoutException) {
                    // Обработка исключения
                    throw IOException("Превышено время ожидания ответа от сервера", e)
                }
            }
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @AppScope
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(ApiRoutes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @AppScope
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
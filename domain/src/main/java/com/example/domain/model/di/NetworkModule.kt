package com.example.domain.model.di

import com.example.data.model.remote.ApiDetails
import com.example.data.model.remote.NewsService
import com.example.data.model.repository.NewsRepository
import com.example.data.model.repository.NewsRepositoryImpl


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module // defines the imports for HILT -> What needs to be injected
@InstallIn(SingletonComponent::class) //defines the scope of those injections defined here
class NetworkModule {
    //OkHttp - Loggers - Interceptors
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

    }
    //Retrofit -Builder
    @Provides
    fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(ApiDetails.BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .client(client)
        .build()

    //API class
    @Provides
    fun provideApiCall(retrofit: Retrofit): NewsService = retrofit.create(NewsService::class.java)
    //Repository

    @Provides
    fun provideRepository(api: NewsService): NewsRepository = NewsRepositoryImpl(api)
}


//    @Singleton
//    @Provides
//    fun provideUseCase(
//        peopleRepository: PeopleRepository
//    ): FetchAllPeopleUseCase {
//        return FetchAllPeopleUseCaseImpl(peopleRepository)
//    }
//}
package com.example.horoscapp.data.network

import com.example.horoscapp.BuildConfig.BASE_URL
import com.example.horoscapp.data.RepositoryImpl
import com.example.horoscapp.data.core.interceptors.AuthInterceptors
import com.example.horoscapp.domain.model.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Alcance del Modulo, si se quiere q todos puedan acceder se usa SingletonComponent::class
class NetworkModule {

    @Provides
    @Singleton //Se cree una unica vez el objeto
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        var retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptors: AuthInterceptors): OkHttpClient{
        var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(authInterceptors)
                .build()
    }

    @Provides
    fun provideHeroscopeApiService(retrofit: Retrofit): HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService): Repository{
        return  RepositoryImpl(apiService)
    }
}
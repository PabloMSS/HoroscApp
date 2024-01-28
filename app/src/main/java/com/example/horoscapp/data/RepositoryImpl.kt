package com.example.horoscapp.data


import android.util.Log
import com.example.horoscapp.data.network.HoroscopeApiService
import com.example.horoscapp.data.network.response.PredictionResponse
import com.example.horoscapp.domain.PredictionModel
import com.example.horoscapp.domain.model.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService): Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        //Forma de ejecutar tareas
        kotlin.runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Prueba", "Error") }
        return null
    }
}
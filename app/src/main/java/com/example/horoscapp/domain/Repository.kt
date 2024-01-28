package com.example.horoscapp.domain.model

import com.example.horoscapp.data.network.response.PredictionResponse
import com.example.horoscapp.domain.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}
package com.example.horoscapp.domain.usecase

import com.example.horoscapp.domain.model.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    // Con operator invoke hacemos que el método no tenga nombre
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}
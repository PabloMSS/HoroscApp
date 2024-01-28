package com.example.horoscapp.domain

import com.google.gson.annotations.SerializedName

data class PredictionModel(
    val date: String,
    val horoscope: String,
    val sign: String
)
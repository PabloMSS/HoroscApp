package com.example.horoscapp.data.network.response

import com.example.horoscapp.domain.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse (
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
){
    //Función de Extensión -> Solo funciona para el tipo de valor predeterminado, en este caso, PredictionResponse
    fun toDomain(): PredictionModel{
        return PredictionModel(
            date = date,
            horoscope = horoscope,
             sign = sign
        )
    }
}
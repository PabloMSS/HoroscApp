package com.example.horoscapp.ui.detail

import com.example.horoscapp.domain.model.HoroscopeModel
import com.example.horoscapp.ui.horoscope.HoroscopeViewModel

sealed class HoroscopeDetailState {
    data object Loading: HoroscopeDetailState()
    data class Error(val error: String): HoroscopeDetailState()
    data class Success(val horoscope: String, val sing: String, val horoscopeModel: HoroscopeModel): HoroscopeDetailState()
}
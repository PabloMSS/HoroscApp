package com.example.horoscapp.domain.model

import com.example.horoscapp.R

sealed class HoroscopeInfo(val img:Int, val name:Int){
    object Aries: HoroscopeInfo(R.drawable.aquario, R.string.aries)
    object Taurus: HoroscopeInfo(R.drawable.aquario, R.string.taurus)
    object Gemini: HoroscopeInfo(R.drawable.aquario, R.string.gemini)
    object Cancer: HoroscopeInfo(R.drawable.aquario, R.string.cancer)
    object Leo: HoroscopeInfo(R.drawable.aquario, R.string.leo)
    object Virgo: HoroscopeInfo(R.drawable.aquario, R.string.virgo)
    object Libra: HoroscopeInfo(R.drawable.aquario, R.string.libra)
    object Scorpio: HoroscopeInfo(R.drawable.aquario, R.string.scorpio)
    object Sagittarius: HoroscopeInfo(R.drawable.aquario, R.string.sagittarius)
    object Capricorn: HoroscopeInfo(R.drawable.aquario, R.string.capricorn)
    object Aquarius: HoroscopeInfo(R.drawable.aquario, R.string.aquarius)
    object Pisces: HoroscopeInfo(R.drawable.aquario, R.string.pisces)

}
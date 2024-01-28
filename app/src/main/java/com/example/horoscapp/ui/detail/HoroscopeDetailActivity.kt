package com.example.horoscapp.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navArgs
import com.example.horoscapp.R
import com.example.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.example.horoscapp.domain.model.HoroscopeInfo
import com.example.horoscapp.domain.model.HoroscopeModel
import com.example.horoscapp.ui.horoscope.HoroscopeFragment
import com.example.horoscapp.ui.horoscope.HoroscopeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type.name)
    }

    fun initUI(){
        iniUIState()
        returnHoroscopeFragment()
    }

    fun iniUIState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect{
                    when(it){
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    fun loadingState(){
        binding.pb.isVisible = true
    }

    fun errorState(){
        binding.pb.isVisible = false
    }

    fun successState(state: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sing
        binding.tvBody.text = state.horoscope
        binding.ivDetail.setImageResource(setImg())
    }

    fun setImg(): Int {
        var prueba = when(args.type.name){
            "Aries" -> R.drawable.detail_aries
            "Taurus" -> R.drawable.detail_taurus
            "Gemini" -> R.drawable.detail_gemini
            "Cancer" -> R.drawable.detail_cancer
            "Leo" -> R.drawable.detail_leo
            "Virgo" -> R.drawable.detail_virgo
            "Libra" -> R.drawable.detail_libra
            "Scorpio" -> R.drawable.detail_scorpio
            "Sagittarius" -> R.drawable.detail_sagittarius
            "Capricorn" -> R.drawable.detail_capricorn
            "Aquarius" -> R.drawable.detail_aquarius
            "Pisces" -> R.drawable.detail_pisces
            else -> {
                R.drawable.detail_aries
            }
        }
        return prueba
    }

    fun returnHoroscopeFragment(){
        binding.ivBack.setOnClickListener {

        }
    }
}
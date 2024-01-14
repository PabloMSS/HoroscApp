package com.example.horoscapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.horoscapp.R
import com.example.horoscapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
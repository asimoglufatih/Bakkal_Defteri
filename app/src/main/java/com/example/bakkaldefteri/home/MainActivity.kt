package com.example.bakkaldefteri.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bakkaldefteri.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    }
}
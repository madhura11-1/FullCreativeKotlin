package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainServiceBinding

class MainActivityService : AppCompatActivity() {

    private lateinit var binding : ActivityMainServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener(){
            startService(Intent(this, Services::class.java))
        }

        binding.stopButton.setOnClickListener(){

            stopService(Intent(this,Services::class.java))
        }
    }
}
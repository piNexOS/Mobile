package com.example.nexosmobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nexosmobile.databinding.ActivityEsqueciSenhaBinding
import com.example.nexosmobile.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSair.setOnClickListener(){
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }

        }
    }
}
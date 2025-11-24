package com.example.nexosmobile.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nexosmobile.ui.auth.LoginFragment
import com.example.nexosmobile.databinding.ActivityEsqueciSenhaBinding

class EsqueciSenhaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEsqueciSenhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEsqueciSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTrocarSenha.setOnClickListener(){
            Intent(this, LoginFragment::class.java).also {
                startActivity(it)
            }

        }
    }
}
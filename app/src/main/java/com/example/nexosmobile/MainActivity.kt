package com.example.nexosmobile

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils // Importe para usar AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.nexosmobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Carregar a animação slide_up
        val slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.move_upp)

        // 2. Aplicar a animação ao LinearLayout2
        binding.linearLayout2.startAnimation(slideUpAnimation)

        // Configuração dos Listeners (mantidos)
        binding.btnEntrar.setOnClickListener {
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.tvEsqueceuSenha.setOnClickListener {
            Intent(this, EsqueciSenhaActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
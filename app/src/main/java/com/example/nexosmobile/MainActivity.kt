package com.example.nexosmobile

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.nexosmobile.BaseActivity
import com.example.nexosmobile.databinding.ActivityMainBinding
import com.example.nexosmobile.ui.auth.EsqueciSenhaActivity

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.move_upp)

        binding.linearLayout2.startAnimation(slideUpAnimation)

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
package com.example.nexosmobile.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.nexosmobile.ui.auth.EsqueciSenhaActivity
import com.example.nexosmobile.HomeActivity
import com.example.nexosmobile.R
import com.example.nexosmobile.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity




class LoginFragment : Fragment() {


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
    }}
    }

}
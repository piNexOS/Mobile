package com.example.nexosmobile.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.nexosmobile.MainActivity
import com.example.nexosmobile.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logoImage)
        val moveUp = AnimationUtils.loadAnimation(this, R.anim.move_up)
        logo.startAnimation(moveUp)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            @Suppress("DEPRECATION")
            overridePendingTransition(0, 0)

            finish()
        }, 1000)


    }
}
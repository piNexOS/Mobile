package com.example.nexosmobile

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.nexosmobile.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Sublinhar o item "Sair da conta"
        val menu = binding.navigationView.menu
        val sairItem = menu.findItem(R.id.nav_sair)
        if (sairItem != null) {
            val content = SpannableString(sairItem.title)
            content.setSpan(UnderlineSpan(), 0, content.length, 0)
            sairItem.title = content
        }

        binding.navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_agente -> {
                    // Apenas informativo, sem ação
                }

                R.id.nav_id -> {
                    // Apenas informativo, sem ação
                }

                R.id.nav_sair -> {
                   Intent(this, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }

            // fecha o menu após clicar
            binding.drawerLayout.closeDrawer(Gravity.START)

            true
        }

        binding.btnSair.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnAcessar.setOnClickListener {
            Toast.makeText(this, "Acessar Resumo clicado", Toast.LENGTH_SHORT).show()
        }
    }
}

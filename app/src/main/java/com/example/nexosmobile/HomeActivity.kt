package com.example.nexosmobile

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.nexosmobile.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar sem o toggle padrão


        // ABRIR MENU PELO BOTÃO DE BARRINHAS
        binding.btnMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        // Substituir título “Sair da conta” com underline
        val menu = binding.navigationView.menu
        val sairItem = menu.findItem(R.id.nav_sair)

        sairItem?.let {
            val styled = SpannableString(it.title)
            styled.setSpan(UnderlineSpan(), 0, styled.length, 0)
            it.title = styled
        }

        // CLIQUE NOS ITENS DO MENU
        binding.navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_agente -> {
                    Toast.makeText(this, "Agente clicado", Toast.LENGTH_SHORT).show()
                }

                R.id.nav_id -> {
                    Toast.makeText(this, "Id clicado", Toast.LENGTH_SHORT).show()
                }

                R.id.nav_sair -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }

            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Botão sair da tela principal
        binding.btnSair.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Botão acessar
        binding.btnAcessar.setOnClickListener {
            Toast.makeText(this, "Acessar Resumo clicado", Toast.LENGTH_SHORT).show()
        }
    }
}
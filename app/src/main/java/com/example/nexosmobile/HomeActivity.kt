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

        // --- ABRIR MENU ---
        binding.btnMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        // --- ESTILIZAR "SAIR" COM SUBLINHADO ---
        val sairItem = binding.navigationView.menu.findItem(R.id.nav_sair)
        sairItem?.let {
            val styled = SpannableString(it.title)
            styled.setSpan(UnderlineSpan(), 0, styled.length, 0)
            it.title = styled
        }

        // --- LISTENER DO MENU ---
        binding.navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_agente -> {
                    Toast.makeText(this, "Agente clicado", Toast.LENGTH_SHORT).show()
                }

                R.id.nav_id -> {
                    Toast.makeText(this, "ID clicado", Toast.LENGTH_SHORT).show()
                }

                R.id.nav_sair -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // ==================================================================
        //                     🔥 AQUI É A ALTERAÇÃO IMPORTANTE 🔥
        // ==================================================================

        // 1. Criar lista falsa de resumos (por enquanto sem BD)
        val listaFake = arrayListOf(
            Resumo("Resumo do dia", "Rotina inicial", "Coisas importantes", 3),
            Resumo("Semana", "Visão geral", "Atividades pendentes", 5),
            Resumo("Financeiro", "Gastos", "Resumo rápido", 1),
            Resumo("Semana", "Visão geral", "Atividades pendentes", 5),
            Resumo("Financeiro", "Gastos", "Resumo rápido", 1),
            Resumo("Semana", "Visão geral", "Atividades pendentes", 5),
            Resumo("Financeiro", "Gastos", "Resumo rápido", 1),
            Resumo("Semana", "Visão geral", "Atividades pendentes", 5),
            Resumo("Financeiro", "Gastos", "Resumo rápido", 1),
        )

        // 2. Carregar o fragment já com a lista
        val fragment = ResumoFragment.newInstance(listaFake)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()

        // ==================================================================
        // ==================================================================

        // --- BOTÃO DE ACESSAR ---
        binding.btnAcessar.setOnClickListener {
            Toast.makeText(this, "Acessar Resumo clicado", Toast.LENGTH_SHORT).show()
        }
    }
}

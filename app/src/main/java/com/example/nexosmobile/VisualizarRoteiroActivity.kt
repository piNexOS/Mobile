package com.example.nexosmobile

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.nexosmobile.databinding.ActivityVisualizarRoteiroBinding

class VisualizarRoteiroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVisualizarRoteiroBinding
    private lateinit var roteiroAtual: Resumo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisualizarRoteiroBinding.inflate(layoutInflater)
        setContentView(binding.root)


        roteiroAtual = intent.getParcelableExtra("roteiro_extra") ?: return

        setupUI()
        setupClicks()


        abrirFragment(OrdensConcluidasFragment.newInstance(roteiroAtual.titulo))
    }

    private fun setupUI() {
        binding.tvTituloRoteiro.text = roteiroAtual.titulo
        atualizarBotoes(isConcluidas = true)
    }

    private fun setupClicks() {
        binding.btnVoltar.setOnClickListener {
            finish()
        }

        binding.btnTabConcluidas.setOnClickListener {
            atualizarBotoes(isConcluidas = true)
            abrirFragment(OrdensConcluidasFragment.newInstance(roteiroAtual.titulo))
        }

        binding.btnTabPendentes.setOnClickListener {
            atualizarBotoes(isConcluidas = false)
            abrirFragment(OrdensPendentesFragment.newInstance(roteiroAtual.titulo))
        }
    }

    private fun atualizarBotoes(isConcluidas: Boolean) {
        val azulAtivo = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.azul_1))
        val cinzaInativo = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.azul_2)) // ou outra cor inativa

        if (isConcluidas) {
            binding.btnTabConcluidas.backgroundTintList = azulAtivo
            binding.btnTabConcluidas.setTextColor(ContextCompat.getColor(this, android.R.color.white))

            binding.btnTabPendentes.backgroundTintList = cinzaInativo
            binding.btnTabPendentes.setTextColor(ContextCompat.getColor(this, android.R.color.black))
        } else {
            binding.btnTabConcluidas.backgroundTintList = cinzaInativo
            binding.btnTabConcluidas.setTextColor(ContextCompat.getColor(this, android.R.color.black))

            binding.btnTabPendentes.backgroundTintList = azulAtivo
            binding.btnTabPendentes.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        }
    }

    private fun abrirFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerRoteiro, fragment)
            .commit()
    }
}
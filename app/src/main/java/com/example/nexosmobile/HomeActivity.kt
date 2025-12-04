package com.example.nexosmobile

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nexosmobile.BaseActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.nexosmobile.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    private var verTodosFragment: VerTodosFragment? = null
    private var mostrandoResumo = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarMenu()

        abrirTelaResumo()

        binding.btnAcessar.setOnClickListener {
            if (mostrandoResumo) {
                abrirTelaVerTodos()
            } else {
                abrirTelaResumo()
            }
        }
    }
    private fun abrirTelaVerTodos() {
        mostrandoResumo = false


        val listaInicial = ResumoRepository.getFuturos()


        verTodosFragment = VerTodosFragment.newInstance(listaInicial)


        val headerRoteiros = HeaderRoteirosFragment()


        headerRoteiros.quandoClicarEmFiltro = { filtro ->

            val novaLista = if (filtro == "FUTUROS") {
                ResumoRepository.getFuturos()
            } else {
                ResumoRepository.getPassados()
            }


            verTodosFragment?.atualizarLista(novaLista)
        }


        trocarFragmentConteudo(verTodosFragment!!)
        trocarHeader(headerRoteiros)


        binding.titleHome.text = "Roteiros Diários"
        binding.btnAcessar.text = "Voltar ao resumo"
    }

    private fun abrirTelaResumo() {
        mostrandoResumo = true

        val listaResumos = ResumoRepository.getResumosFake()
        val resumoFragment = ResumoFragment.newInstance(listaResumos)

        trocarFragmentConteudo(resumoFragment)
        trocarHeader(HeaderResumoFragment())

        binding.titleHome.text = "Resumo"
        binding.btnAcessar.text = "Ver todos"
    }



    private fun trocarFragmentConteudo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun trocarHeader(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHeader, fragment)
            .commit()
    }

    private fun configurarMenu() {
        binding.btnMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        val sairItem = binding.navigationView.menu.findItem(R.id.nav_sair)
        sairItem?.let {
            val styled = SpannableString(it.title)
            styled.setSpan(UnderlineSpan(), 0, styled.length, 0)
            it.title = styled
        }

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
    }
}

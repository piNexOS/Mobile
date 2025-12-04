package com.example.nexosmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.nexosmobile.databinding.HeaderRoteirosBinding

class HeaderRoteirosFragment : Fragment() {

    private var _binding: HeaderRoteirosBinding? = null
    private val binding get() = _binding!!


    var quandoClicarEmFiltro: ((String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HeaderRoteirosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        atualizarEstiloBotoes(futuroAtivo = true)

        binding.btnFuturos.setOnClickListener {
            atualizarEstiloBotoes(futuroAtivo = true)
            quandoClicarEmFiltro?.invoke("FUTUROS")
        }

        binding.btnPassados.setOnClickListener {
            atualizarEstiloBotoes(futuroAtivo = false)
            quandoClicarEmFiltro?.invoke("PASSADOS")
        }
    }

    private fun atualizarEstiloBotoes(futuroAtivo: Boolean) {
        val context = requireContext()
        val azulAtivo = ContextCompat.getColorStateList(context, R.color.azul_1) // Use suas cores reais
        val cinzaInativo = ContextCompat.getColorStateList(context, R.color.azul_2) // Ou cor inativa

        if (futuroAtivo) {

            binding.btnFuturos.backgroundTintList = azulAtivo
            binding.btnPassados.backgroundTintList = cinzaInativo
        } else {

            binding.btnFuturos.backgroundTintList = cinzaInativo
            binding.btnPassados.backgroundTintList = azulAtivo
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.nexosmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nexosmobile.databinding.HeaderResumoBinding

class HeaderResumoFragment : Fragment() {

    private var _binding: HeaderResumoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HeaderResumoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 👉 Exemplo: Dados falsos (você futuramente pega do BD)
        val nome = "Guilherme Ferrari"
        val empresa = "NexEmpresa"
        val idUsuario = "12345"

        binding.txtNome.text = nome
        binding.txtEmpresaId.text = "$empresa  •  ID: $idUsuario"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
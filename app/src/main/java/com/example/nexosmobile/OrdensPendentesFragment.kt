package com.example.nexosmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nexosmobile.databinding.FragmentOrdensPendentesBinding

class OrdensPendentesFragment : Fragment() {

    private var _binding: FragmentOrdensPendentesBinding? = null
    private val binding get() = _binding!!
    private var roteiroTitulo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roteiroTitulo = arguments?.getString("roteiro_titulo")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrdensPendentesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todasOrdens = ResumoRepository.getOrdensPorRoteiro(roteiroTitulo ?: "")
        val pendentes = todasOrdens.filter { it.status == "PENDENTE" }

        binding.recyclerPendentes.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerPendentes.adapter = OrdemServicoAdapter(pendentes) { ordem ->
            Toast.makeText(requireContext(), "Visualizar: ${ordem.titulo}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(titulo: String) = OrdensPendentesFragment().apply {
            arguments = Bundle().apply { putString("roteiro_titulo", titulo) }
        }
    }
}
package com.example.nexosmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nexosmobile.databinding.FragmentOrdensConcluidasBinding

class OrdensConcluidasFragment : Fragment() {

    private var _binding: FragmentOrdensConcluidasBinding? = null
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
        _binding = FragmentOrdensConcluidasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val todasOrdens = ResumoRepository.getOrdensPorRoteiro(roteiroTitulo ?: "")


        val finalizadas = todasOrdens.filter { it.status == "FINALIZADA" }
        val rejeitadas = todasOrdens.filter { it.status == "REJEITADA" }


        binding.recyclerFinalizadas.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerFinalizadas.adapter = OrdemServicoAdapter(finalizadas) { ordem ->

            Toast.makeText(requireContext(), "Visualizar: ${ordem.titulo}", Toast.LENGTH_SHORT).show()
        }


        binding.recyclerRejeitadas.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerRejeitadas.adapter = OrdemServicoAdapter(rejeitadas) { ordem ->
            Toast.makeText(requireContext(), "Visualizar: ${ordem.titulo}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(titulo: String) = OrdensConcluidasFragment().apply {
            arguments = Bundle().apply { putString("roteiro_titulo", titulo) }
        }
    }
}
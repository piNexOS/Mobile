package com.example.nexosmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nexosmobile.databinding.FragmentVerTodosBinding


class VerTodosFragment : Fragment() {

    private var _binding: FragmentVerTodosBinding? = null
    private val binding get() = _binding!!

    private lateinit var lista: ArrayList<Resumo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lista = arguments?.getParcelableArrayList("lista_resumos") ?: arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerTodosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerVerTodos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerVerTodos.adapter = ResumoAdapter(lista)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun atualizarLista(novaLista: ArrayList<Resumo>) {

        val adapter = binding.recyclerVerTodos.adapter as? ResumoAdapter
        adapter?.atualizarDados(novaLista)
    }

    companion object {
        fun newInstance(lista: ArrayList<Resumo>): VerTodosFragment {
            val fragment = VerTodosFragment()
            val args = Bundle()
            args.putParcelableArrayList("lista_resumos", lista)
            fragment.arguments = args
            return fragment
        }
    }

}

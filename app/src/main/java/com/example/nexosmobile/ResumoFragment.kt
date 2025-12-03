package com.example.nexosmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResumoFragment : Fragment() {

    private var resumos: ArrayList<Resumo>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resumos = arguments?.getParcelableArrayList(ARG_LISTA) ?: arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resumo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val container = view.findViewById<LinearLayout>(R.id.containerResumos)
        val inflater = LayoutInflater.from(requireContext())

        // limpa só por garantia
        container.removeAllViews()

        // se não houver resumos, mostra texto
        if (resumos.isNullOrEmpty()) {
            val tvEmpty = TextView(requireContext()).apply {
                text = "Nenhum resumo disponível"
                textSize = 16f
            }
            container.addView(tvEmpty)
            return
        }

        // para cada resumo, inflamos item_resumo e setamos os dados
        for (res in resumos!!) {
            val item = inflater.inflate(R.layout.item_resumo, container, false)

            val tvTitulo = item.findViewById<TextView>(R.id.tvTitulo)
            val tvSub = item.findViewById<TextView>(R.id.tvSub)
            val tvDesc = item.findViewById<TextView>(R.id.tvDesc)
            val tvPend = item.findViewById<TextView>(R.id.tvPend)

            tvTitulo.text = res.titulo
            tvSub.text = res.subtitulo
            tvDesc.text = res.descricao
            tvPend.text = "Pendências: ${res.pendencias}"

            container.addView(item)
        }
    }

    companion object {
        private const val ARG_LISTA = "lista_resumos"

        fun newInstance(lista: ArrayList<Resumo>): ResumoFragment {
            val frag = ResumoFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_LISTA, lista)
            frag.arguments = args
            return frag
        }
    }
}

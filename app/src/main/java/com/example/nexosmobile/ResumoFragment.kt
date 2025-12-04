package com.example.nexosmobile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
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
        super.onViewCreated(view, savedInstanceState) // Boa prática chamar o super

        val container = view.findViewById<LinearLayout>(R.id.containerResumos)
        val inflater = LayoutInflater.from(requireContext())
        val corTexto = ContextCompat.getColor(requireContext(), R.color.corTexto)

        container.removeAllViews()

        if (resumos.isNullOrEmpty()) {
            val tvEmpty = TextView(requireContext()).apply {
                text = "Nenhum resumo disponível"
                textSize = 16f
            }
            container.addView(tvEmpty)
            return
        }

        // ALTERAÇÃO AQUI: Usando forEachIndexed para ter acesso ao índice (posição)
        resumos?.forEachIndexed { index, res ->
            val item = inflater.inflate(R.layout.item_resumo, container, false)

            // Referências aos componentes do layout item_resumo.xml
            val tvTitulo = item.findViewById<TextView>(R.id.tvTitulo)
            val tvSub = item.findViewById<TextView>(R.id.tvSub)
            val tvPend = item.findViewById<TextView>(R.id.tvPend)
            val tvNumero = item.findViewById<TextView>(R.id.tvNumero) // Referência ao número grande

            // Lógica dos textos
            tvTitulo.text = res.titulo
            tvSub.text = res.subtitulo
            tvPend.text = "Pendências: ${res.pendencias}"

            // Lógica para o número começar em 5 e aumentar (5, 6, 7...)
            val numeroCalculado = index + 5
            tvNumero.text = numeroCalculado.toString()

            // Cores
            tvTitulo.setTextColor(corTexto)
            tvSub.setTextColor(corTexto)
            tvPend.setTextColor(corTexto)
            tvNumero.setTextColor(corTexto) // Garante que o número também pegue a cor certa

            // Clique no card
            item.setOnClickListener {
                val intent = Intent(requireContext(), VisualizarRoteiroActivity::class.java)
                intent.putExtra("roteiro_extra", res)
                startActivity(intent)
            }

            container.addView(item)
        }
    }

    // Função utilitária (se você estiver usando em outro lugar, pode manter)
    fun Int.dpToPx(context: Context): Int =
        (this * context.resources.displayMetrics.density).toInt()

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
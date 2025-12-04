package com.example.nexosmobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nexosmobile.databinding.ItemResumo2Binding

class ResumoAdapter(
    private var lista: ArrayList<Resumo>,
    private val aoClicarNoRoteiro: (Resumo) -> Unit
) : RecyclerView.Adapter<ResumoAdapter.ResumoViewHolder>() {

    inner class ResumoViewHolder(val binding: ItemResumo2Binding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemResumo2Binding.inflate(inflater, parent, false)
        return ResumoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResumoViewHolder, position: Int) {
        val item = lista[position]

        // Preenche os textos normais
        holder.binding.tvTitulo.text = item.titulo
        holder.binding.tvSub.text = item.subtitulo
        holder.binding.tvPend.text = "${item.pendencias}"

        // --- LÓGICA DO NÚMERO ---
        // Tenta extrair o dia do título (Ex: "Roteiro 04/07" -> Pega o "04")
        try {
            val diaDoTitulo = item.titulo
                .substringAfter(" ")  // Pega o texto depois do espaço ("04/07")
                .substringBefore("/") // Pega o texto antes da barra ("04")

            holder.binding.tvNumero.text = diaDoTitulo
        } catch (e: Exception) {
            // Se o título não tiver esse padrão, usa a regra antiga (posição + 5)
            val numeroSequencial = position + 5
            holder.binding.tvNumero.text = numeroSequencial.toString()
        }
        // ------------------------

        // Configura o clique
        holder.itemView.setOnClickListener {
            aoClicarNoRoteiro(item)
        }
    }

    override fun getItemCount(): Int = lista.size

    fun atualizarDados(novaLista: List<Resumo>) {
        lista.clear()
        lista.addAll(novaLista)
        notifyDataSetChanged()
    }
}
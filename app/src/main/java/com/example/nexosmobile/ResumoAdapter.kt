package com.example.nexosmobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nexosmobile.databinding.ItemResumo2Binding

class ResumoAdapter(
    private var lista: ArrayList<Resumo>,
    private val aoClicarNoRoteiro: (Resumo) -> Unit // Callback de clique
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

        holder.binding.tvTitulo.text = item.titulo
        holder.binding.tvSub.text = item.subtitulo
        holder.binding.tvPend.text = "${item.pendencias}"
        // Nota: Ajustei tvPend para só o número, pois no seu XML novo tem o ícone do relógio ao lado

        // AÇÃO DE CLIQUE
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
package com.example.nexosmobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nexosmobile.databinding.ItemResumoBinding

class ResumoAdapter(
    private val lista: List<Resumo>
) : RecyclerView.Adapter<ResumoAdapter.ResumoViewHolder>() {

    inner class ResumoViewHolder(val binding: ItemResumoBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemResumoBinding.inflate(inflater, parent, false)
        return ResumoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResumoViewHolder, position: Int) {
        val item = lista[position]

        holder.binding.tvTitulo.text = item.titulo
        holder.binding.tvSub.text = item.subtitulo
        holder.binding.tvPend.text = "Pendências: ${item.pendencias}"
    }

    override fun getItemCount(): Int = lista.size
}

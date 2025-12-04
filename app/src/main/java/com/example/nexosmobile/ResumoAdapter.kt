package com.example.nexosmobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
// Importante: certifique-se de importar o binding do item 2
import com.example.nexosmobile.databinding.ItemResumo2Binding

class ResumoAdapter(
    private var lista: ArrayList<Resumo> // Mudamos para var para poder alterar
) : RecyclerView.Adapter<ResumoAdapter.ResumoViewHolder>() {

    // Agora usa ItemResumo2Binding
    inner class ResumoViewHolder(val binding: ItemResumo2Binding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // Infla o layout item_resumo2
        val binding = ItemResumo2Binding.inflate(inflater, parent, false)
        return ResumoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResumoViewHolder, position: Int) {
        val item = lista[position]

        // Ajuste conforme os IDs reais dentro de item_resumo2.xml
        holder.binding.tvTitulo.text = item.titulo
        holder.binding.tvSub.text = item.subtitulo
        holder.binding.tvPend.text = "${item.pendencias}"

        // Exemplo: Se tiver lógica de data/número no item_resumo2:
        // holder.binding.tvNumero.text = item.titulo.take(2)
    }

    override fun getItemCount(): Int = lista.size

    // Função mágica para atualizar a lista
    fun atualizarDados(novaLista: List<Resumo>) {
        lista.clear()
        lista.addAll(novaLista)
        notifyDataSetChanged()
    }
}
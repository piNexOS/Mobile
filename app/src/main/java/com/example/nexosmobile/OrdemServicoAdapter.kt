package com.example.nexosmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.nexosmobile.databinding.ItemOrdemServicoBinding

class OrdemServicoAdapter(
    private val lista: List<OrdemServico>,
    private val aoClicarEmVisualizar: (OrdemServico) -> Unit
) : RecyclerView.Adapter<OrdemServicoAdapter.OrdemViewHolder>() {

    inner class OrdemViewHolder(val binding: ItemOrdemServicoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OrdemServico) {
            binding.tvTituloServico.text = item.titulo
            binding.tvLocalizacao.text = item.localizacao

            // Controle do ícone de status
            when (item.status) {
                "FINALIZADA" -> binding.imgStatus.setImageResource(R.drawable.ic_check_circle) // Você precisará criar/ter esses ícones
                "REJEITADA" -> binding.imgStatus.setImageResource(R.drawable.ic_error_circle)
                else -> binding.imgStatus.setImageResource(R.drawable.relogioverde2)
            }

            // Lógica de Expandir/Contrair
            if (item.isExpandido) {
                binding.btnVisualizar.visibility = View.VISIBLE
                binding.containerCard.elevation = 8f // Dá um destaque visual
            } else {
                binding.btnVisualizar.visibility = View.GONE
                binding.containerCard.elevation = 2f
            }

            // Clique no CARD para expandir
            binding.root.setOnClickListener {
                item.isExpandido = !item.isExpandido
                notifyItemChanged(adapterPosition)
            }

            // Clique no BOTÃO VISUALIZAR
            binding.btnVisualizar.setOnClickListener {
                aoClicarEmVisualizar(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOrdemServicoBinding.inflate(inflater, parent, false)
        return OrdemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrdemViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size
}
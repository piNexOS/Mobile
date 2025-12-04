package com.example.nexosmobile

data class OrdemServico(
    val id: String,
    val titulo: String,
    val localizacao: String,
    val status: String, // "PENDENTE", "FINALIZADA", "REJEITADA"
    var isExpandido: Boolean = false // Controle para o efeito de "crescer" ao clicar
)
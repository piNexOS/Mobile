package com.example.nexosmobile

data class OrdemServico(
    val id: String,
    val titulo: String,
    val localizacao: String,
    val status: String,
    var isExpandido: Boolean = false
)
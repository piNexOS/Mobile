package com.example.nexosmobile

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resumo(
    val titulo: String,
    val subtitulo: String,
    val descricao: String,
    val pendencias: Int
) : Parcelable
package com.example.nexosmobile

object ResumoRepository {

    // Lista usada na tela inicial (Resumo)
    fun getResumosFake(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro Hoje", "03/07 - Sexta", "Urgente", 5),
            Resumo("Roteiro Amanhã", "04/07 - Sábado", "Planejado", 2)
        )
    }

    // Lista para o botão "Futuros"
    fun getFuturos(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro 03/07", "Sexta-feira", "Pendente", 5),
            Resumo("Roteiro 04/07", "Sábado", "Pendente", 8),
            Resumo("Roteiro 07/07", "Terça-feira", "Pendente", 7),
            Resumo("Roteiro 08/07", "Quarta-feira", "Pendente", 9)
        )
    }

    // Lista para o botão "Passados"
    fun getPassados(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro 01/07", "Quarta-feira", "Concluído", 0),
            Resumo("Roteiro 30/06", "Terça-feira", "Concluído", 0),
            Resumo("Roteiro 29/06", "Segunda-feira", "Concluído", 0)
        )
    }
}
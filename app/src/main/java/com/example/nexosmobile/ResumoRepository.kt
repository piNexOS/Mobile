package com.example.nexosmobile

object ResumoRepository {
    fun getResumosFake(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro A", "03/07 - Sexta", "Descrição curta do roteiro A", 2),
            Resumo("Roteiro B", "04/07 - Sábado", "Descrição curta do roteiro B", 0),
            Resumo("Resumo Diário", "05/07 - Domingo", "Resumo das atividades do dia", 1),
            Resumo("Roteiro C", "06/07 - Segunda", "Descrição curta do roteiro C", 3)
        )
    }
}

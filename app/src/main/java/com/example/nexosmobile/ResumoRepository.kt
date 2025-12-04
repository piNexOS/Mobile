package com.example.nexosmobile

object ResumoRepository {

    // --- Seus métodos anteriores continuam aqui (getResumosFake, getFuturos, etc) ---
    // Vou reescrever apenas para manter o contexto, mas o foco é o novo método lá embaixo

    fun getResumosFake(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro A", "03/07 - Sexta", "Urgente", 2),
            Resumo("Roteiro B", "04/07 - Sábado", "Planejado", 0)
        )
    }

    fun getFuturos(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro 03/07", "Sexta-feira", "Pendente", 5),
            Resumo("Roteiro 04/07", "Sábado", "Pendente", 8)
        )
    }

    fun getPassados(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro 01/07", "Quarta-feira", "Concluído", 0)
        )
    }


    fun getOrdensPorRoteiro(roteiroTitulo: String): List<OrdemServico> {
        // Retorna uma lista mista para testarmos os filtros
        return listOf(
            OrdemServico("1", "Serviço: Substituição Corretiva", "Localização: Soteco, Vila Velha", "FINALIZADA"),
            OrdemServico("2", "Serviço: Instalação Nova", "Localização: Itapuã, Vila Velha", "FINALIZADA"),
            OrdemServico("3", "Serviço: Deslocamento Padrão", "Localização: Centro, Vitória", "REJEITADA"),
            OrdemServico("4", "Serviço: Manutenção Preventiva", "Localização: Praia da Costa", "PENDENTE"),
            OrdemServico("5", "Serviço: Troca de Medidor", "Localização: Glória", "PENDENTE"),
            OrdemServico("6", "Serviço: Corte de Energia", "Localização: Coqueiral", "PENDENTE")
        )
    }
}
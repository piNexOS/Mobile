package com.example.nexosmobile

object ResumoRepository {



    fun getResumosFake(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro 05/12", "Sexta-feira", "Urgente", 2),
            Resumo("Roteiro 06/12", "Sábado", "Planejado", 0)
        )
    }

    fun getFuturos(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro 05/12", "Sexta-feira", "Pendente", 2),
            Resumo("Roteiro 06/12", "Sábado", "Pendente", 0)
        )
    }

    fun getPassados(): ArrayList<Resumo> {
        return arrayListOf(
            Resumo("Roteiro 04/07", "Quinta-feira", "Concluído", 4)
        )
    }


    fun getOrdensPorRoteiro(roteiroTitulo: String): List<OrdemServico> {
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
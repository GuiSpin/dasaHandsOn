package com.dasa.domain;

import lombok.Data;

@Data
public class EstatisticaAnoResponse {

	private final String ano;
	private final Double populacao;
	private final Double populacaoHomem;
	private final Double populacaoMulher;
	
	public EstatisticaAnoResponse(DadoPopulacional pop) {
		super();
		this.ano = pop.getAno();
		this.populacao = pop.getPopulacaoTotal().doubleValue();
		this.populacaoHomem = pop.getTotalHomens().doubleValue();
		this.populacaoMulher = pop.getTotalMulheres().doubleValue();
	}

	public String getAno() {
		return ano;
	}

	public Double getPopulacao() {
		return populacao;
	}

	public Double getPopulacaoHomem() {
		return ((populacaoHomem / populacao) * 100);
	}

	public Double getPopulacaoMulher() {
		return (populacaoMulher / populacao) * 100;
	}


}

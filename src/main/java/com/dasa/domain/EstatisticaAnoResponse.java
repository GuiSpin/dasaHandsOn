package com.dasa.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EstatisticaAnoResponse {

	private final String ano;
	private final BigDecimal populacao;
	private final Long populacaoHomem;
	private final Long populacaoMulher;
	
	public EstatisticaAnoResponse(DadoPopulacional pop) {
		super();
		this.ano = pop.getAno();
		this.populacao = pop.getPopulacaoTotal();
		this.populacaoHomem = pop.getTotalHomens();
		this.populacaoMulher = pop.getTotalMulheres();
	}

	public String getAno() {
		return ano;
	}

	public BigDecimal getPopulacao() {
		return populacao;
	}

	public Long getPopulacaoHomem() {
		return populacaoHomem;
	}

	public Long getPopulacaoMulher() {
		return populacaoMulher;
	}


}

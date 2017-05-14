package com.dasa.domain;

import com.dasa.enums.CAMPANHA_POR_SEXO;

public class ConsultaRetorno{
   
	private CAMPANHA_POR_SEXO nomeCampanha;
	private String ano;
	private Double qtdeParticipantes;
	
	public ConsultaRetorno() {
	}

	public CAMPANHA_POR_SEXO getNomeCampanha() {
		return nomeCampanha;
	}

	public void setNomeCampanha(CAMPANHA_POR_SEXO nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Double getQtdeParticipantes() {
		return qtdeParticipantes;
	}

	public void setQtdeParticipantes(Double qtdeParticipantes) {
		this.qtdeParticipantes = qtdeParticipantes;
	}

	@Override
	public String toString() {
		return "ConsultaRetorno [nomeCampanha=" + nomeCampanha + ", ano=" + ano + ", qtdeParticipantes="
				+ qtdeParticipantes + "]";
	};
	


	

}

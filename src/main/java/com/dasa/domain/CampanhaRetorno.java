package com.dasa.domain;

import com.dasa.enums.CAMPANHA_POR_SEXO;

public class CampanhaRetorno{
   
	private CAMPANHA_POR_SEXO nomeCampanha;
	private String sexo;
	private String ano;
	
	public CampanhaRetorno() {
	};
	
	public CampanhaRetorno(String tipoCampanha, String ano) {
		this.sexo = tipoCampanha;
		this.ano = ano;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getSexo() {
		return sexo;
	}

	public String getAno() {
		return ano;
	}

	public CAMPANHA_POR_SEXO getNomeCampanha() {
		return nomeCampanha;
	}

	public void setNomeCampanha(CAMPANHA_POR_SEXO nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	@Override
	public String toString() {
		return "CampanhaRetorno [sexo=" + sexo + ", nomeCampanha=" + nomeCampanha + ", ano=" + ano + "]";
	}

	

}

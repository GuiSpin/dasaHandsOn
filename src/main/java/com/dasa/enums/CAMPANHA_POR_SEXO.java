package com.dasa.enums;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CAMPANHA_POR_SEXO implements Serializable {

	CANCER_DE_MAMA ("Câncer de Mama", "F"),
	CANCER_DE_PROSTATA ("Câncer de Próstata", "M");
	
	private String nome;
	private String id;
	
	private CAMPANHA_POR_SEXO(String nome, String id) {
		this.nome = nome;
		this.id = id;
	}
	
	@JsonValue
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public static CAMPANHA_POR_SEXO getEnum(String value) {
        for(CAMPANHA_POR_SEXO v : values())
            if(v.getId().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
	
}

package com.dasa.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "campanha")
public class Campanha implements Serializable {
	

    @Override
	public String toString() {
		return "Campanha [id=" + id + ", tipoCampanha=" + tipoCampanha + ", ano=" + ano + ", qtdeParticipantes="
				+ qtdeParticipantes + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private final String tipoCampanha;
	private final String ano;
	private final Long qtdeParticipantes;
	
	public Campanha(Long id, String tipoCampanha, String ano, Long qtdeParticipantes) {
		super();
		this.tipoCampanha = tipoCampanha;
		this.ano = ano;
		this.qtdeParticipantes = qtdeParticipantes;
	}
	
	public String getTipoCampanha() {
		return tipoCampanha;
	}

	public String getAno() {
		return ano;
	}
	public Long getQtdeParticipantes() {
		return qtdeParticipantes;
	}
	

}

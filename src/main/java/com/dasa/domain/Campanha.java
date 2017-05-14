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
   
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	

	private  String sexo;
	private  String ano;
	
	public Campanha() {
	};
	
	public Campanha(String sexo, String ano) {
		this.sexo = sexo;
		this.ano = ano;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSexo() {
		return sexo;
	}

	public String getAno() {
		return ano;
	}
	
	
	 @Override
		public String toString() {
			return "Campanha [id=" + id + ", sexo=" + sexo + ", ano=" + ano + ", qtdeParticipantes="
				+ "]";
		}

}

package com.dasa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.Campanha;
import com.dasa.domain.CampanhaRetorno;
import com.dasa.domain.ConsultaRetorno;
import com.dasa.domain.Notificacao;
import com.dasa.service.CampanhaService;

@RestController
@RequestMapping(value="/campanhas")
public class CampanhasController {

	@Autowired
	CampanhaService service;
	
	private Double total;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public CampanhaRetorno addCampanha(@RequestBody Notificacao not){
		Campanha camp = new Campanha(not.getSexo(), not.getAno());

		
		return service.salvar(camp);
	}
	
	@RequestMapping(value="/ano/{year}")
	public List<ConsultaRetorno> getCampanha(@PathVariable String year){
		
		return service.obterParticipantesPorAno(Optional.of(year));
	}
	
	@RequestMapping(value="/ano/{year}/proporcao")
	public List<ConsultaRetorno> getCampanhaProporcao(@PathVariable String year){
		total = Double.valueOf("0");
		
		List<ConsultaRetorno> estatCampanhas = service.obterParticipantesPorAno(Optional.of(year));
		
		
		estatCampanhas.forEach(estat -> total += estat.getQtdeParticipantes());
		
		System.out.println(total);
		estatCampanhas.forEach(estat -> estat.setQtdeParticipantes((estat.getQtdeParticipantes()/total)*100));
		
		
		return estatCampanhas;
	}
	
	@RequestMapping(value="/{id}")
	public Campanha getCampanhaId(@PathVariable Long id){
		Campanha camp =  service.obterParticipantesPorId(Optional.of(id));
		System.out.println(camp);
		
		return camp;
	}
	
	@RequestMapping()
	public List<Campanha> getCampanhas(){
		return service.obterAllCampanhas();
		
	}
	
	
}

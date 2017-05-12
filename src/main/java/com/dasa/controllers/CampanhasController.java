package com.dasa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.Campanha;
import com.dasa.domain.Notificacao;
import com.dasa.service.CampanhaService;

@RestController
@RequestMapping(value="/campanhas")
public class CampanhasController {

	@Autowired
	CampanhaService service;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public Campanha addCampanha(@RequestBody Notificacao not){
		Campanha camp = new Campanha(Long.valueOf("1"), not.getSexo(), not.getAno(), Long.valueOf("1"));
		System.out.println(camp);
		
		return service.salvar(camp);
	}
	
	@RequestMapping(value="/{year}")
	public Campanha addCampanha(@PathVariable String year){
		System.out.println(year);
		Campanha camp =  service.obterParticipantesPorAno(Optional.of(year));
		System.out.println(camp);
		
		return camp;
	}
	
	
}

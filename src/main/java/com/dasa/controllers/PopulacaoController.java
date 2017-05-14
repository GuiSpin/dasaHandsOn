package com.dasa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.DadoPopulacional;
import com.dasa.domain.EstatisticaAnoResponse;
import com.dasa.service.DadosPopulacionaisService;

@RestController
@RequestMapping("/populacao")
public class PopulacaoController {

	@Autowired
	DadosPopulacionaisService service;
	
	@RequestMapping(value="/{year}")
	@ResponseBody
	public EstatisticaAnoResponse getDataByYear(@PathVariable String year){
		System.out.println("teste");
		
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of(year));
		System.out.println(pop);
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);
		
		return stat;
	}
	
}

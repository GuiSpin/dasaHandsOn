package com.dasa.service;

import com.dasa.domain.Campanha;
import com.dasa.domain.DadoPopulacional;
import com.dasa.repository.CampanhaRepository;
import com.dasa.repository.DadosPopulacionaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class CampanhaServiceImpl implements CampanhaService {

	
    @Autowired
    private CampanhaRepository campanhaRepository;

	@Override
	public Campanha obterParticipantesPorAno(Optional<String> ano) {
		final String anoCampanha = ano.get();
		
		return campanhaRepository.findByAno(anoCampanha);
		
	}
	
	@Override
	public Campanha salvar(Campanha camp) {
		
		campanhaRepository.save(camp);
		return camp;
		
	}
}

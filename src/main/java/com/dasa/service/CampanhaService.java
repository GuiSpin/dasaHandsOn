package com.dasa.service;

import java.util.List;
import java.util.Optional;

import com.dasa.domain.Campanha;
import com.dasa.domain.CampanhaRetorno;
import com.dasa.domain.ConsultaRetorno;


public interface CampanhaService {

    List<ConsultaRetorno> obterParticipantesPorAno(final Optional<String> ano);
    
    Campanha obterParticipantesPorId(final Optional<Long> id);

    List<Campanha> obterAllCampanhas();
    
	CampanhaRetorno salvar(Campanha camp);

}

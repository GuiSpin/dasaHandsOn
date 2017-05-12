package com.dasa.service;

import com.dasa.domain.Campanha;
import com.dasa.domain.DadoPopulacional;

import java.util.Optional;

import org.springframework.stereotype.Service;


public interface CampanhaService {

    Campanha obterParticipantesPorAno(final Optional<String> ano);

	Campanha salvar(Campanha camp);

}

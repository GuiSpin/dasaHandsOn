package com.dasa.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dasa.domain.Campanha;
import com.dasa.domain.DadoPopulacional;

@Transactional
public interface CampanhaRepository extends CrudRepository<Campanha, Long> {

    Campanha findByAno(final String ano);
    

}

package com.dasa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dasa.domain.Campanha;

@Transactional
public interface CampanhaRepository extends CrudRepository<Campanha, Long> {

    Campanha findByAno(final String ano);
    Campanha findById(final Long id);
    List<Campanha> findAllByAno(final String ano);
}

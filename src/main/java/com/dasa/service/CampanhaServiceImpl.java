package com.dasa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasa.domain.Campanha;
import com.dasa.domain.CampanhaRetorno;
import com.dasa.domain.ConsultaRetorno;
import com.dasa.enums.CAMPANHA_POR_SEXO;
import com.dasa.repository.CampanhaRepository;

@Service
public class CampanhaServiceImpl implements CampanhaService {

	
    @Autowired
    private CampanhaRepository campanhaRepository;

	@Override
	public List<ConsultaRetorno> obterParticipantesPorAno(Optional<String> ano) {
		final String anoCampanha = ano.get();
		
		List<Campanha> campanhas = campanhaRepository.findAllByAno(anoCampanha);
		

		 return createObjetoResposta(campanhas);
	}
	
	private List<ConsultaRetorno> createObjetoResposta(List<Campanha> campanhas) {
		Long totalM = (Long) campanhas.stream().filter(camp -> camp.getSexo().equals("M")).count();
		Long totalF = (Long) campanhas.stream().filter(camp -> camp.getSexo().equals("F")).count();

		
		ConsultaRetorno retornoM = new ConsultaRetorno();
		retornoM.setAno("M");
		retornoM.setNomeCampanha(CAMPANHA_POR_SEXO.getEnum("M"));
		retornoM.setQtdeParticipantes(totalM.doubleValue());
		
		ConsultaRetorno retornoF = new ConsultaRetorno();
		retornoF.setAno("F");
		retornoF.setNomeCampanha(CAMPANHA_POR_SEXO.getEnum("F"));
		retornoF.setQtdeParticipantes(totalF.doubleValue());
				
		
		List<ConsultaRetorno> retorno = new ArrayList<ConsultaRetorno>();
		retorno.add(retornoF);
		retorno.add(retornoM);
		
		return retorno;
	}
	
	@Override
	public CampanhaRetorno salvar(Campanha camp) {
		
		campanhaRepository.save(camp);
		
		CampanhaRetorno retorno = new CampanhaRetorno();
		retorno.setNomeCampanha(CAMPANHA_POR_SEXO.getEnum(camp.getSexo()));
		retorno.setAno(camp.getAno());
		retorno.setSexo(camp.getSexo());
		
		System.out.println(retorno);
		return retorno;
		
	}

	@Override
	public Campanha obterParticipantesPorId(Optional<Long> id) {
		final Long idCampanha = id.get();
		
		return campanhaRepository.findById(idCampanha);
	}

	@Override
	public List<Campanha> obterAllCampanhas() {
		return (List<Campanha>) campanhaRepository.findAll();
	}
}

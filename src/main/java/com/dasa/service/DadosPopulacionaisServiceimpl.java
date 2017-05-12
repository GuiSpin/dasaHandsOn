package com.dasa.service;

import com.dasa.domain.DadoPopulacional;
import com.dasa.repository.DadosPopulacionaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class DadosPopulacionaisServiceimpl implements DadosPopulacionaisService {

	private static final Integer ANO_INICIO_PREVISAO = 2010;
	private static final Integer ANO_FIM_PREVISAO = 2016;
	
	
    @Autowired
    private DadosPopulacionaisRepository dadosPopulacionaisRepository;

    @Override
    public DadoPopulacional obterPopulacaoPorAno(final Optional<String> ano) {

        final String anoCenso = ano.get();

        if (!ano.isPresent()) {
            throw new IllegalArgumentException("Parametro Ano é Obrigatório");
        }
        
        DadoPopulacional dado = dadosPopulacionaisRepository.findByAno(anoCenso);
        
        if (dado== null) {
        	return getPrevisaoPopulacao(anoCenso);
        }else
        	return dado;
    }

	private DadoPopulacional getPrevisaoPopulacao(String year) {
		DadoPopulacional dadoInicio = dadosPopulacionaisRepository.findByAno(ANO_INICIO_PREVISAO.toString());
		DadoPopulacional dadoFim = dadosPopulacionaisRepository.findByAno(ANO_FIM_PREVISAO.toString());
		
		DadoPopulacional dadosPrevisao = new DadoPopulacional();
		dadosPrevisao.setAno(year);
		
		Double previsao = calculaPrevisao(dadoInicio.getPopulacaoTotal().doubleValue(), dadoFim.getPopulacaoTotal().doubleValue(),ANO_FIM_PREVISAO-ANO_INICIO_PREVISAO);
		
		dadosPrevisao.setPopulacaoTotal(calculaPopulacao(dadoFim.getPopulacaoTotal(),previsao));
		dadosPrevisao.setTotalHomens(calculaPopulacao(BigDecimal.valueOf(dadoFim.getTotalHomens()),previsao).longValue());
		dadosPrevisao.setTotalMulheres(calculaPopulacao(BigDecimal.valueOf(dadoFim.getTotalMulheres()),previsao).longValue());
		return dadosPrevisao;
	}
	
	private BigDecimal calculaPopulacao(BigDecimal populacao, Double previsao) {
		
		return populacao.add(populacao.multiply(BigDecimal.valueOf(previsao))).setScale(0, RoundingMode.DOWN);
	}
	
	private Double calculaPrevisao(Double popInicial ,Double popFinal, Integer difAnos) {

		Double manipulaBigDec = popFinal/popInicial;
		
	
		Double previsao = Math.pow(manipulaBigDec,1.0/difAnos) -1;
		System.out.println(previsao);
		return previsao; 
	}
}

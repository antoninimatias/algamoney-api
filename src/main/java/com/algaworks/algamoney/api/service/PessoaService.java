/**
 * @Antonini Matias
 * Pacote Service trata das regras de negócio
 * 
 * */


package com.algaworks.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizar (Long codigo, Pessoa pessoa){
		Pessoa pessoaSalva =  pessoaRepository.findOne(codigo);
		if(pessoaSalva == null){
			throw new EmptyResultDataAccessException(1);
		}
		//Copia as propriedades do Objeto pesssa e manda para pessoa salva, exceto o codigo
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepository.save(pessoaSalva);
	}
}

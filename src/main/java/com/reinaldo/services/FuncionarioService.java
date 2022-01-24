package com.reinaldo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.domain.Funcionario;
import com.reinaldo.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario buscar(Integer id) {
		Optional<Funcionario> obj = funcionarioRepository.findById(id);
		return obj.orElse(null);
	}
}

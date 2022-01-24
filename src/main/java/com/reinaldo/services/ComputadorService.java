package com.reinaldo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.domain.Computador;
import com.reinaldo.repositories.ComputadorRepository;

@Service
public class ComputadorService {

	@Autowired
	private ComputadorRepository computadorRepository;
	
	public Computador buscar(Integer id) {
		Optional<Computador> obj = computadorRepository.findById(id);
		return obj.orElse(null);
	}
}

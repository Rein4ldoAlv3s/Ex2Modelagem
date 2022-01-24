package com.reinaldo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.domain.Computador;
import com.reinaldo.services.ComputadorService;

@RestController
@RequestMapping("/computadores")
public class ComputadorResource {

	@Autowired
	private ComputadorService computadorService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		Computador obj = computadorService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}

package com.reinaldo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.domain.Computador;
import com.reinaldo.domain.Funcionario;
import com.reinaldo.repositories.ComputadorRepository;
import com.reinaldo.repositories.FuncionarioRepository;

@SpringBootApplication
public class ProjetoFuncionarioComputadorApplication implements CommandLineRunner{
	
	@Autowired
	private ComputadorRepository computadorRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoFuncionarioComputadorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Funcionario f1 = new Funcionario(null, "Reinaldo", "Suporte TI", 1200.00);
		Funcionario f2 = new Funcionario(null, "Ana", "Médica", 4000.00);
		
		Computador c1 = new Computador(null, "Core i5 3470", "120GB", 2012);
		Computador c2= new Computador(null, "Core i7 4700k", "240GB", 2014);
		Computador c3 = new Computador(null, "Ryzen 5 3200G", "120GB", 2017);
		
		f1.getComputadores().addAll(Arrays.asList(c1, c2));
		f2.getComputadores().addAll(Arrays.asList(c2, c3));
		
		c1.getFuncionarios().addAll(Arrays.asList(f1));
		c2.getFuncionarios().addAll(Arrays.asList(f1, f2));
		c3.getFuncionarios().addAll(Arrays.asList(f2));
		
		funcionarioRepository.saveAll(Arrays.asList(f1, f2));
		computadorRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}

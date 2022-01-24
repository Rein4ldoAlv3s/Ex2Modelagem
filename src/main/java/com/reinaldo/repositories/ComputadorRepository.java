package com.reinaldo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.domain.Computador;

@Repository
public interface ComputadorRepository extends JpaRepository<Computador, Integer>{

}

package com.reinaldo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Computador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cpu;
	private String ssd;
	private Integer anoFab;
	
	@JsonBackReference 	//não irá buscar a referência desse lado, apenas onde está a anotação JsonManagedReference
	@ManyToMany
	@JoinTable(name = "COMPUTADOR_FUNCIONARIO",
		joinColumns = @JoinColumn(name = "computador_id"),
		inverseJoinColumns = @JoinColumn(name = "funcionario_id")
	)
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public Computador() {
		super();
	}

	public Computador(Integer id, String cpu, String ssd, Integer anoFab) {
		super();
		this.id = id;
		this.cpu = cpu;
		this.ssd = ssd;
		this.anoFab = anoFab;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getSsd() {
		return ssd;
	}

	public void setSsd(String ssd) {
		this.ssd = ssd;
	}

	public Integer getAnoFab() {
		return anoFab;
	}

	public void setAnoFab(Integer anoFab) {
		this.anoFab = anoFab;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoFab, cpu, id, ssd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computador other = (Computador) obj;
		return Objects.equals(anoFab, other.anoFab) && Objects.equals(cpu, other.cpu) && Objects.equals(id, other.id)
				&& Objects.equals(ssd, other.ssd);
	}

	
	
	
	

}

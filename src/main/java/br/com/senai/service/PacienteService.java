package br.com.senai.service;

import java.util.List;

import br.com.senai.model.Paciente;

public interface PacienteService {
	
	public void create(Paciente p);
	public void update(Paciente p);
	public void delete(Paciente p);
	public List<Paciente> findAll();
	public Paciente findById(int id);
}

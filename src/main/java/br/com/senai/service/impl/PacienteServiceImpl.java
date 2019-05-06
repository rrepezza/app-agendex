package br.com.senai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.model.Paciente;
import br.com.senai.repository.PacienteRepository;
import br.com.senai.service.PacienteService;

@Service("pacienteService")
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository pRepo;
	
	@Transactional
	public void create(Paciente p) {
		this.pRepo.create(p);
	}

	@Transactional
	public void update(Paciente p) {
		this.pRepo.update(p);
	}
	
	@Transactional
	public void delete(Paciente p) {
		this.pRepo.delete(p);
	}
	
	@Transactional(readOnly = true)
	public List<Paciente> findAll() {
		List<Paciente> list = this.pRepo.findAll();
		return list;
	}
	
	@Transactional(readOnly = true)
	public Paciente findById(int id) {
		return this.pRepo.findById(id);
	}

}

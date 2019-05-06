package br.com.senai.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.senai.model.Paciente;
import br.com.senai.repository.PacienteRepository;

@Repository("pacienteRepository")
public class PacienteRepositoryImpl implements PacienteRepository{
	
	@PersistenceContext
    private EntityManager em;

	public void create(Paciente p) {
		if(p.getId() == null) {
			this.em.persist(p);
		} 		
	}

	public void update(Paciente p) {
		Paciente paciente = this.em.find(Paciente.class, p.getId());
		if(paciente != null) {
			paciente = p;
			this.em.flush();
		}
	}

	public void delete(Paciente p) {
		this.em.remove(p);
	}

	public List<Paciente> findAll() {
		return this.em.createQuery("from Paciente", Paciente.class).getResultList();
	}

	public Paciente findById(int id) {
		return this.em.find(Paciente.class, id);
	}

}

package br.com.senai.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.senai.model.Paciente;
import br.com.senai.service.PacienteService;

@ManagedBean
@RequestScoped
public class PacienteBean extends SpringBeanAutowiringSupport {
	
	@Autowired
	private PacienteService pService;
	
	private List<Paciente> pacientes;
	private Paciente paciente;
	private Paciente update;
	public Paciente getUpdate() {
		return update;
	}

	public void setUpdate(Paciente update) {
		this.update = update;
	}

	private Boolean ativaUpdate;
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Boolean getAtivaUpdate() {
		return ativaUpdate;
	}

	public void setAtivaUpdate(Boolean ativaUpdate) {
		this.ativaUpdate = ativaUpdate;
	}
	
	public void cadastrar() {
		this.pService.create(this.paciente);
		paciente = new Paciente();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Paciente cadastrado!"));
	}
	
	public void update() {
		this.pService.update(paciente);
		this.pacientes = pService.findAll();
		this.paciente = new Paciente();
		this.ativaUpdate = false;
		this.update = null;
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Paciente atualizado!"));
	}
	
	public void selecaoUpdate() {
		this.paciente = this.update;
		this.ativaUpdate = true;
	}
	
	public void cancelarUpdate() {
		this.ativaUpdate = false;
		this.paciente = new Paciente();
		this.update = null;
	}
	
	public void delete() {
		this.pService.delete(this.paciente);
		this.pacientes = this.pService.findAll();
		this.paciente = new Paciente();
		this.ativaUpdate = false;
		this.update = null;

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso!",
				"Paciente deletado com sucesso"));
	}
	
	
	
}

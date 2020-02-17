package com.eventoapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Convidado {

	@Id									//Definir atributo ID
	@GeneratedValue(					//Forçar a geração automática do ID
	    strategy= GenerationType.AUTO,
	    generator="native"
	)
	@GenericGenerator(					//Solicitar a geração automática
	    name = "native",
	    strategy = "native"
	)
	private Long codigo;				//Campo que será o ID da tabela
	
	@ManyToOne
	private Evento evento;
	
	@NotEmpty
	private String rg;
	@NotEmpty
	private String nomeConvidado;
	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNomeConvidado() {
		return nomeConvidado;
	}
	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}
	
}

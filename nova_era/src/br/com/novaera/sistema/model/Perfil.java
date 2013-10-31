package br.com.novaera.sistema.model;

import javax.persistence.*;

@Entity
@Table( name="perfil_user")
public class Perfil {
	
	@Id@GeneratedValue
	@Column (name="id_perfil")
	private Integer id;
	
	@Column (name = "name")
	String nome;
	/*
	@Column (name = "sn_administrador")
	boolean snAdministrador;
	*/
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
    /*
	public boolean isSnAdministrador() {
		return snAdministrador;
	}

	public void setSnAdministrador(boolean snAdministrador) {
		this.snAdministrador = snAdministrador;
	}
	*/

}

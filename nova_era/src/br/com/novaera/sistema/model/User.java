package br.com.novaera.sistema.model;

import java.util.Date;

import javax.persistence.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rodrigo
 */

@Entity
@Table( name="user")
public class User{
	
	@Id@GeneratedValue
	@Column (name = "id_user")
	private Integer id;	
    
	@Column (name = "login")
    private String login;	
    
	@Column (name = "name")
    private String nome;
    
    @Column (name = "password")
    private String password;
    
    @Column (name = "email")
    private String email;
    
    @Column (name = "dt_cadastro")
    private Date dataCadastro;
    
    @ManyToOne(targetEntity=br.com.novaera.sistema.model.Perfil.class)
    @JoinColumn(name="id_perfil", nullable = false)
    private Perfil perfil;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
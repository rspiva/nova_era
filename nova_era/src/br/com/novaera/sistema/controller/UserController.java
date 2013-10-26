package br.com.novaera.sistema.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.*;
import org.hibernate.cfg.*;

import br.com.novaera.sistema.model.User;
import br.com.novaera.system.Conexao;

import com.google.gson.Gson;

@ManagedBean(name = "mb_user")
@SessionScoped
public class UserController {
	
	User user = new User();
	User userselecionado = new User();
	Conexao conn = new Conexao();
	Gson gson = new Gson();
	FacesContext context;
	List users;
	String nomePesquisa;
	
	public User getUserEmail(String email){
		User user = null;
		try{
			AnnotationConfiguration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(br.com.novaera.sistema.model.User.class);
			SessionFactory fabrica = cfg.buildSessionFactory();
	        Session sessao = fabrica.openSession();
	        Transaction tx_user = sessao.beginTransaction();
	        Query qry = (Query) sessao.createQuery("from User m WHERE m.email = '" + email + "'");
	        tx_user.commit();
	        if (qry.uniqueResult() != null) {
	        	user = (User)qry.uniqueResult();
	        }else{
	        	user = null;
	        }
	        sessao.clear();
		}
		catch(Exception erro){
            user = null;
        }
		return user;
	}
	
	public List getListUser(){
		return this.users;
	}
	
	public String onBotaoPesquisaUser(){
		try{
			AnnotationConfiguration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(br.com.novaera.sistema.model.User.class);
			SessionFactory fabrica = cfg.buildSessionFactory();
	        Session sessao = fabrica.openSession();
	        Transaction tx_users = sessao.beginTransaction();
	        this.users = sessao.createQuery("from User m WHERE m.nome LIKE '%" + this.nomePesquisa + "%' OR m.email LIKE '%" + this.nomePesquisa + "%'").list();
		}catch(Exception erro){
            this.users = null;
        }		
		return null;		
	}
	
	
	public String cancelar(){
		context = FacesContext.getCurrentInstance();
		try {
			context.getExternalContext().redirect("index.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return null;
	}	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//levantar e salvar o cliente que foi selecionado
	public User getUserselecionado() {
		return userselecionado;
	}

	public void setUserselecionado(User userselecionado) {
		this.userselecionado = userselecionado;
	}
	
	public String onUpdateUserSelecionado() {  
        
		SessionFactory fabrica = new AnnotationConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(br.com.novaera.sistema.model.User.class).buildSessionFactory();
        Session sessao = fabrica.openSession();
        Transaction tx_user = sessao.beginTransaction();  
        sessao.update(this.userselecionado);
        tx_user.commit();
        sessao.clear();
        return null;
    }
	
	
	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}


}

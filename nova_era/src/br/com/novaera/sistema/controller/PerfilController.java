package br.com.novaera.sistema.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.novaera.sistema.model.Perfil;
import br.com.novaera.sistema.model.User;

@ManagedBean(name = "mb_perfil")
@SessionScoped
public class PerfilController {
	
	List perfils;
	
	public List getListaPerfil(){
		this.perfils = null;
		try{
			AnnotationConfiguration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(br.com.novaera.sistema.model.Perfil.class);
			SessionFactory fabrica = cfg.buildSessionFactory();
	        Session sessao = fabrica.openSession();
	        Transaction tx_users = sessao.beginTransaction();
	        this.perfils = sessao.createQuery("from Perfil p").list();
		}catch(Exception erro){
            this.perfils = null;
        }
		return this.perfils;
	}
	
	public Perfil getPerfil(int id){
		Perfil perfil = null;
		try{
			AnnotationConfiguration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(br.com.novaera.sistema.model.Perfil.class);
			SessionFactory fabrica = cfg.buildSessionFactory();
	        Session sessao = fabrica.openSession();
	        Transaction tx_user = sessao.beginTransaction();
	        Query qry = (Query) sessao.createQuery("from Perfil p WHERE p.id = '" + id + "'");
	        tx_user.commit();
	        if (qry.uniqueResult() != null) {
	        	perfil = (Perfil)qry.uniqueResult();
	        }else{
	        	perfil = null;
	        }
	        sessao.clear();
		}
		catch(Exception erro){
			perfil = null;
        }
		
		return perfil;		
	}
}

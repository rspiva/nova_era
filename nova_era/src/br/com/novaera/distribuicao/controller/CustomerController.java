package br.com.novaera.distribuicao.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import br.com.novaera.distribuicao.model.Customer;
import br.com.novaera.sistema.model.User;
import br.com.novaera.system.HibernateUtil;


@ManagedBean(name = "mb_customer")
@SessionScoped
public class CustomerController {
	
	private Session session;
	private Transaction transaction;
	
	public Customer getCustomerId(int id_customer){
		Customer customer = null;
		try{
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transaction = this.session.beginTransaction();
			/*
			Query qry = (Query) session.createQuery("from Customer c WHERE c.idCustomer = '" + id_customer + "'");
			transaction.commit();
	        if (qry.uniqueResult() != null) {
	        	customer = (Customer)qry.uniqueResult();
	        }else{
	        	customer = null;
	        }
	        session.clear();
	        
	        */
			Criteria filter = this.session.createCriteria(Customer.class);
			filter.add(Restrictions.eq("idCustomer", id_customer));
			customer = (Customer) filter.uniqueResult();
			this.transaction.commit();
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
		}
		return customer; 
		
	}

}

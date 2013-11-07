package br.com.novaera.distribuicao.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.novaera.distribuicao.model.Address;
import br.com.novaera.distribuicao.model.Customer;
import br.com.novaera.system.HibernateUtil;


@ManagedBean(name = "mb_customer")
@SessionScoped
public class CustomerController {
	
	//private Session session;
	//private Transaction transaction;
	Customer customer = new Customer();
	Address address  = new Address();
		
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String insertCustomer(){
		//this.address.setAddress(1);
		this.customer.setAddress(this.address);
		
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(this.customer);
	        transaction.commit();
			session.close();
			
			
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
		}
		return null;		
	}
	
	public void insertAddress(Address add){
						
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(add);
	        transaction.commit();
			session.close();
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
		}
				
	}

	



	public Customer getCustomerId(int id_customer){
		Customer customer = null;
		try{
			
			/*
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transaction = this.session.beginTransaction();
			
			Query qry = (Query) session.createQuery("from Customer c WHERE c.idCustomer = '" + id_customer + "'");
			transaction.commit();
	        if (qry.uniqueResult() != null) {
	        	customer = (Customer)qry.uniqueResult();
	        }else{
	        	customer = null;
	        }
	        session.clear();
	        
	        */
			/*
			AnnotationConfiguration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(br.com.novaera.distribuicao.model.Customer.class);
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			*/
			/*
			Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
            .applySettings(configuration.getProperties())
            .buildServiceRegistry();
			MetadataSources metadataSources = new MetadataSources(serviceRegistry);
			metadataSources.addAnnotatedClass(br.com.novaera.distribuicao.model.Customer.class);
			Metadata metadata = metadataSources.buildMetadata();
			SessionFactory sessionFactory = metadata.buildSessionFactory();
			*/
			/*
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			*/
			/*
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query qry = (Query) session.createQuery("from Customer c WHERE c.idCustomer = " + id_customer );
			transaction.commit();
	        if (qry.uniqueResult() != null) {
	        	customer = (Customer)qry.uniqueResult();
	        }else{
	        	customer = null;
	        }
	        session.clear();
			*/
			
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
			
	        //Filtro conforme o id do parametro
	        Criteria filter = session.createCriteria(Customer.class);
			filter.add(Restrictions.eq("idCustomer", id_customer));
			customer = (Customer) filter.uniqueResult();
			transaction.commit();
			session.close();
			
			
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
		}
		return customer; 
		
	}

}

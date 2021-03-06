package br.com.novaera.distribuicao.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.novaera.distribuicao.model.Address;
import br.com.novaera.distribuicao.model.Customer;
import br.com.novaera.system.HibernateUtil;


@ManagedBean(name = "mb_customer")
@RequestScoped
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
		this.address.setCustomer(this.customer);
		this.customer.setAddress(this.address);
		
		
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(this.customer);
	        transaction.commit();
			session.close();
			
			
			
		}catch(Throwable e){
			System.out.println("Erro na opera��o de busca" + e.getMessage());
		}
		
		//Limpar campos
		this.customer.setAddress(null);
		this.customer.setName("");
		this.customer.setNumberDoc("");
		this.address.setAddress(null);
		this.address.setStreet("");
		this.address.setNumber("");
		this.address.setNeighborhood("");
		this.address.setCity("");
		this.address.setState("");
		this.address.setCountry(null);
		
		return null;		
	}
	
	public List getCustomerList(){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customers = session.createQuery("from Customer").list();		
        transaction.commit();
		session.close();
		return customers;
		
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
			System.out.println("Erro na opera��o de busca" + e.getMessage());
		}
		return customer; 
		
	}

}

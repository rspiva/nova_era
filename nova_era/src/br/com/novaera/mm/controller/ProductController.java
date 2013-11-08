package br.com.novaera.mm.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.novaera.distribuicao.model.Customer;
import br.com.novaera.mm.model.Product;
import br.com.novaera.system.HibernateUtil;


@ManagedBean(name = "mb_product")
@SessionScoped
public class ProductController {
	
	Product product = new Product();

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String insertProduct(){
		
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(this.product);
	        transaction.commit();
			session.close();
			
		}catch(Throwable e){
			System.out.println("Erro ao inserir o produto" + e.getMessage());
		}
		return null;
	}
	
	public Product getProductId( int idProduct){
		Product product = null;
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
		
        //Filtro conforme o id do parametro
        Criteria filter = session.createCriteria(Product.class);
		filter.add(Restrictions.eq("idProduct", idProduct));
		product = (Product) filter.uniqueResult();
		transaction.commit();
		session.close();
		
		return product;
	}

}

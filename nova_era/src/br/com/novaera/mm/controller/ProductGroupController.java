package br.com.novaera.mm.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.novaera.mm.model.ProductGroup;
import br.com.novaera.system.HibernateUtil;


@ManagedBean(name = "mb_prodgroup")
@SessionScoped
public class ProductGroupController {
	
	ProductGroup pg = new ProductGroup();

	public ProductGroup getPg() {
		return pg;
	}

	public void setPg(ProductGroup pg) {
		this.pg = pg;
	}
	//pg016755517br
	public List getProductGroupList(){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session session = sf.openSession();
	    Transaction transaction = session.beginTransaction();
	    List<ProductGroup> productGroup = session.createQuery("from ProductGroup").list();		
	    transaction.commit();
		session.close();
		return productGroup;
		
	}

}

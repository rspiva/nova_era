package br.com.novaera.mm.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.novaera.mm.model.Product;
import br.com.novaera.mm.model.ProductGroup;
import br.com.novaera.system.HibernateUtil;


@ManagedBean(name = "mb_product")
@SessionScoped
public class ProductController {
	
	Product product = new Product();
	ProductGroup productGroup = new ProductGroup();
	
	//id do grupo de cliente
	int idProductGroup;	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public ProductGroup getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}
	
	//Inseri o grupo de cliente através do ID
	public int getIdProductGroup() {
		return idProductGroup;
	}

	public void setIdProductGroup(int idProductGroup) {
		this.idProductGroup = idProductGroup;
	}
	
	public List getProductList(){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session session = sf.openSession();
	    Transaction transaction = session.beginTransaction();
	    List<Product> product = session.createQuery("from Product").list();		
	    transaction.commit();
		session.close();
		return product;
		
	}

	public String insertProduct(){
		
		//Levantar o grupo de cliente
		this.productGroup = new ProductGroupController().getProductGroupId(this.idProductGroup);
		this.product.setProductGroup(this.productGroup);
		
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
		
		this.productGroup = null;
		
		this.product.setSKU(0);
		this.product.setProductName("");
		this.product.setUnit("");
		this.product.setWeight(0);
		this.product.setDimensions("");
		this.product.setProductDetails("");
		this.product.setProductGroup(null);	
		this.idProductGroup = 0;	
		
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

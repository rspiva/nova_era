package br.com.novaera.system;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.novaera.distribuicao.controller.CustomerController;
import br.com.novaera.distribuicao.controller.PriceProductTabController;
import br.com.novaera.distribuicao.controller.PriceTabController;
import br.com.novaera.distribuicao.model.Address;
import br.com.novaera.distribuicao.model.Customer;
import br.com.novaera.distribuicao.model.PriceProductTab;
import br.com.novaera.distribuicao.model.PriceTab;
import br.com.novaera.sistema.controller.UserController;
import br.com.novaera.sistema.model.User;
import br.com.novaera.mm.model.*;
import br.com.novaera.mm.controller.*;
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		SessionFactory fabrica = new AnnotationConfiguration().configure(\"hibernate.cfg.xml\").addAnnotatedClass(br.com.jpiva.sistema.model.User.class).buildSessionFactory();
        Session sessao = fabrica.openSession();
        Transaction tx_user = sessao.beginTransaction();
        //List users = sessao.createQuery(\"from User m WHERE m.email = 'rodrigospiva@yahoo.com.br'\").list();
        Query qry = (Query) sessao.createQuery(\"from User m WHERE m.email = 'rodrigospiva@yahoo.com.br'\");
        User user = (User)qry.uniqueResult();
        tx_user.commit();
        sessao.clear();
        
        //User user = (User) users.get(0);
        
        System.out.println(user.getNome());		
		
		
		/*
		UserController n = new UserController();
		User user = (User) n.getUserEmail("rodrigospiva@yahoo.com.br");
		System.out.println(user.getNome());
		System.out.println(user.getEmail());  
		*/
		/*
		CustomerController c = new CustomerController();
		Customer customer = (Customer) c.getCustomerId(27);
		System.out.println(customer.getName());
		System.out.println(customer.getAddress().getStreet());
		System.out.println(customer.getAddress().getCountry());
		*/
		/*
		CustomerController c = new CustomerController();
		Address address = new Address();
		address.setAddress(1);
		address.setStreet("Rua Viena");
		address.setNumber("140");
		address.setNeighborhood("Jd Na��es");
		address.setCity("Diadema");
		address.setCountry("Brasil");
		address.setState("S�o Paulo");
		c.insertAddress(address);
		
		/*
		 * 
		PerfilController p = new PerfilController();
		Perfil perfil = p.getPerfil(1);
		System.out.println(perfil.getNome());
		*/
		
		/*
	    String json = "{cliente:[{\"key\":\"ab4g5es525d2f\",\"name\":\"JPIVA CONSULTORIA EM INFORMATICA LTDA\"},{\"key\":\"ab4g5es525d2f\",\"name\":\"ABC COMERCIO LTDA\"}]}";	
	    ParseJsonCliente ajson = new ParseJsonCliente();
	    String retorno = ajson.loadClienteFromJSON(json);
	    
	    System.out.println(retorno);
	    */
	    /*
	    Cliente cliente = new Cliente();		 
		Gson gson = new Gson();
		cliente = gson.fromJson(json, Cliente.class);
		*/
		
		/*
		// levantar produto 
		ProductController pc = new ProductController();
		
		Product p = pc.getProductId(1);
		System.out.println(p.getProductName());
		System.out.println(p.getProductDetails());
		System.out.println(p.getProductGroup().getNameGroup());
		*/
		
		// Imprimir Lista de grupos de clientes
		/*
		ProductGroupController pc = new ProductGroupController();
		List<ProductGroup> list = pc.getProductGroupList();
		for (ProductGroup pg : list){
			System.out.println(pg.getNameGroup());
		}
		*/
		
		
		/*
		//Inserindo um novo produto no banco
		Product p = new Product();
		p.setSKU(52562);
		p.setProductName("Caderno em espiral do BEM 10");
		p.setUnit("PC");
		p.setWeight(0.400);
		p.setProductDetails("Caderno em espiral de 100 folhas do Bem 10 - Alienigena OGRO");
		p.setDimensions("45 X 60 X 20  (C x L x A)");
		p.setImageDirectory("C\\Image\\52562.png");
		
		//salvar produto
		pc.setProduct(p);
		pc.insertProduct();
		*/
		
		/*
		PriceTabController pc = new PriceTabController();
		PriceTab pt = pc.getPriceTabId(1);
		System.out.println(pt.getNamePriceTab());
		
		List<PriceProductTab> prices = pt.getPriceProductTabs();
		
		System.out.println(prices.get(1).getIdProduct());
		*/
		/*
		for(PriceProductTab price : prices){
			System.out.println(price.getPrice());			
		}
		*/
		
		/*
		PriceProductTab p = new PriceProductTab();
		p.setPriceTab(null);
		p.setIdProduct(3);
		p.setPrice(2.12);
		
		PriceProductTabController pc = new PriceProductTabController();
		pc.setPriceProductTab(p);
		pc.insertPriceProductTab();
		*/
		/*
		BigDecimal bd = new BigDecimal(25252.01);
		NumberFormat nf_us = NumberFormat.getInstance(new Locale( "pt", "BR" ));
		String number_us = nf_us.format(bd);
		System.out.println(number_us);
		*/
		    //String s1 = "example";
		//substring
		
		//Teste da classe DBController
		
		DBController db = new DBController();
		Customer c = new Customer();
		c = (Customer) db.getObjectId(c, "id", 1);
		System.out.println(c.getName());
		System.out.println(c.getAddress().getStreet());
		
		
	}
}

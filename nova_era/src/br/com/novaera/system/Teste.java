package br.com.novaera.system;

import br.com.novaera.distribuicao.controller.CustomerController;
import br.com.novaera.distribuicao.model.Address;
import br.com.novaera.distribuicao.model.Customer;
import br.com.novaera.sistema.controller.UserController;
import br.com.novaera.sistema.model.User;

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
		Customer customer = (Customer) c.getCustomerId(1);
		System.out.println(customer.getName());
		System.out.println(customer.getAddress().getStreet());
		System.out.println(customer.getAddress().getCountry());
		*/
		
		CustomerController c = new CustomerController();
		Address address = new Address();
		address.setAddress(1);
		address.setStreet("Rua Viena");
		address.setNumber("140");
		address.setNeighborhood("Jd Nações");
		address.setCity("Diadema");
		address.setCountry("Brasil");
		address.setState("São Paulo");
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
		
		
	}
}

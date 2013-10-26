package br.com.novaera.system;

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
		*/
		
		UserController n = new UserController();
		User user = (User) n.getUserEmail("rodrigospiva@yahoo.com.br");
		System.out.println(user.getNome());
		System.out.println(user.getEmail());  
		
		/*
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

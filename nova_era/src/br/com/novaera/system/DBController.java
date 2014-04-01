package br.com.novaera.system;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.novaera.distribuicao.model.Customer;

public class DBController {
	
	/*Classe para consulta geral, nessa classe determinamos
	 * a consulta genérica de todos os objetos
	 * 
	 */
	
	public String insertObject(Object o){
		
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(o);
	        transaction.commit();
			session.close();
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
		}
		
		return null;		
	}
	
	public List getObjectList( String filter){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        List<Object> objects = session.createQuery(filter).list();		
        transaction.commit();
		session.close();
		return objects;
		
	}
	
	public Object getObjectId(Object obj, String campo, int id){
		try{
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
			
	        //Filtro conforme o id do parametro
	        Criteria filter = session.createCriteria(obj.getClass());
			filter.add(Restrictions.eq(campo, id));
			obj = (Customer) filter.uniqueResult();
			transaction.commit();
			session.close();
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
		}
		return obj; 
		
	}
	

}

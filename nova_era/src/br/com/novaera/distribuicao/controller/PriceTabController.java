package br.com.novaera.distribuicao.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.novaera.distribuicao.model.Customer;
import br.com.novaera.distribuicao.model.PriceTab;
import br.com.novaera.system.HibernateUtil;


@ManagedBean(name = "mb_priceTab")
@SessionScoped
public class PriceTabController {
	
	PriceTab priceTab = new PriceTab();
	
	public PriceTab getPriceTab() {
		return priceTab;
	}

	public void setPriceTab(PriceTab priceTab) {
		this.priceTab = priceTab;
	}

	public String insertPriceTab(){
		
		
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(this.priceTab);
	        transaction.commit();
			session.close();
			
			
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
		}
		
		//Limpar campos
		this.priceTab.setDtExpiration(null);
		this.priceTab.setNamePriceTab("");
		this.priceTab.setSoudOut(false);
				
		return null;		
	}
	
	public PriceTab getPriceTabId(int idPriceTab){
		PriceTab priceTab = null;
		try{
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
			
	        //Filtro conforme o id do parametro
	        Criteria filter = session.createCriteria(PriceTab.class);
			filter.add(Restrictions.eq("id", idPriceTab));
			priceTab = (PriceTab) filter.uniqueResult();
			transaction.commit();
			session.close();
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
		}
		return priceTab; 
		
	}

}

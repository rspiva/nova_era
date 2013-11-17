package br.com.novaera.distribuicao.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.novaera.distribuicao.model.PriceProductTab;
import br.com.novaera.distribuicao.model.PriceTab;
import br.com.novaera.system.HibernateUtil;

public class PriceProductTabController {
	
	PriceProductTab priceProductTab = new PriceProductTab();
		
	public PriceProductTab getPriceProductTab() {
		return priceProductTab;
	}

	public void setPriceProductTab(PriceProductTab priceProductTab) {
		this.priceProductTab = priceProductTab;
	}
	
	

	public String insertPriceProductTab(){
		
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(this.priceProductTab);
	        transaction.commit();
			session.close();
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
		}
		
		//Limpar campos
		this.priceProductTab.setIdProduct(0);
		this.priceProductTab.setPrice(0);
				
		return null;		
	}

}

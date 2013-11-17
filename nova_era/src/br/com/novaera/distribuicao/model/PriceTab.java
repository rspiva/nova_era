package br.com.novaera.distribuicao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="price_tab")
public class PriceTab {
	
	@Id@GeneratedValue
	@Column (name="id")
	int id;
	
	@Column (name="name_price_tab")
	String namePriceTab;
	
	@Column (name="dt_expiration")
	Date dtExpiration;
		
	@Column (name="soud_out", columnDefinition = "TINYINT(3)")
	boolean soudOut;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="priceTab", targetEntity = PriceProductTab.class, cascade = CascadeType.ALL)
	List<PriceProductTab> priceProductTabs;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamePriceTab() {
		return namePriceTab;
	}
	public void setNamePriceTab(String namePriceTab) {
		this.namePriceTab = namePriceTab;
	}
	public Date getDtExpiration() {
		return dtExpiration;
	}
	public void setDtExpiration(Date dtExpiration) {
		this.dtExpiration = dtExpiration;
	}
	public boolean isSoudOut() {
		return soudOut;
	}
	public void setSoudOut(boolean soudOut) {
		this.soudOut = soudOut;
	}
	
	public List<PriceProductTab> getPriceProductTabs() {
		return priceProductTabs;
	}
	public void setPriceProductTabs(List<PriceProductTab> priceProductTabs) {
		this.priceProductTabs = priceProductTabs;
	}	
	
		
}

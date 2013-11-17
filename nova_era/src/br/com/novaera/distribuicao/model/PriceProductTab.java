package br.com.novaera.distribuicao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name="price_product_tab")
public class PriceProductTab {
	
	@Id@GeneratedValue
	@Column (name="id")
	int id;
		
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_price_tab")
	PriceTab priceTab;
	
	@Column (name="id_product")
	int idProduct;
			
	@Column (name="price", columnDefinition = "DECIMAL(8,3)")
	double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public PriceTab getPriceTab() {
		return priceTab;
	}

	public void setPriceTab(PriceTab priceTab) {
		this.priceTab = priceTab;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

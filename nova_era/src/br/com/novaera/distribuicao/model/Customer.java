package br.com.novaera.distribuicao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table( name="customer")
public class Customer{
	
	@Id@GeneratedValue
	@Column (name="id_customer")
	private int idCustomer;
	
		
	@Column (name="name")
	private String name;
	
	@Column (name="number_doc")
	private String numberDoc;
	
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
	private Address address;
	
	
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getNumberDoc() {
		return numberDoc;
	}

	public void setNumberDoc(String numberDoc) {
		this.numberDoc = numberDoc;
	}
	
	

}

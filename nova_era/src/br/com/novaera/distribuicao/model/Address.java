package br.com.novaera.distribuicao.model;

import javax.persistence.*;

import org.hibernate.annotations.Parameter;


@Entity
@Table( name="address")
public class Address {
	
	@Id
	@GeneratedValue(generator="fk_adrress_id_customer")
	@org.hibernate.annotations.GenericGenerator(name="fk_adrress_id_customer",
	strategy="foreign", parameters = @Parameter(name="property", value="customer"))
	@Column (name="id_customer")	
	Integer address;
	
	@Column (name="street")
	private String street;
	
	@Column (name="number")
	private String number;
	
	@Column (name="neighborhood")
	private String neighborhood;
	
	@Column (name="city")
	private String city;
	
	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column (name="state")
	private String state;
	
	@Column (name="country")
	private String country;
	

}

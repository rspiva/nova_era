package br.com.novaera.distribuicao.model;

import javax.persistence.*;

import org.hibernate.annotations.Parameter;


@Entity
@Table( name="address")
public class Address {
	/*
	@Id
	@GeneratedValue(generator="fk_adrress_id_customer")
	@org.hibernate.annotations.GenericGenerator(name="fk_adrress_id_customer",
	strategy="foreign", parameters = @Parameter(name="property", value="customer"))
	*/
	
	@Id
    @Column(name="id_customer", unique=true, nullable=false)
    @GeneratedValue(generator="fk_adrress_id_customer")
	@org.hibernate.annotations.GenericGenerator(name="fk_adrress_id_customer", strategy="foreign", parameters=@Parameter(name="property", value="employee"))
	Integer address;
	/*
	@OneToOne(mappedBy="address")
	*/
	@OneToOne
    @PrimaryKeyJoinColumn
	private Customer customer;
	
	@Column (name="street")
	private String street;
	
	@Column (name="number")
	private String number;
	
	@Column (name="neighborhood")
	private String neighborhood;
	
	@Column (name="city")
	private String city;
	
	@Column (name="state")
	private String state;
	
	@Column (name="country")
	private String country;
	
	
	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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


}

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
	
	@Column (name="state")
	private String state;
	
	@Column (name="country")
	private String country;
	

}

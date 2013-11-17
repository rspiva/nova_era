package br.com.novaera.distribuicao.model;

import java.util.List;

import br.com.novaera.mm.model.Product;

public class Order {
	
	int id;
	String customerOrder;
	Customer customer;
	List<Product> products;
	

}

package br.com.novaera.mm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name="product")
public class Product {
	
	@Id@GeneratedValue
	@Column (name="id_product")
	int    idProduct;
	
	@Column (name="SKU")
	float  SKU;
	
	@Column (name="product_name")
	String productName;
	
	@Column (name="unit")
	String unit;
	
	@Column (name="weight")
	double  weight;
	
	@Column (name="product_details")
	String productDetails;
	
	@Column (name="dimensions")
	String dimensions;
	
	@Column (name="image_directory")
	String imageDirectory;
	
	@ManyToOne
	@JoinColumn(name = "id_group")
	ProductGroup productGroup;
	

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public float getSKU() {
		return SKU;
	}

	public void setSKU(float sKU) {
		SKU = sKU;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getImageDirectory() {
		return imageDirectory;
	}

	public void setImageDirectory(String imageDirectory) {
		this.imageDirectory = imageDirectory;
	}

	public ProductGroup getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}
	
}
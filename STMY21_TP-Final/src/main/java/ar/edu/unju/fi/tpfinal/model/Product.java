package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "PRODUCTS")
@Component("productObj")
public class Product {

	@Id
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "productCode")
	private	String productCode;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "productName")
	private String productName;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "productLine")
	private ProductLine productLine;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "productScale")
	private String productScale;

	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "productVendor")
	private String productVendor;

	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "productDescription")
	private String productDescription;

	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "quantityInStock")
	private short quantityInStock;

	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "buyPrice")
	private double buyPrice;

	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "MSRP")
	private double MSRP;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public short getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(short quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getMSRP() {
		return MSRP;
	}

	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP="
				+ MSRP + "]";
	}
	
}
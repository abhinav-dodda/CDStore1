package com.musicBonanza.entity;

import java.io.Serializable;

/**
 * 
 * @author 
 * Entity class for CD
 *
 */
public class CD implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1859512008030281813L;
	private String ProductId;
	private String ProductName;
	private float ProdPrice;
	private String ProdCat;
	private float totalPrice;
	
	
	public String getProdCat() {
		return ProdCat;
	}
	public void setProdCat(String prodCat) {
		ProdCat = prodCat;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public float getProdPrice() {
		return ProdPrice;
	}
	public void setProdPrice(float prodPrice) {
		ProdPrice = prodPrice;
	}
	
	public void calculatePrice(float prodPrice)
	{
		totalPrice += prodPrice;
	}
	
	public float getcalculatePrice() {
		return totalPrice;
	}
	
	

}

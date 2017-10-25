package com.musicBonanza.entity;

public class CD {
	
	private int ProductId;
	private String ProductName;
	private float ProdPrice;
	private String ProdDesc;
	private String ImgUrl;
	
	public CD(int productId, String productName, float prodPrice, String prodDesc, String imgUrl)
	{
		ProductId = productId;
		ProductName = productName;
		ProdPrice = prodPrice;
		ProdDesc = prodDesc;
		ImgUrl = imgUrl;
	}
	
	public String getProdDesc() {
		return ProdDesc;
	}
	
	public void setProdDesc(String prodDesc) {
		ProdDesc = prodDesc;
	}
	public String getImgUrl() {
		return ImgUrl;
	}

	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
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
	
	

}

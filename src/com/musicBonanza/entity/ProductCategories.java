package com.musicBonanza.entity;

public class ProductCategories {
	public String CategoryName;
	public String CategoryID;
	public String Cdid;
	
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}

	public String getCdid() {
		return Cdid;
	}
	
	public void setCdid(String cdid) {
		Cdid = cdid;
	}
}

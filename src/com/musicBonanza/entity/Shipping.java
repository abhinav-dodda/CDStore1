package com.musicBonanza.entity;

import java.io.Serializable;

public class Shipping implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4768310005313444080L;
	private int shippingId;
	private String streetAddress;
	private String province;
	private String country;
	private String zipCode; 
    private String phone;
    
	public int getShippingId() {
		return shippingId;
	}
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Shipping [shippingId=" + shippingId + ", streetAddress=" + streetAddress + ", province=" + province
				+ ", country=" + country + ", zipCode=" + zipCode + ", phone=" + phone + "]";
	}
	

}

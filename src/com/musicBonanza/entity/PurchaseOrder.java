package com.musicBonanza.entity;

import java.util.HashSet;
import java.util.Set;

public class PurchaseOrder {
	
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getTotalamount() {
		return totalAmount;
	}

	public void setTotalamount(float totalamount) {
		this.totalAmount = totalamount;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public float getTaxes() {
		return taxes;
	}

	public void setTaxes(float taxes) {
		this.taxes = taxes;
	}

	public String getPurchaseOrderStatus() {
		return purchaseOrderStatus;
	}

	public void setPurchaseOrderStatus(String purchaseOrderStatus) {
		this.purchaseOrderStatus = purchaseOrderStatus;
	}

	public Set<PurchaseOrderItem> getPurchaseOrderItems() {
		return purchaseOrderItems;
	}

	public void setPurchaseOrderItems(Set<PurchaseOrderItem> purchaseOrderItems) {
		this.purchaseOrderItems = purchaseOrderItems;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShippings(Shipping shipping) {
		this.shipping = shipping;
	}

	private int purchaseOrderId;
	private User user; 
	private float totalAmount;
	private int totalQuantity;
	private float taxes; 
	private String purchaseOrderStatus;
	private Set<PurchaseOrderItem> purchaseOrderItems = new HashSet<PurchaseOrderItem>(0);
	private Shipping shipping;
	
	/*
	 * Default Constructor
	 */
	public PurchaseOrder() {
	}

	/*
	 * Parameterized constructor 
	 */
	public PurchaseOrder(User user, int totalQuantity, float totalAmount,float taxes,
			Set<PurchaseOrderItem> purchaseOrderItems, Shipping shipping)
	   {
		this.user = user;
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
		this.taxes = taxes;
		this.purchaseOrderItems = purchaseOrderItems;
		this.shipping = shipping;
	  }

	
	
}

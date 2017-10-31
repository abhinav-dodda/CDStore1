package com.musicBonanza.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author 
 * Entity class for the order
 *
 */
public class PurchaseOrder implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6259991776685940127L;

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

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	public String getPurchaseOrderStatus() {
		return purchaseOrderStatus;
	}

	public void setPurchaseOrderStatus(String purchaseOrderStatus) {
		this.purchaseOrderStatus = purchaseOrderStatus;
	}

	public List<PurchaseOrderItem> getPurchaseOrderItems() {
		return purchaseOrderItems;
	}

	public void setPurchaseOrderItems(List<PurchaseOrderItem> purchaseOrderItems) {
		this.purchaseOrderItems = purchaseOrderItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getShippingId() {
		return shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}



	private int purchaseOrderId;
	private User user; 
	private double totalAmount;
	private int totalQuantity;
	private double taxes; 
	private String purchaseOrderStatus;
	private List<PurchaseOrderItem> purchaseOrderItems = new ArrayList<PurchaseOrderItem>(0);
	private int shippingId;
	
	/*
	 * Default Constructor
	 */
	public PurchaseOrder() {
	}

	/*
	 * Parameterized constructor 
	 */
	public PurchaseOrder(User user, int totalQuantity, double totalAmount,double taxes,List<PurchaseOrderItem> purchaseOrderItems,
			 int shippingId)
	   {
		this.user = user;
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
		this.taxes = taxes;
		this.purchaseOrderItems = purchaseOrderItems;
		this.shippingId = shippingId;
	  }

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrderId=" + purchaseOrderId + ", user=" + user + ", totalAmount=" + totalAmount
				+ ", totalQuantity=" + totalQuantity + ", taxes=" + taxes + ", purchaseOrderStatus="
				+ purchaseOrderStatus + ", purchaseOrderItems=" + purchaseOrderItems + ", shippingId=" + shippingId
				+ "]";
	}

	
	
}

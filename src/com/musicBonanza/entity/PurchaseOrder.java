package com.musicBonanza.entity;

import java.util.HashSet;
import java.util.Set;

public class PurchaseOrder {
	
	private int purchaseOrderId;
	private User user; 
	private float totalamount;
	private int totalQuantity;
	private float taxes; 
	private String purchaseOrderStatus;
	private Set<PurchaseOrderItem> purchaseOrderItems = new HashSet<PurchaseOrderItem>(0);
	private Set<Shipping> shippings = new HashSet<Shipping>(0);

	public PurchaseOrder() {
	}

	public PurchaseOrder(User user, Integer totalQuantity, Integer totalamount, Float totalPrice, Float taxes,
			String purchaseOrderStatus, Set<PurchaseOrderItem> purchaseOrderItems, Set<Shipping> shippings)
	   {
		this.user = user;
		this.totalQuantity = totalQuantity;
		this.totalamount = totalamount;
		this.taxes = taxes;
		this.purchaseOrderStatus = purchaseOrderStatus;
		this.purchaseOrderItems = purchaseOrderItems;
		this.shippings = shippings;
	  }

	
	
}

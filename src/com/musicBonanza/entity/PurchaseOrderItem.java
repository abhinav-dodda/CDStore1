package com.musicBonanza.entity;

public class PurchaseOrderItem {

	private int purchaseOrderId;
	private String cdId;
	private double cdPrice;
	
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public String getCdId() {
		return cdId;
	}
	public void setCdId(String cdId) {
		this.cdId = cdId;
	}
	public double getCdPrice() {
		return cdPrice;
	}
	public void setCdPrice(double d) {
		this.cdPrice = d;
	}
	
}

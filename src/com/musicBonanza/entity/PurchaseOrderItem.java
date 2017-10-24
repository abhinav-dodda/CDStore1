package com.musicBonanza.entity;

public class PurchaseOrderItem {

	private int purchaseOrderId;
	private int cdId;
	private int cdPrice;
	
	
	
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public int getCdId() {
		return cdId;
	}
	public void setCdId(int cdId) {
		this.cdId = cdId;
	}
	public int getCdPrice() {
		return cdPrice;
	}
	public void setCdPrice(int cdPrice) {
		this.cdPrice = cdPrice;
	}
	
}

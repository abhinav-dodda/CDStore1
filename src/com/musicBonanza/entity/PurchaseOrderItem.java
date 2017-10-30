package com.musicBonanza.entity;

import java.io.Serializable;

/**
 * 
 * @author 
 * Entity class for purchased item
 *
 */
public class PurchaseOrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3173902450105647939L;
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
	@Override
	public String toString() {
		return "PurchaseOrderItem [purchaseOrderId=" + purchaseOrderId + ", cdId=" + cdId + ", cdPrice=" + cdPrice
				+ "]";
	}
	
}

package com.fir.open.sorce.entity;

/**
 * Delivery entity. @author MyEclipse Persistence Tools
 */

public class Delivery implements java.io.Serializable {

	// Fields

	private String deliveryAddressId;
	private Buyer buyer;
	private String receiver;
	private String phone;
	private String address;
	private String isDefault;

	// Constructors

	/** default constructor */
	public Delivery() {
	}

	/** full constructor */
	public Delivery(Buyer buyer, String receiver, String phone, String address,
			String isDefault) {
		this.buyer = buyer;
		this.receiver = receiver;
		this.phone = phone;
		this.address = address;
		this.isDefault = isDefault;
	}

	// Property accessors

	public String getDeliveryAddressId() {
		return this.deliveryAddressId;
	}

	public void setDeliveryAddressId(String deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

}
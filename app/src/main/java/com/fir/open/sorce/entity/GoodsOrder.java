package com.fir.open.sorce.entity;


import java.util.*;

/**
 * GoodsOrder entity. @author MyEclipse Persistence Tools
 */

public class GoodsOrder implements java.io.Serializable {

	// Fields

	private String goodsOrderId;
	private Shop shop;
	private Buyer buyer;
	private String deliveryTime;
	private String payMethod;
	private String payMoney;
	private String payTime;
	private String orderTime;
	private String orderStatus;
	private List orderItems = new ArrayList();

	// Constructors

	/** default constructor */
	public GoodsOrder() {
	}

	/** full constructor */
	public GoodsOrder(Shop shop, Buyer buyer, String deliveryTime,
			String payMethod, String payMoney, String payTime,
			String orderTime, String orderStatus, List orderItems) {
		this.shop = shop;
		this.buyer = buyer;
		this.deliveryTime = deliveryTime;
		this.payMethod = payMethod;
		this.payMoney = payMoney;
		this.payTime = payTime;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}

	// Property accessors

	public String getGoodsOrderId() {
		return this.goodsOrderId;
	}

	public void setGoodsOrderId(String goodsOrderId) {
		this.goodsOrderId = goodsOrderId;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public String getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getPayMoney() {
		return this.payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayTime() {
		return this.payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List orderItems) {
		this.orderItems = orderItems;
	}

}
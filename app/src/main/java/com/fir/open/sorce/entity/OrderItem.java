package com.fir.open.sorce.entity;

/**
 * OrderItem entity. @author MyEclipse Persistence Tools
 */

public class OrderItem implements java.io.Serializable {

	// Fields

	private String orderItemId;
	private GoodsOrder goodsOrder;
	private Goods goods;
	private String orderCount;
	private String closeingPrice;

	// Constructors

	/** default constructor */
	public OrderItem() {
	}

	/** full constructor */
	public OrderItem(GoodsOrder goodsOrder, Goods goods, String orderCount,
			String closeingPrice) {
		this.goodsOrder = goodsOrder;
		this.goods = goods;
		this.orderCount = orderCount;
		this.closeingPrice = closeingPrice;
	}

	// Property accessors

	public String getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public GoodsOrder getGoodsOrder() {
		return this.goodsOrder;
	}

	public void setGoodsOrder(GoodsOrder goodsOrder) {
		this.goodsOrder = goodsOrder;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getOrderCount() {
		return this.orderCount;
	}

	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	public String getCloseingPrice() {
		return this.closeingPrice;
	}

	public void setCloseingPrice(String closeingPrice) {
		this.closeingPrice = closeingPrice;
	}

}
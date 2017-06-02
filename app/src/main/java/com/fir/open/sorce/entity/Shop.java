package com.fir.open.sorce.entity;


import java.util.*;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */

public class Shop implements java.io.Serializable {

	// Fields

	private String shopId;
	private Seller seller;
	private String shopName;
	private String logoPic;
	private String address;
	private String phone;
	private List goodses = new ArrayList();
	private List brands = new ArrayList();
	private List goodsOrders = new ArrayList();

	// Constructors

	/** default constructor */
	public Shop() {
	}

	/** full constructor */
	public Shop(Seller seller, String shopName, String logoPic, String address,
			String phone, List goodses, List brands, List goodsOrders) {
		this.seller = seller;
		this.shopName = shopName;
		this.logoPic = logoPic;
		this.address = address;
		this.phone = phone;
		this.goodses = goodses;
		this.brands = brands;
		this.goodsOrders = goodsOrders;
	}

	// Property accessors

	public String getShopId() {
		return this.shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLogoPic() {
		return this.logoPic;
	}

	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List getGoodses() {
		return this.goodses;
	}

	public void setGoodses(List goodses) {
		this.goodses = goodses;
	}

	public List getBrands() {
		return this.brands;
	}

	public void setBrands(List brands) {
		this.brands = brands;
	}

	public List getGoodsOrders() {
		return this.goodsOrders;
	}

	public void setGoodsOrders(List goodsOrders) {
		this.goodsOrders = goodsOrders;
	}

}
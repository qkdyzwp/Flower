package com.fir.open.sorce.entity;


import java.util.*;

/**
 * Buyer entity. @author MyEclipse Persistence Tools
 */

public class Buyer implements java.io.Serializable {

	// Fields

	private String buyerId;
	private String name;
	private String phone;
	private String birthday;
	private String password;
	private List goodsOrders = new ArrayList();
	private List favoriteGoodses = new ArrayList();
	private List deliveries = new ArrayList();
	private List linkmans = new ArrayList();

	// Constructors

	/** default constructor */
	public Buyer() {
	}

	/** full constructor */
	public Buyer(String name, String phone, String birthday, List goodsOrders,
			List favoriteGoodses, List deliveries, List linkmans) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.goodsOrders = goodsOrders;
		this.favoriteGoodses = favoriteGoodses;
		this.deliveries = deliveries;
		this.linkmans = linkmans;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
// Property accessors

	public String getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public List getGoodsOrders() {
		return this.goodsOrders;
	}

	public void setGoodsOrders(List goodsOrders) {
		this.goodsOrders = goodsOrders;
	}

	public List getFavoriteGoodses() {
		return this.favoriteGoodses;
	}

	public void setFavoriteGoodses(List favoriteGoodses) {
		this.favoriteGoodses = favoriteGoodses;
	}

	public List getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(List deliveries) {
		this.deliveries = deliveries;
	}

	public List getLinkmans() {
		return this.linkmans;
	}

	public void setLinkmans(List linkmans) {
		this.linkmans = linkmans;
	}

}
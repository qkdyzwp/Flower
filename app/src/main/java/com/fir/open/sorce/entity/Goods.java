package com.fir.open.sorce.entity;


import java.util.*;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private String goodsId;
	private GoodsType goodsType;
	private Shop shop;
	private Brand brand;
	private String name;
	private String price;
	private String promotionPrice;
	private String flowerMeterial;
	private String flowerWord;
	private String additionalGift;
	private String distributionScope;
	private String description;
	private String goodsLabel;
	private String status;
	private List promotions = new ArrayList();
	private List orderItems = new ArrayList();
	private List favoriteGoodses = new ArrayList();
	private List goodsPics = new ArrayList();

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */
	public Goods(GoodsType goodsType, Shop shop, Brand brand, String name,
			String price, String promotionPrice, String flowerMeterial,
			String flowerWord, String additionalGift, String distributionScope,
			String description, String goodsLabel, String status,
			List promotions, List orderItems, List favoriteGoodses, List goodsPics) {
		this.goodsType = goodsType;
		this.shop = shop;
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.promotionPrice = promotionPrice;
		this.flowerMeterial = flowerMeterial;
		this.flowerWord = flowerWord;
		this.additionalGift = additionalGift;
		this.distributionScope = distributionScope;
		this.description = description;
		this.goodsLabel = goodsLabel;
		this.status = status;
		this.promotions = promotions;
		this.orderItems = orderItems;
		this.favoriteGoodses = favoriteGoodses;
		this.goodsPics = goodsPics;
	}

	// Property accessors

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public GoodsType getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPromotionPrice() {
		return this.promotionPrice;
	}

	public void setPromotionPrice(String promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public String getFlowerMeterial() {
		return this.flowerMeterial;
	}

	public void setFlowerMeterial(String flowerMeterial) {
		this.flowerMeterial = flowerMeterial;
	}

	public String getFlowerWord() {
		return this.flowerWord;
	}

	public void setFlowerWord(String flowerWord) {
		this.flowerWord = flowerWord;
	}

	public String getAdditionalGift() {
		return this.additionalGift;
	}

	public void setAdditionalGift(String additionalGift) {
		this.additionalGift = additionalGift;
	}

	public String getDistributionScope() {
		return this.distributionScope;
	}

	public void setDistributionScope(String distributionScope) {
		this.distributionScope = distributionScope;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGoodsLabel() {
		return this.goodsLabel;
	}

	public void setGoodsLabel(String goodsLabel) {
		this.goodsLabel = goodsLabel;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List getPromotions() {
		return this.promotions;
	}

	public void setPromotions(List promotions) {
		this.promotions = promotions;
	}

	public List getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List orderItems) {
		this.orderItems = orderItems;
	}

	public List getFavoriteGoodses() {
		return this.favoriteGoodses;
	}

	public void setFavoriteGoodses(List favoriteGoodses) {
		this.favoriteGoodses = favoriteGoodses;
	}

	public List getGoodsPics() {
		return this.goodsPics;
	}

	public void setGoodsPics(List goodsPics) {
		this.goodsPics = goodsPics;
	}

}
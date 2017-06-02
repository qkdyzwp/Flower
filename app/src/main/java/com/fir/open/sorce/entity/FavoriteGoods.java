package com.fir.open.sorce.entity;

/**
 * FavoriteGoods entity. @author MyEclipse Persistence Tools
 */

public class FavoriteGoods implements java.io.Serializable {

	// Fields

	private String favoriteGoodsId;
	private Goods goods;
	private Buyer buyer;

	// Constructors

	/** default constructor */
	public FavoriteGoods() {
	}

	/** full constructor */
	public FavoriteGoods(Goods goods, Buyer buyer) {
		this.goods = goods;
		this.buyer = buyer;
	}

	// Property accessors

	public String getFavoriteGoodsId() {
		return this.favoriteGoodsId;
	}

	public void setFavoriteGoodsId(String favoriteGoodsId) {
		this.favoriteGoodsId = favoriteGoodsId;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

}
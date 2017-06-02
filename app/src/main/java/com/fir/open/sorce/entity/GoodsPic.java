package com.fir.open.sorce.entity;

/**
 * GoodsPic entity. @author MyEclipse Persistence Tools
 */

public class GoodsPic implements java.io.Serializable {

	// Fields

	private String goodsPicId;
	private Goods goods;
	private String type;
	private String url;
	private String pic;

	// Constructors

	/** default constructor */
	public GoodsPic() {
	}

	/** full constructor */
	public GoodsPic(Goods goods, String type, String url, String pic) {
		this.goods = goods;
		this.type = type;
		this.url = url;
		this.pic = pic;
	}

	// Property accessors

	public String getGoodsPicId() {
		return this.goodsPicId;
	}

	public void setGoodsPicId(String goodsPicId) {
		this.goodsPicId = goodsPicId;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}
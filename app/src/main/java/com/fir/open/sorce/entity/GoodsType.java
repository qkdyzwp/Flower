package com.fir.open.sorce.entity;


import java.util.*;

/**
 * GoodsType entity. @author MyEclipse Persistence Tools
 */

public class GoodsType implements java.io.Serializable {

	// Fields

	private String goodsTypeId;
	private GoodsType goodsType;
	private String typeName;
	private String level;
	private List goodsTypes = new ArrayList();
	private List goodses = new ArrayList();

	// Constructors

	/** default constructor */
	public GoodsType() {
	}

	/** full constructor */
	public GoodsType(GoodsType goodsType, String typeName, String level,
			List goodsTypes, List goodses) {
		this.goodsType = goodsType;
		this.typeName = typeName;
		this.level = level;
		this.goodsTypes = goodsTypes;
		this.goodses = goodses;
	}

	// Property accessors

	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public GoodsType getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List getGoodsTypes() {
		return this.goodsTypes;
	}

	public void setGoodsTypes(List goodsTypes) {
		this.goodsTypes = goodsTypes;
	}

	public List getGoodses() {
		return this.goodses;
	}

	public void setGoodses(List goodses) {
		this.goodses = goodses;
	}

}
package com.fir.open.sorce.entity;


import java.util.*;

/**
 * Brand entity. @author MyEclipse Persistence Tools
 */

public class Brand implements java.io.Serializable {

	// Fields

	private String brandId;
	private String name;
	private String logoPic;
	private List goodses = new ArrayList();
	private List shops = new ArrayList();

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** full constructor */
	public Brand(String name, String logoPic, List goodses, List shops) {
		this.name = name;
		this.logoPic = logoPic;
		this.goodses = goodses;
		this.shops = shops;
	}

	// Property accessors

	public String getBrandId() {
		return this.brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoPic() {
		return this.logoPic;
	}

	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
	}

	public List getGoodses() {
		return this.goodses;
	}

	public void setGoodses(List goodses) {
		this.goodses = goodses;
	}

	public List getShops() {
		return this.shops;
	}

	public void setShops(List shops) {
		this.shops = shops;
	}

}
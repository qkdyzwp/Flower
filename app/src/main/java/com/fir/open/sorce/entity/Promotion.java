package com.fir.open.sorce.entity;


import java.util.*;

/**
 * Promotion entity. @author MyEclipse Persistence Tools
 */

public class Promotion implements java.io.Serializable {

	// Fields

	private String promotionId;
	private String name;
	private String createTime;
	private String logoPic;
	private String detail;
	private List goodses = new ArrayList();

	// Constructors

	/** default constructor */
	public Promotion() {
	}

	/** full constructor */
	public Promotion(String name, String createTime, String logoPic,
			String detail, List goodses) {
		this.name = name;
		this.createTime = createTime;
		this.logoPic = logoPic;
		this.detail = detail;
		this.goodses = goodses;
	}

	// Property accessors

	public String getPromotionId() {
		return this.promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLogoPic() {
		return this.logoPic;
	}

	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List getGoodses() {
		return this.goodses;
	}

	public void setGoodses(List goodses) {
		this.goodses = goodses;
	}

}
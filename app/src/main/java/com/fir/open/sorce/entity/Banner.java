package com.fir.open.sorce.entity;

/**
 * Banner entity. @author MyEclipse Persistence Tools
 */

public class Banner implements java.io.Serializable {

	// Fields

	private String bannerId;
	private String picUrl;
	private String linkUrl;
	private String beginTime;
	private String endTime;

	// Constructors

	/** default constructor */
	public Banner() {
	}

	/** full constructor */
	public Banner(String picUrl, String linkUrl, String beginTime,
			String endTime) {
		this.picUrl = picUrl;
		this.linkUrl = linkUrl;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	// Property accessors

	public String getBannerId() {
		return this.bannerId;
	}

	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
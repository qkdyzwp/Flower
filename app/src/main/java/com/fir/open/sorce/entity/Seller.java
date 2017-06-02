package com.fir.open.sorce.entity;


import java.util.*;

/**
 * Seller entity. @author MyEclipse Persistence Tools
 */

public class Seller implements java.io.Serializable {

	// Fields

	private String sellerId;
	private String name;
	private String account;
	private String email;
	private String phone;
	private String applyTime;
	private String approvalTime;
	private String approvalStatus;
	private String status;
	private List shops = new ArrayList();

	// Constructors

	/** default constructor */
	public Seller() {
	}

	/** full constructor */
	public Seller(String name, String account, String email, String phone,
			String applyTime, String approvalTime, String approvalStatus,
			String status, List shops) {
		this.name = name;
		this.account = account;
		this.email = email;
		this.phone = phone;
		this.applyTime = applyTime;
		this.approvalTime = approvalTime;
		this.approvalStatus = approvalStatus;
		this.status = status;
		this.shops = shops;
	}

	// Property accessors

	public String getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getApprovalTime() {
		return this.approvalTime;
	}

	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List getShops() {
		return this.shops;
	}

	public void setShops(List shops) {
		this.shops = shops;
	}

}
package com.fir.open.sorce.entity;

/**
 * HpAccount entity. @author MyEclipse Persistence Tools
 */

public class HpAccount implements java.io.Serializable {

	// Fields

	private String accountId;
	private HpRole hpRole;
	private String accountName;
	private String password;
	private String state;
	private String createTime;

	// Constructors

	/** default constructor */
	public HpAccount() {
	}

	/** full constructor */
	public HpAccount(HpRole hpRole, String accountName, String password,
			String state, String createTime) {
		this.hpRole = hpRole;
		this.accountName = accountName;
		this.password = password;
		this.state = state;
		this.createTime = createTime;
	}

	// Property accessors

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public HpRole getHpRole() {
		return this.hpRole;
	}

	public void setHpRole(HpRole hpRole) {
		this.hpRole = hpRole;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
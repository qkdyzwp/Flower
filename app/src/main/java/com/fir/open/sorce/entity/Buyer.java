package com.fir.open.sorce.entity;


import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
/**
 * Buyer entity. @author MyEclipse Persistence Tools
 */
@Table(name = "buyer")
public class Buyer {
	// Fields
	@Column(name = "id", isId = true)
	private String id;//用户id
	@Column(name = "buyerId")
	private String buyerId;
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "birthday")
	private String birthday;
	@Column(name = "password")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
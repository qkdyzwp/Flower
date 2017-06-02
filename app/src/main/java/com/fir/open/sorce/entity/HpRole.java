package com.fir.open.sorce.entity;


import java.util.*;


/**
 * HpRole entity. @author MyEclipse Persistence Tools
 */

public class HpRole implements java.io.Serializable {

	// Fields

	private String roleId;

	private List<HpFunction> hpFunctions = new ArrayList();

	private List<HpAccount> hpAccounts = new ArrayList();

	// Constructors

	/** default constructor */
	public HpRole() {
	}

	/** full constructor */
	public HpRole(String roleName, List hpFunctions, List hpAccounts) {
		this.hpFunctions = hpFunctions;
		this.hpAccounts = hpAccounts;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<HpFunction> getHpFunctions() {
		return this.hpFunctions;
	}

	public void setHpFunctions(List<HpFunction> hpFunctions) {
		this.hpFunctions = hpFunctions;
	}

	public List getHpAccounts() {
		return this.hpAccounts;
	}

	public void setHpAccounts(List hpAccounts) {
		this.hpAccounts = hpAccounts;
	}

}
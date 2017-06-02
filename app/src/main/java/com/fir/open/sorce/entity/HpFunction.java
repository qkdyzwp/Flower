package com.fir.open.sorce.entity;


import java.util.*;


/**
 * HpFunction entity. @author MyEclipse Persistence Tools
 */

public class HpFunction implements java.io.Serializable {

	// Fields

	private String functionId;
	private HpFunctionGroup hpFunctionGroup;
	private String functionName;
	private String url;
	private String sortNo;
	private List<HpRole> hpRoles = new ArrayList();

	// Constructors

	/** default constructor */
	public HpFunction() {
	}

	/** full constructor */
	public HpFunction(HpFunctionGroup hpFunctionGroup, String functionName,
			String url, String sortNo, List hpRoles) {
		this.hpFunctionGroup = hpFunctionGroup;
		this.functionName = functionName;
		this.url = url;
		this.sortNo = sortNo;
		this.hpRoles = hpRoles;
	}

	// Property accessors

	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public HpFunctionGroup getHpFunctionGroup() {
		return this.hpFunctionGroup;
	}

	public void setHpFunctionGroup(HpFunctionGroup hpFunctionGroup) {
		this.hpFunctionGroup = hpFunctionGroup;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSortNo() {
		return this.sortNo;
	}

	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}

	public List getHpRoles() {
		return this.hpRoles;
	}

	public void setHpRoles(List hpRoles) {
		this.hpRoles = hpRoles;
	}

}
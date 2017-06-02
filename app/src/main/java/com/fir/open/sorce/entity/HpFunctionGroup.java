package com.fir.open.sorce.entity;


import java.util.*;


/**
 * HpFunctionGroup entity. @author MyEclipse Persistence Tools
 */

public class HpFunctionGroup implements java.io.Serializable {

	// Fields

	private String functionGroupId;
	private String functionGroupName;
	private String sortNo;
	private List<HpFunction> hpFunctions = new ArrayList();

	// Constructors

	/** default constructor */
	public HpFunctionGroup() {
	}

	/** full constructor */
	public HpFunctionGroup(String functionGroupName, String sortNo,
			List hpFunctions) {
		this.functionGroupName = functionGroupName;
		this.sortNo = sortNo;
		this.hpFunctions = hpFunctions;
	}

	// Property accessors

	public String getFunctionGroupId() {
		return this.functionGroupId;
	}

	public void setFunctionGroupId(String functionGroupId) {
		this.functionGroupId = functionGroupId;
	}

	public String getFunctionGroupName() {
		return this.functionGroupName;
	}

	public void setFunctionGroupName(String functionGroupName) {
		this.functionGroupName = functionGroupName;
	}

	public String getSortNo() {
		return this.sortNo;
	}

	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}

	public List getHpFunctions() {
		return this.hpFunctions;
	}

	public void setHpFunctions(List hpFunctions) {
		this.hpFunctions = hpFunctions;
	}

}
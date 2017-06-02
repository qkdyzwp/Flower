package com.fir.open.sorce.entity;

/**
 * HpServiceInterface entity. @author MyEclipse Persistence Tools
 */

public class HpServiceInterface implements java.io.Serializable {

	// Fields

	private String serviceInterfaceId;
	private String name;
	private String entityName;
	private String operation;
	private String isOpen;
	private String remark;
	private String inputParameter;
	private String outputField;

	// Constructors

	/** default constructor */
	public HpServiceInterface() {
	}

	/** full constructor */
	public HpServiceInterface(String name, String entityName, String operation,
			String isOpen, String remark, String inputParameter,
			String outputField) {
		this.name = name;
		this.entityName = entityName;
		this.operation = operation;
		this.isOpen = isOpen;
		this.remark = remark;
		this.inputParameter = inputParameter;
		this.outputField = outputField;
	}

	// Property accessors

	public String getServiceInterfaceId() {
		return this.serviceInterfaceId;
	}

	public void setServiceInterfaceId(String serviceInterfaceId) {
		this.serviceInterfaceId = serviceInterfaceId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEntityName() {
		return this.entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getInputParameter() {
		return this.inputParameter;
	}

	public void setInputParameter(String inputParameter) {
		this.inputParameter = inputParameter;
	}

	public String getOutputField() {
		return this.outputField;
	}

	public void setOutputField(String outputField) {
		this.outputField = outputField;
	}

}
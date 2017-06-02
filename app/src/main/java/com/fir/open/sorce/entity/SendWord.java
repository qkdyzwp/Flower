package com.fir.open.sorce.entity;

/**
 * SendWord entity. @author MyEclipse Persistence Tools
 */

public class SendWord implements java.io.Serializable {

	// Fields

	private String sendWordId;
	private String wordContent;
	private String wordLabel;

	// Constructors

	/** default constructor */
	public SendWord() {
	}

	/** full constructor */
	public SendWord(String wordContent, String wordLabel) {
		this.wordContent = wordContent;
		this.wordLabel = wordLabel;
	}

	// Property accessors

	public String getSendWordId() {
		return this.sendWordId;
	}

	public void setSendWordId(String sendWordId) {
		this.sendWordId = sendWordId;
	}

	public String getWordContent() {
		return this.wordContent;
	}

	public void setWordContent(String wordContent) {
		this.wordContent = wordContent;
	}

	public String getWordLabel() {
		return this.wordLabel;
	}

	public void setWordLabel(String wordLabel) {
		this.wordLabel = wordLabel;
	}

}
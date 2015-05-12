package edu.bu.ist.coi.db;

/**
 * CoiPrintCodes entity. @author MyEclipse Persistence Tools
 */

public class CoiPrintCodes implements java.io.Serializable {

	// Fields

	private String codeId;
	private CoiDisclosure coiDisclosure;
	private Boolean isExpired;

	// Constructors

	/** default constructor */
	public CoiPrintCodes() {
	}

	/** full constructor */
	public CoiPrintCodes(String codeId, CoiDisclosure coiDisclosure,
			Boolean isExpired) {
		this.codeId = codeId;
		this.coiDisclosure = coiDisclosure;
		this.isExpired = isExpired;
	}

	// Property accessors

	public String getCodeId() {
		return this.codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public CoiDisclosure getCoiDisclosure() {
		return this.coiDisclosure;
	}

	public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
		this.coiDisclosure = coiDisclosure;
	}

	public Boolean getIsExpired() {
		return this.isExpired;
	}

	public void setIsExpired(Boolean isExpired) {
		this.isExpired = isExpired;
	}

}
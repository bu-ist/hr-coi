package edu.bu.ist.coi.db;

/**
 * CoiFamRel entity. @author MyEclipse Persistence Tools
 */

public class CoiFamRel implements java.io.Serializable {

	// Fields

	private Integer famRelId;
	private CoiDisclosure coiDisclosure;
	private String famRelFirst;
	private String famRelLast;
	private String famRelRelationship;
	private String famRelTitle;
	private String famRelDepartment;

	// Constructors

	/** default constructor */
	public CoiFamRel() {
	}

	/** minimal constructor */
	public CoiFamRel(Integer famRelId, CoiDisclosure coiDisclosure) {
		this.famRelId = famRelId;
		this.coiDisclosure = coiDisclosure;
	}

	/** full constructor */
	public CoiFamRel(Integer famRelId, CoiDisclosure coiDisclosure,
			String famRelFirst, String famRelLast, String famRelRelationship,
			String famRelTitle, String famRelDepartment) {
		this.famRelId = famRelId;
		this.coiDisclosure = coiDisclosure;
		this.famRelFirst = famRelFirst;
		this.famRelLast = famRelLast;
		this.famRelRelationship = famRelRelationship;
		this.famRelTitle = famRelTitle;
		this.famRelDepartment = famRelDepartment;
	}

	// Property accessors

	public Integer getFamRelId() {
		return this.famRelId;
	}

	public void setFamRelId(Integer famRelId) {
		this.famRelId = famRelId;
	}

	public CoiDisclosure getCoiDisclosure() {
		return this.coiDisclosure;
	}

	public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
		this.coiDisclosure = coiDisclosure;
	}

	public String getFamRelFirst() {
		return this.famRelFirst;
	}

	public void setFamRelFirst(String famRelFirst) {
		this.famRelFirst = famRelFirst;
	}

	public String getFamRelLast() {
		return this.famRelLast;
	}

	public void setFamRelLast(String famRelLast) {
		this.famRelLast = famRelLast;
	}

	public String getFamRelRelationship() {
		return this.famRelRelationship;
	}

	public void setFamRelRelationship(String famRelRelationship) {
		this.famRelRelationship = famRelRelationship;
	}

	public String getFamRelTitle() {
		return this.famRelTitle;
	}

	public void setFamRelTitle(String famRelTitle) {
		this.famRelTitle = famRelTitle;
	}

	public String getFamRelDepartment() {
		return this.famRelDepartment;
	}

	public void setFamRelDepartment(String famRelDepartment) {
		this.famRelDepartment = famRelDepartment;
	}

}
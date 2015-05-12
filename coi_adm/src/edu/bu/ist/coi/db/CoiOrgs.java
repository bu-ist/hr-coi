package edu.bu.ist.coi.db;

/**
 * CoiOrgs entity. @author MyEclipse Persistence Tools
 */

public class CoiOrgs implements java.io.Serializable {

	// Fields

	private Integer orgId;
	private CoiDisclosure coiDisclosure;
	private String orgName;
	private String orgPosition;
	private String orgCompensation;

	// Constructors

	/** default constructor */
	public CoiOrgs() {
	}

	/** minimal constructor */
	public CoiOrgs(Integer orgId, CoiDisclosure coiDisclosure) {
		this.orgId = orgId;
		this.coiDisclosure = coiDisclosure;
	}

	/** full constructor */
	public CoiOrgs(Integer orgId, CoiDisclosure coiDisclosure, String orgName,
			String orgPosition, String orgCompensation) {
		this.orgId = orgId;
		this.coiDisclosure = coiDisclosure;
		this.orgName = orgName;
		this.orgPosition = orgPosition;
		this.orgCompensation = orgCompensation;
	}

	// Property accessors

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public CoiDisclosure getCoiDisclosure() {
		return this.coiDisclosure;
	}

	public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
		this.coiDisclosure = coiDisclosure;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgPosition() {
		return this.orgPosition;
	}

	public void setOrgPosition(String orgPosition) {
		this.orgPosition = orgPosition;
	}

	public String getOrgCompensation() {
		return this.orgCompensation;
	}

	public void setOrgCompensation(String orgCompensation) {
		this.orgCompensation = orgCompensation;
	}

}
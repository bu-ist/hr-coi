package edu.bu.ist.coi.db;

/**
 * CoiFinRel entity. @author MyEclipse Persistence Tools
 */

public class CoiFinRel implements java.io.Serializable {

	// Fields

	private Integer finRelId;
	private CoiDisclosure coiDisclosure;
	private String finRelFirst;
	private String finRelLast;
	private String finRelRelationship;
	private String finRelEntityName;
	private String finRelEntityRelation;
	private String finRelValue;
	private String finRelMonitor;
	private String finRelEstablished;
	private String finRelInterest;

	// Constructors

	/** default constructor */
	public CoiFinRel() {
	}

	/** minimal constructor */
	public CoiFinRel(Integer finRelId, CoiDisclosure coiDisclosure) {
		this.finRelId = finRelId;
		this.coiDisclosure = coiDisclosure;
	}

	/** full constructor */
	public CoiFinRel(Integer finRelId, CoiDisclosure coiDisclosure,
			String finRelFirst, String finRelLast, String finRelRelationship,
			String finRelEntityName, String finRelEntityRelation,
			String finRelValue, String finRelMonitor, String finRelEstablished,
			String finRelInterest) {
		this.finRelId = finRelId;
		this.coiDisclosure = coiDisclosure;
		this.finRelFirst = finRelFirst;
		this.finRelLast = finRelLast;
		this.finRelRelationship = finRelRelationship;
		this.finRelEntityName = finRelEntityName;
		this.finRelEntityRelation = finRelEntityRelation;
		this.finRelValue = finRelValue;
		this.finRelMonitor = finRelMonitor;
		this.finRelEstablished = finRelEstablished;
		this.finRelInterest = finRelInterest;
	}

	// Property accessors

	public Integer getFinRelId() {
		return this.finRelId;
	}

	public void setFinRelId(Integer finRelId) {
		this.finRelId = finRelId;
	}

	public CoiDisclosure getCoiDisclosure() {
		return this.coiDisclosure;
	}

	public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
		this.coiDisclosure = coiDisclosure;
	}

	public String getFinRelFirst() {
		return this.finRelFirst;
	}

	public void setFinRelFirst(String finRelFirst) {
		this.finRelFirst = finRelFirst;
	}

	public String getFinRelLast() {
		return this.finRelLast;
	}

	public void setFinRelLast(String finRelLast) {
		this.finRelLast = finRelLast;
	}

	public String getFinRelRelationship() {
		return this.finRelRelationship;
	}

	public void setFinRelRelationship(String finRelRelationship) {
		this.finRelRelationship = finRelRelationship;
	}

	public String getFinRelEntityName() {
		return this.finRelEntityName;
	}

	public void setFinRelEntityName(String finRelEntityName) {
		this.finRelEntityName = finRelEntityName;
	}

	public String getFinRelEntityRelation() {
		return this.finRelEntityRelation;
	}

	public void setFinRelEntityRelation(String finRelEntityRelation) {
		this.finRelEntityRelation = finRelEntityRelation;
	}

	public String getFinRelValue() {
		return this.finRelValue;
	}

	public void setFinRelValue(String finRelValue) {
		this.finRelValue = finRelValue;
	}

	public String getFinRelMonitor() {
		return this.finRelMonitor;
	}

	public void setFinRelMonitor(String finRelMonitor) {
		this.finRelMonitor = finRelMonitor;
	}

	public String getFinRelEstablished() {
		return this.finRelEstablished;
	}

	public void setFinRelEstablished(String finRelEstablished) {
		this.finRelEstablished = finRelEstablished;
	}

	public String getFinRelInterest() {
		return this.finRelInterest;
	}

	public void setFinRelInterest(String finRelInterest) {
		this.finRelInterest = finRelInterest;
	}

}
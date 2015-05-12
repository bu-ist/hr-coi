package edu.bu.ist.coi.db;

/**
 * CoiActive entity. @author MyEclipse Persistence Tools
 */

public class CoiActive implements java.io.Serializable {

	// Fields

	private CoiActiveId id;
	private Boolean isSeniorAdmin;

	// Constructors

	/** default constructor */
	public CoiActive() {
	}

	/** full constructor */
	public CoiActive(CoiActiveId id, Boolean isSeniorAdmin) {
		this.id = id;
		this.isSeniorAdmin = isSeniorAdmin;
	}

	// Property accessors

	public CoiActiveId getId() {
		return this.id;
	}

	public void setId(CoiActiveId id) {
		this.id = id;
	}

	public Boolean getIsSeniorAdmin() {
		return this.isSeniorAdmin;
	}

	public void setIsSeniorAdmin(Boolean isSeniorAdmin) {
		this.isSeniorAdmin = isSeniorAdmin;
	}

}
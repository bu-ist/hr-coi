package edu.bu.ist.coi.db;

/**
 * CoiSupervisors entity. @author MyEclipse Persistence Tools
 */

public class CoiSupervisors implements java.io.Serializable {

	// Fields

	private Integer supervisorId;
	private CoiDisclosure coiDisclosure;
	private String supervisorFirst;
	private String supervisorLast;
	private String supervisorTitle;

	// Constructors

	/** default constructor */
	public CoiSupervisors() {
	}

	/** minimal constructor */
	public CoiSupervisors(Integer supervisorId, CoiDisclosure coiDisclosure) {
		this.supervisorId = supervisorId;
		this.coiDisclosure = coiDisclosure;
	}

	/** full constructor */
	public CoiSupervisors(Integer supervisorId, CoiDisclosure coiDisclosure,
			String supervisorFirst, String supervisorLast,
			String supervisorTitle) {
		this.supervisorId = supervisorId;
		this.coiDisclosure = coiDisclosure;
		this.supervisorFirst = supervisorFirst;
		this.supervisorLast = supervisorLast;
		this.supervisorTitle = supervisorTitle;
	}

	// Property accessors

	public Integer getSupervisorId() {
		return this.supervisorId;
	}

	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}

	public CoiDisclosure getCoiDisclosure() {
		return this.coiDisclosure;
	}

	public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
		this.coiDisclosure = coiDisclosure;
	}

	public String getSupervisorFirst() {
		return this.supervisorFirst;
	}

	public void setSupervisorFirst(String supervisorFirst) {
		this.supervisorFirst = supervisorFirst;
	}

	public String getSupervisorLast() {
		return this.supervisorLast;
	}

	public void setSupervisorLast(String supervisorLast) {
		this.supervisorLast = supervisorLast;
	}

	public String getSupervisorTitle() {
		return this.supervisorTitle;
	}

	public void setSupervisorTitle(String supervisorTitle) {
		this.supervisorTitle = supervisorTitle;
	}

}
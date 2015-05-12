package edu.bu.ist.coi.db;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * CoiDisclosure entity. @author MyEclipse Persistence Tools
 */

public class CoiDisclosure implements java.io.Serializable {

	// Fields

	private Integer disId;
	private CoiEmployee coiEmployee;
	private Boolean disIsEmp;
	private Boolean disIsFamEmployed;
	private Boolean disIsFinRel;
	private Boolean disIsOrgAgent;
	private Boolean disCertified;
	private Timestamp disDate;
	private Integer disPeriod;
	private String disSigFname;
	private String disSigLname;
	private Boolean disIsPaper;
	private Set coiFamRels = new HashSet(0);
	private Set coiFinRels = new HashSet(0);
	private Set coiOrgses = new HashSet(0);
	private Set coiSupervisorses = new HashSet(0);
	private Set coiPrintCodeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public CoiDisclosure() {
	}

	/** minimal constructor */
	public CoiDisclosure(Integer disId, CoiEmployee coiEmployee,
			Boolean disIsEmp, Boolean disIsFamEmployed, Boolean disIsFinRel,
			Boolean disIsOrgAgent, Boolean disCertified, Timestamp disDate,
			Boolean disIsPaper) {
		this.disId = disId;
		this.coiEmployee = coiEmployee;
		this.disIsEmp = disIsEmp;
		this.disIsFamEmployed = disIsFamEmployed;
		this.disIsFinRel = disIsFinRel;
		this.disIsOrgAgent = disIsOrgAgent;
		this.disCertified = disCertified;
		this.disDate = disDate;
		this.disIsPaper = disIsPaper;
	}

	/** full constructor */
	public CoiDisclosure(Integer disId, CoiEmployee coiEmployee,
			Boolean disIsEmp, Boolean disIsFamEmployed, Boolean disIsFinRel,
			Boolean disIsOrgAgent, Boolean disCertified, Timestamp disDate,
			Integer disPeriod, String disSigFname, String disSigLname,
			Boolean disIsPaper, Set coiFamRels, Set coiFinRels, Set coiOrgses,
			Set coiSupervisorses, Set coiPrintCodeses) {
		this.disId = disId;
		this.coiEmployee = coiEmployee;
		this.disIsEmp = disIsEmp;
		this.disIsFamEmployed = disIsFamEmployed;
		this.disIsFinRel = disIsFinRel;
		this.disIsOrgAgent = disIsOrgAgent;
		this.disCertified = disCertified;
		this.disDate = disDate;
		this.disPeriod = disPeriod;
		this.disSigFname = disSigFname;
		this.disSigLname = disSigLname;
		this.disIsPaper = disIsPaper;
		this.coiFamRels = coiFamRels;
		this.coiFinRels = coiFinRels;
		this.coiOrgses = coiOrgses;
		this.coiSupervisorses = coiSupervisorses;
		this.coiPrintCodeses = coiPrintCodeses;
	}

	// Property accessors

	public Integer getDisId() {
		return this.disId;
	}

	public void setDisId(Integer disId) {
		this.disId = disId;
	}

	public CoiEmployee getCoiEmployee() {
		return this.coiEmployee;
	}

	public void setCoiEmployee(CoiEmployee coiEmployee) {
		this.coiEmployee = coiEmployee;
	}

	public Boolean getDisIsEmp() {
		return this.disIsEmp;
	}

	public void setDisIsEmp(Boolean disIsEmp) {
		this.disIsEmp = disIsEmp;
	}

	public Boolean getDisIsFamEmployed() {
		return this.disIsFamEmployed;
	}

	public void setDisIsFamEmployed(Boolean disIsFamEmployed) {
		this.disIsFamEmployed = disIsFamEmployed;
	}

	public Boolean getDisIsFinRel() {
		return this.disIsFinRel;
	}

	public void setDisIsFinRel(Boolean disIsFinRel) {
		this.disIsFinRel = disIsFinRel;
	}

	public Boolean getDisIsOrgAgent() {
		return this.disIsOrgAgent;
	}

	public void setDisIsOrgAgent(Boolean disIsOrgAgent) {
		this.disIsOrgAgent = disIsOrgAgent;
	}

	public Boolean getDisCertified() {
		return this.disCertified;
	}

	public void setDisCertified(Boolean disCertified) {
		this.disCertified = disCertified;
	}

	public Timestamp getDisDate() {
		return this.disDate;
	}

	public void setDisDate(Timestamp disDate) {
		this.disDate = disDate;
	}

	public Integer getDisPeriod() {
		return this.disPeriod;
	}

	public void setDisPeriod(Integer disPeriod) {
		this.disPeriod = disPeriod;
	}

	public String getDisSigFname() {
		return this.disSigFname;
	}

	public void setDisSigFname(String disSigFname) {
		this.disSigFname = disSigFname;
	}

	public String getDisSigLname() {
		return this.disSigLname;
	}

	public void setDisSigLname(String disSigLname) {
		this.disSigLname = disSigLname;
	}

	public Boolean getDisIsPaper() {
		return this.disIsPaper;
	}

	public void setDisIsPaper(Boolean disIsPaper) {
		this.disIsPaper = disIsPaper;
	}

	public Set getCoiFamRels() {
		return this.coiFamRels;
	}

	public void setCoiFamRels(Set coiFamRels) {
		this.coiFamRels = coiFamRels;
	}

	public Set getCoiFinRels() {
		return this.coiFinRels;
	}

	public void setCoiFinRels(Set coiFinRels) {
		this.coiFinRels = coiFinRels;
	}

	public Set getCoiOrgses() {
		return this.coiOrgses;
	}

	public void setCoiOrgses(Set coiOrgses) {
		this.coiOrgses = coiOrgses;
	}

	public Set getCoiSupervisorses() {
		return this.coiSupervisorses;
	}

	public void setCoiSupervisorses(Set coiSupervisorses) {
		this.coiSupervisorses = coiSupervisorses;
	}

	public Set getCoiPrintCodeses() {
		return this.coiPrintCodeses;
	}

	public void setCoiPrintCodeses(Set coiPrintCodeses) {
		this.coiPrintCodeses = coiPrintCodeses;
	}

}
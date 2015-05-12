package edu.bu.ist.coi.db;

import java.util.HashSet;
import java.util.Set;

/**
 * CoiEmployee entity. @author MyEclipse Persistence Tools
 */

public class CoiEmployee implements java.io.Serializable {

	// Fields

	private String empUid;
	private String empId;
	private String empLname;
	private String empFname;
	private String empMinitial;
	private String empPayrollFile;
	private String empF5;
	private Integer empGrade;
	private String empF7;
	private String empF8;
	private String empDept;
	private String empTitle;
	private String empAddress;
	private String empMailCode;
	private String empAlias;
	private Boolean empActive;
	private String empDisplayName;
	private Set coiInvitationses = new HashSet(0);
	private Set coiActives = new HashSet(0);
	private Set coiDisclosures = new HashSet(0);

	// Constructors

	/** default constructor */
	public CoiEmployee() {
	}

	/** minimal constructor */
	public CoiEmployee(String empUid, String empId) {
		this.empUid = empUid;
		this.empId = empId;
	}

	/** full constructor */
	public CoiEmployee(String empUid, String empId, String empLname,
			String empFname, String empMinitial, String empPayrollFile,
			String empF5, Integer empGrade, String empF7, String empF8,
			String empDept, String empTitle, String empAddress,
			String empMailCode, String empAlias, Boolean empActive,
			String empDisplayName, Set coiInvitationses, Set coiActives,
			Set coiDisclosures) {
		this.empUid = empUid;
		this.empId = empId;
		this.empLname = empLname;
		this.empFname = empFname;
		this.empMinitial = empMinitial;
		this.empPayrollFile = empPayrollFile;
		this.empF5 = empF5;
		this.empGrade = empGrade;
		this.empF7 = empF7;
		this.empF8 = empF8;
		this.empDept = empDept;
		this.empTitle = empTitle;
		this.empAddress = empAddress;
		this.empMailCode = empMailCode;
		this.empAlias = empAlias;
		this.empActive = empActive;
		this.empDisplayName = empDisplayName;
		this.coiInvitationses = coiInvitationses;
		this.coiActives = coiActives;
		this.coiDisclosures = coiDisclosures;
	}

	// Property accessors

	public String getEmpUid() {
		return this.empUid;
	}

	public void setEmpUid(String empUid) {
		this.empUid = empUid;
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpLname() {
		return this.empLname;
	}

	public void setEmpLname(String empLname) {
		this.empLname = empLname;
	}

	public String getEmpFname() {
		return this.empFname;
	}

	public void setEmpFname(String empFname) {
		this.empFname = empFname;
	}

	public String getEmpMinitial() {
		return this.empMinitial;
	}

	public void setEmpMinitial(String empMinitial) {
		this.empMinitial = empMinitial;
	}

	public String getEmpPayrollFile() {
		return this.empPayrollFile;
	}

	public void setEmpPayrollFile(String empPayrollFile) {
		this.empPayrollFile = empPayrollFile;
	}

	public String getEmpF5() {
		return this.empF5;
	}

	public void setEmpF5(String empF5) {
		this.empF5 = empF5;
	}

	public Integer getEmpGrade() {
		return this.empGrade;
	}

	public void setEmpGrade(Integer empGrade) {
		this.empGrade = empGrade;
	}

	public String getEmpF7() {
		return this.empF7;
	}

	public void setEmpF7(String empF7) {
		this.empF7 = empF7;
	}

	public String getEmpF8() {
		return this.empF8;
	}

	public void setEmpF8(String empF8) {
		this.empF8 = empF8;
	}

	public String getEmpDept() {
		return this.empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpTitle() {
		return this.empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	public String getEmpAddress() {
		return this.empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpMailCode() {
		return this.empMailCode;
	}

	public void setEmpMailCode(String empMailCode) {
		this.empMailCode = empMailCode;
	}

	public String getEmpAlias() {
		return this.empAlias;
	}

	public void setEmpAlias(String empAlias) {
		this.empAlias = empAlias;
	}

	public Boolean getEmpActive() {
		return this.empActive;
	}

	public void setEmpActive(Boolean empActive) {
		this.empActive = empActive;
	}

	public String getEmpDisplayName() {
		return this.empDisplayName;
	}

	public void setEmpDisplayName(String empDisplayName) {
		this.empDisplayName = empDisplayName;
	}

	public Set getCoiInvitationses() {
		return this.coiInvitationses;
	}

	public void setCoiInvitationses(Set coiInvitationses) {
		this.coiInvitationses = coiInvitationses;
	}

	public Set getCoiActives() {
		return this.coiActives;
	}

	public void setCoiActives(Set coiActives) {
		this.coiActives = coiActives;
	}

	public Set getCoiDisclosures() {
		return this.coiDisclosures;
	}

	public void setCoiDisclosures(Set coiDisclosures) {
		this.coiDisclosures = coiDisclosures;
	}

}
package edu.bu.ist.coi.db;

import java.sql.Timestamp;

/**
 * CoiInvitations entity. @author MyEclipse Persistence Tools
 */

public class CoiInvitations implements java.io.Serializable {

	// Fields

	private String inviteId;
	private CoiEmployee coiEmployee;
	private Timestamp invExpDate;
	private Boolean invSingleUse;
	private Boolean invExpired;
	private Integer disPeriod;
	private String invUrl;

	// Constructors

	/** default constructor */
	public CoiInvitations() {
	}

	/** minimal constructor */
	public CoiInvitations(String inviteId, CoiEmployee coiEmployee,
			Timestamp invExpDate, Boolean invSingleUse, Boolean invExpired,
			Integer disPeriod) {
		this.inviteId = inviteId;
		this.coiEmployee = coiEmployee;
		this.invExpDate = invExpDate;
		this.invSingleUse = invSingleUse;
		this.invExpired = invExpired;
		this.disPeriod = disPeriod;
	}

	/** full constructor */
	public CoiInvitations(String inviteId, CoiEmployee coiEmployee,
			Timestamp invExpDate, Boolean invSingleUse, Boolean invExpired,
			Integer disPeriod, String invUrl) {
		this.inviteId = inviteId;
		this.coiEmployee = coiEmployee;
		this.invExpDate = invExpDate;
		this.invSingleUse = invSingleUse;
		this.invExpired = invExpired;
		this.disPeriod = disPeriod;
		this.invUrl = invUrl;
	}

	// Property accessors

	public String getInviteId() {
		return this.inviteId;
	}

	public void setInviteId(String inviteId) {
		this.inviteId = inviteId;
	}

	public CoiEmployee getCoiEmployee() {
		return this.coiEmployee;
	}

	public void setCoiEmployee(CoiEmployee coiEmployee) {
		this.coiEmployee = coiEmployee;
	}

	public Timestamp getInvExpDate() {
		return this.invExpDate;
	}

	public void setInvExpDate(Timestamp invExpDate) {
		this.invExpDate = invExpDate;
	}

	public Boolean getInvSingleUse() {
		return this.invSingleUse;
	}

	public void setInvSingleUse(Boolean invSingleUse) {
		this.invSingleUse = invSingleUse;
	}

	public Boolean getInvExpired() {
		return this.invExpired;
	}

	public void setInvExpired(Boolean invExpired) {
		this.invExpired = invExpired;
	}

	public Integer getDisPeriod() {
		return this.disPeriod;
	}

	public void setDisPeriod(Integer disPeriod) {
		this.disPeriod = disPeriod;
	}

	public String getInvUrl() {
		return this.invUrl;
	}

	public void setInvUrl(String invUrl) {
		this.invUrl = invUrl;
	}

}
package edu.bu.ist.coi.db;

/**
 * CoiActiveId entity. @author MyEclipse Persistence Tools
 */

public class CoiActiveId implements java.io.Serializable {

	// Fields

	private CoiEmployee coiEmployee;
	private Integer actYear;

	// Constructors

	/** default constructor */
	public CoiActiveId() {
	}

	/** full constructor */
	public CoiActiveId(CoiEmployee coiEmployee, Integer actYear) {
		this.coiEmployee = coiEmployee;
		this.actYear = actYear;
	}

	// Property accessors

	public CoiEmployee getCoiEmployee() {
		return this.coiEmployee;
	}

	public void setCoiEmployee(CoiEmployee coiEmployee) {
		this.coiEmployee = coiEmployee;
	}

	public Integer getActYear() {
		return this.actYear;
	}

	public void setActYear(Integer actYear) {
		this.actYear = actYear;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CoiActiveId))
			return false;
		CoiActiveId castOther = (CoiActiveId) other;

		return ((this.getCoiEmployee() == castOther.getCoiEmployee()) || (this
				.getCoiEmployee() != null
				&& castOther.getCoiEmployee() != null && this.getCoiEmployee()
				.equals(castOther.getCoiEmployee())))
				&& ((this.getActYear() == castOther.getActYear()) || (this
						.getActYear() != null
						&& castOther.getActYear() != null && this.getActYear()
						.equals(castOther.getActYear())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCoiEmployee() == null ? 0 : this.getCoiEmployee()
						.hashCode());
		result = 37 * result
				+ (getActYear() == null ? 0 : this.getActYear().hashCode());
		return result;
	}

}
package edu.bu.ist.coi.db;

/**
 * _EmployeeListAdditionsId entity provides the base persistence definition of
 * the _EmployeeListAdditionsId entity.
 * 
 * @author stetelba
 */

public class _EmployeeListAdditionsId implements java.io.Serializable {

	// Fields

	private String empLname;
	private String empFname;
	private String empMinitial;
	private String empCostcenternum;
	private String empDept;
	private String empTitle;
	private String empAddress;
	private String empMailcode;
	private String empAlias;
	private String empUid;
	private Boolean empActive;

	// Constructors

	/** default constructor */
	public _EmployeeListAdditionsId() {
	}

	/** minimal constructor */
	public _EmployeeListAdditionsId(String empUid) {
		this.empUid = empUid;
	}

	/** full constructor */
	public _EmployeeListAdditionsId(String empLname, String empFname, String empMinitial, String empCostcenternum,
			String empDept, String empTitle, String empAddress, String empMailcode, String empAlias, String empUid) {
		this.empLname = empLname;
		this.empFname = empFname;
		this.empMinitial = empMinitial;
		this.empCostcenternum = empCostcenternum;
		this.empDept = empDept;
		this.empTitle = empTitle;
		this.empAddress = empAddress;
		this.empMailcode = empMailcode;
		this.empAlias = empAlias;
		this.empUid = empUid;
	}
	/** array constructor */
	public _EmployeeListAdditionsId(String[] args) {
		this.empLname = args[0];
		this.empFname = args[1];
        this.empMinitial = args[2];
        this.empCostcenternum = args[3];
        this.empDept = args[4];
        this.empTitle = args[5];
        this.empAddress = args[6];
        this.empMailcode = args[7];
        this.empAlias = args[8];
        this.empUid = args[9];
		if (this.empUid.startsWith("U")) 	{ this.empUid = "0"+this.empUid; }
  	}
	
	/** constructor from CoiEmployee */
	public _EmployeeListAdditionsId(CoiEmployee cEmp) {
		this.empLname = cEmp.getEmpLname();
		this.empFname = cEmp.getEmpFname();
		this.empMinitial = cEmp.getEmpMinitial();
		this.empCostcenternum = cEmp.getEmpF8();
		this.empDept = cEmp.getEmpDept();
		this.empTitle = cEmp.getEmpTitle();
		this.empAddress = cEmp.getEmpAddress();
		this.empMailcode = cEmp.getEmpMailCode();
		this.empAlias = cEmp.getEmpAlias();
		this.empUid = cEmp.getEmpUid();
		
		this.empActive = cEmp.getEmpActive();
	}

	/** array de-constructor */
	public String[] _EmpToStringArray() {
		String[] args = new String[] {
			this.empLname,
			this.empFname,
			this.empMinitial,
			this.empCostcenternum,
			this.empDept,
	        this.empTitle,
	        this.empAddress,
	        this.empMailcode,
	        this.empAlias,
	        this.empUid,
	        ""+this.empActive
		};
		return args;
  	}
	
	/** public void mergeInCoiEmp */
	public void mergeInCoiEmp(CoiEmployee cEmp) {
		cEmp.setEmpLname(this.empLname);
		cEmp.setEmpFname(this.empFname);
		cEmp.setEmpMinitial(this.empMinitial);
		cEmp.setEmpF8(this.empCostcenternum);
		cEmp.setEmpDept(this.empDept);
		cEmp.setEmpTitle(this.empTitle);
		cEmp.setEmpAddress(this.empAddress);
		cEmp.setEmpMailCode(this.empMailcode.substring(0,5));  // first 5 chars
		
		String fixedAlias = this.empAlias.toLowerCase();
		if (fixedAlias.indexOf("@") < 0)	{	fixedAlias += "@bu.edu"; }
		cEmp.setEmpAlias(fixedAlias);

		String fixedUid = this.empUid;
		if (fixedUid.startsWith("U")) 		{	fixedUid = "0"+fixedUid; }
		cEmp.setEmpUid(fixedUid);
		
		cEmp.setEmpActive(true);
	}

	// Property accessors

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

	public String getEmpCostcenternum() {
		return this.empCostcenternum;
	}

	public void setEmpCostcenternum(String empCostcenternum) {
		this.empCostcenternum = empCostcenternum;
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

	public String getEmpMailcode() {
		return this.empMailcode;
	}

	public void setEmpMailcode(String empMailcode) {
		this.empMailcode = empMailcode;
	}

	public String getEmpAlias() {
		return this.empAlias;
	}

	public void setEmpAlias(String empAlias) {
		this.empAlias = empAlias;
	}

	public String getEmpUid() {
		return this.empUid;
	}

	public void setEmpUid(String empUid) {
		this.empUid = empUid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof _EmployeeListAdditionsId))
			return false;
		_EmployeeListAdditionsId castOther = (_EmployeeListAdditionsId) other;

		return ((this.getEmpLname() == castOther.getEmpLname()) || (this.getEmpLname() != null
				&& castOther.getEmpLname() != null && this.getEmpLname().equals(castOther.getEmpLname())))
				&& ((this.getEmpFname() == castOther.getEmpFname()) || (this.getEmpFname() != null
						&& castOther.getEmpFname() != null && this.getEmpFname().equals(castOther.getEmpFname())))
				&& ((this.getEmpMinitial() == castOther.getEmpMinitial()) || (this.getEmpMinitial() != null
						&& castOther.getEmpMinitial() != null && this.getEmpMinitial().equals(
						castOther.getEmpMinitial())))
				&& ((this.getEmpCostcenternum() == castOther.getEmpCostcenternum()) || (this.getEmpCostcenternum() != null
						&& castOther.getEmpCostcenternum() != null && this.getEmpCostcenternum().equals(
						castOther.getEmpCostcenternum())))
				&& ((this.getEmpDept() == castOther.getEmpDept()) || (this.getEmpDept() != null
						&& castOther.getEmpDept() != null && this.getEmpDept().equals(castOther.getEmpDept())))
				&& ((this.getEmpTitle() == castOther.getEmpTitle()) || (this.getEmpTitle() != null
						&& castOther.getEmpTitle() != null && this.getEmpTitle().equals(castOther.getEmpTitle())))
				&& ((this.getEmpAddress() == castOther.getEmpAddress()) || (this.getEmpAddress() != null
						&& castOther.getEmpAddress() != null && this.getEmpAddress().equals(castOther.getEmpAddress())))
				&& ((this.getEmpMailcode() == castOther.getEmpMailcode()) || (this.getEmpMailcode() != null
						&& castOther.getEmpMailcode() != null && this.getEmpMailcode().equals(
						castOther.getEmpMailcode())))
				&& ((this.getEmpAlias() == castOther.getEmpAlias()) || (this.getEmpAlias() != null
						&& castOther.getEmpAlias() != null && this.getEmpAlias().equals(castOther.getEmpAlias())))
				&& ((this.getEmpUid() == castOther.getEmpUid()) || (this.getEmpUid() != null
						&& castOther.getEmpUid() != null && this.getEmpUid().equals(castOther.getEmpUid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEmpLname() == null ? 0 : this.getEmpLname().hashCode());
		result = 37 * result + (getEmpFname() == null ? 0 : this.getEmpFname().hashCode());
		result = 37 * result + (getEmpMinitial() == null ? 0 : this.getEmpMinitial().hashCode());
		result = 37 * result + (getEmpCostcenternum() == null ? 0 : this.getEmpCostcenternum().hashCode());
		result = 37 * result + (getEmpDept() == null ? 0 : this.getEmpDept().hashCode());
		result = 37 * result + (getEmpTitle() == null ? 0 : this.getEmpTitle().hashCode());
		result = 37 * result + (getEmpAddress() == null ? 0 : this.getEmpAddress().hashCode());
		result = 37 * result + (getEmpMailcode() == null ? 0 : this.getEmpMailcode().hashCode());
		result = 37 * result + (getEmpAlias() == null ? 0 : this.getEmpAlias().hashCode());
		result = 37 * result + (getEmpUid() == null ? 0 : this.getEmpUid().hashCode());
		return result;
	}

}

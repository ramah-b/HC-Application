package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HC_EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="HC_EMPLOYEES")
@NamedQuery(name="HcEmployee.findAll", query="SELECT h FROM HcEmployee h")
public class HcEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_EMPLOYEES_EMPLOYEEID_GENERATOR", sequenceName="HC_EMPLOYEES_SEQ1")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_EMPLOYEES_EMPLOYEEID_GENERATOR")
	@Column(name="EMPLOYEE_ID")
	private String employeeId;

	private String name;

	@Column(name="OFFICE_NUMBER")
	private String officeNumber;

	//bi-directional many-to-one association to HcDepartment
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private HcDepartment hcDepartment;

	//bi-directional one-to-one association to HcPerson
	@OneToOne
	@JoinColumn(name="PERSON_ID")
	private HcPerson hcPerson;

	public HcEmployee() {
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficeNumber() {
		return this.officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public HcDepartment getHcDepartment() {
		return this.hcDepartment;
	}

	public void setHcDepartment(HcDepartment hcDepartment) {
		this.hcDepartment = hcDepartment;
	}

	public HcPerson getHcPerson() {
		return this.hcPerson;
	}

	public void setHcPerson(HcPerson hcPerson) {
		this.hcPerson = hcPerson;
	}

}
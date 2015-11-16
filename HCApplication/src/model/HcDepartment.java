package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HC_DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="HC_DEPARTMENTS", schema = "TESTUSERDB")
@NamedQuery(name="HcDepartment.findAll", query="SELECT h FROM HcDepartment h")
public class HcDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_DEPARTMENTS_DEPARTMENTID_GENERATOR", sequenceName="DEPARTMENTS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_DEPARTMENTS_DEPARTMENTID_GENERATOR")
	@Column(name="DEPARTMENT_ID")
	private String departmentId;

	@Column(name="EXISTS_FLAG")
	private String existsFlag;

	private String name;

	//bi-directional many-to-one association to HcCours
	@OneToMany(mappedBy="hcDepartment")
	private List<HcCours> hcCourses;

	//bi-directional many-to-one association to HcEmployee
	@OneToMany(mappedBy="hcDepartment")
	private List<HcEmployee> hcEmployees;

	//bi-directional many-to-one association to HcMajor
	@OneToMany(mappedBy="hcDepartment")
	private List<HcMajor> hcMajors;

	public HcDepartment() {
	}

	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getExistsFlag() {
		return this.existsFlag;
	}

	public void setExistsFlag(String existsFlag) {
		this.existsFlag = existsFlag;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HcCours> getHcCourses() {
		return this.hcCourses;
	}

	public void setHcCourses(List<HcCours> hcCourses) {
		this.hcCourses = hcCourses;
	}

	public HcCours addHcCours(HcCours hcCours) {
		getHcCourses().add(hcCours);
		hcCours.setHcDepartment(this);

		return hcCours;
	}

	public HcCours removeHcCours(HcCours hcCours) {
		getHcCourses().remove(hcCours);
		hcCours.setHcDepartment(null);

		return hcCours;
	}

	public List<HcEmployee> getHcEmployees() {
		return this.hcEmployees;
	}

	public void setHcEmployees(List<HcEmployee> hcEmployees) {
		this.hcEmployees = hcEmployees;
	}

	public HcEmployee addHcEmployee(HcEmployee hcEmployee) {
		getHcEmployees().add(hcEmployee);
		hcEmployee.setHcDepartment(this);

		return hcEmployee;
	}

	public HcEmployee removeHcEmployee(HcEmployee hcEmployee) {
		getHcEmployees().remove(hcEmployee);
		hcEmployee.setHcDepartment(null);

		return hcEmployee;
	}

	public List<HcMajor> getHcMajors() {
		return this.hcMajors;
	}

	public void setHcMajors(List<HcMajor> hcMajors) {
		this.hcMajors = hcMajors;
	}

	public HcMajor addHcMajor(HcMajor hcMajor) {
		getHcMajors().add(hcMajor);
		hcMajor.setHcDepartment(this);

		return hcMajor;
	}

	public HcMajor removeHcMajor(HcMajor hcMajor) {
		getHcMajors().remove(hcMajor);
		hcMajor.setHcDepartment(null);

		return hcMajor;
	}

}
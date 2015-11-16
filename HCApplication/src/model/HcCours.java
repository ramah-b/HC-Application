package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HC_COURSES database table.
 * 
 */
@Entity
@Table(name="HC_COURSES")
@NamedQuery(name="HcCours.findAll", query="SELECT h FROM HcCours h")
public class HcCours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COURSE_NUMBER")
	private String courseNumber;

	private BigDecimal credits;

	private String description;

	@Column(name="EXISTS_FLAG")
	private String existsFlag;

	private String name;

	private String subjectcode;

	//bi-directional many-to-one association to HcClass
	@OneToMany(mappedBy="hcCours")
	private List<HcClass> hcClasses;

	//bi-directional many-to-one association to HcDepartment
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private HcDepartment hcDepartment;

	public HcCours() {
	}

	public String getCourseNumber() {
		return this.courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getSubjectcode() {
		return this.subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public List<HcClass> getHcClasses() {
		return this.hcClasses;
	}

	public void setHcClasses(List<HcClass> hcClasses) {
		this.hcClasses = hcClasses;
	}

	public HcClass addHcClass(HcClass hcClass) {
		getHcClasses().add(hcClass);
		hcClass.setHcCours(this);

		return hcClass;
	}

	public HcClass removeHcClass(HcClass hcClass) {
		getHcClasses().remove(hcClass);
		hcClass.setHcCours(null);

		return hcClass;
	}

	public HcDepartment getHcDepartment() {
		return this.hcDepartment;
	}

	public void setHcDepartment(HcDepartment hcDepartment) {
		this.hcDepartment = hcDepartment;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HC_GRADES database table.
 * 
 */
@Entity
@Table(name="HC_GRADES", schema = "TESTUSERDB")
@NamedQuery(name="HcGrade.findAll", query="SELECT h FROM HcGrade h")
public class HcGrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GRADE_ID")
	private String gradeId;

	private String grade;

	//bi-directional many-to-one association to HcClass
	@ManyToOne
	@JoinColumn(name="CRN")
	private HcClass hcClass;

	//bi-directional many-to-one association to HcPerson
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private HcPerson hcPerson;

	public HcGrade() {
	}

	public String getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public HcClass getHcClass() {
		return this.hcClass;
	}

	public void setHcClass(HcClass hcClass) {
		this.hcClass = hcClass;
	}

	public HcPerson getHcPerson() {
		return this.hcPerson;
	}

	public void setHcPerson(HcPerson hcPerson) {
		this.hcPerson = hcPerson;
	}

}
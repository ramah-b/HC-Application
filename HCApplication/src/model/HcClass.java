package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HC_CLASSES database table.
 * 
 */
@Entity
@Table(name="HC_CLASSES", schema = "TESTUSERDB")
@NamedQuery(name="HcClass.findAll", query="SELECT h FROM HcClass h")
public class HcClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String crn;

	@Column(name="\"DAY\"")
	private String day;

	@Column(name="EXISTS_FLAG")
	private String existsFlag;

	private String semester;

	@Column(name="\"TIME\"")
	private String time;

	@Column(name="\"YEAR\"")
	private String year;

	//bi-directional many-to-one association to HcClassroom
	@ManyToOne
	@JoinColumn(name="CLASSROOM_NUMBER")
	private HcClassroom hcClassroom;

	//bi-directional many-to-one association to HcCours
	@ManyToOne
	@JoinColumn(name="COURSE_NUMBER")
	private HcCours hcCours;

	//bi-directional many-to-one association to HcPerson
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private HcPerson hcPerson;

	//bi-directional many-to-one association to HcGrade
	@OneToMany(mappedBy="hcClass")
	private List<HcGrade> hcGrades;

	public HcClass() {
	}

	public String getCrn() {
		return this.crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getExistsFlag() {
		return this.existsFlag;
	}

	public void setExistsFlag(String existsFlag) {
		this.existsFlag = existsFlag;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public HcClassroom getHcClassroom() {
		return this.hcClassroom;
	}

	public void setHcClassroom(HcClassroom hcClassroom) {
		this.hcClassroom = hcClassroom;
	}

	public HcCours getHcCours() {
		return this.hcCours;
	}

	public void setHcCours(HcCours hcCours) {
		this.hcCours = hcCours;
	}

	public HcPerson getHcPerson() {
		return this.hcPerson;
	}

	public void setHcPerson(HcPerson hcPerson) {
		this.hcPerson = hcPerson;
	}

	public List<HcGrade> getHcGrades() {
		return this.hcGrades;
	}

	public void setHcGrades(List<HcGrade> hcGrades) {
		this.hcGrades = hcGrades;
	}

	public HcGrade addHcGrade(HcGrade hcGrade) {
		getHcGrades().add(hcGrade);
		hcGrade.setHcClass(this);

		return hcGrade;
	}

	public HcGrade removeHcGrade(HcGrade hcGrade) {
		getHcGrades().remove(hcGrade);
		hcGrade.setHcClass(null);

		return hcGrade;
	}

}
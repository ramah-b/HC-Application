package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HC_PERSONS database table.
 * 
 */
@Entity
@Table(name="HC_PERSONS")
@NamedQuery(name="HcPerson.findAll", query="SELECT h FROM HcPerson h")
public class HcPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_PERSONS_PERSONID_GENERATOR", sequenceName="PERSONS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_PERSONS_PERSONID_GENERATOR")
	@Column(name="PERSON_ID")
	private String personId;

	private String email;

	private String password;

	private String username;

	//bi-directional many-to-one association to HcClass
	@OneToMany(mappedBy="hcPerson")
	private List<HcClass> hcClasses;

	//bi-directional one-to-one association to HcEmployee
	@OneToOne(mappedBy="hcPerson")
	private HcEmployee hcEmployee;

	//bi-directional many-to-one association to HcGrade
	@OneToMany(mappedBy="hcPerson")
	private List<HcGrade> hcGrades;

	//bi-directional many-to-one association to HcRole
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private HcRole hcRole;

	//bi-directional one-to-one association to HcStudent
	@OneToOne(mappedBy="hcPerson")
	private HcStudent hcStudent;

	public HcPerson() {
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<HcClass> getHcClasses() {
		return this.hcClasses;
	}

	public void setHcClasses(List<HcClass> hcClasses) {
		this.hcClasses = hcClasses;
	}

	public HcClass addHcClass(HcClass hcClass) {
		getHcClasses().add(hcClass);
		hcClass.setHcPerson(this);

		return hcClass;
	}

	public HcClass removeHcClass(HcClass hcClass) {
		getHcClasses().remove(hcClass);
		hcClass.setHcPerson(null);

		return hcClass;
	}

	public HcEmployee getHcEmployee() {
		return this.hcEmployee;
	}

	public void setHcEmployee(HcEmployee hcEmployee) {
		this.hcEmployee = hcEmployee;
	}

	public List<HcGrade> getHcGrades() {
		return this.hcGrades;
	}

	public void setHcGrades(List<HcGrade> hcGrades) {
		this.hcGrades = hcGrades;
	}

	public HcGrade addHcGrade(HcGrade hcGrade) {
		getHcGrades().add(hcGrade);
		hcGrade.setHcPerson(this);

		return hcGrade;
	}

	public HcGrade removeHcGrade(HcGrade hcGrade) {
		getHcGrades().remove(hcGrade);
		hcGrade.setHcPerson(null);

		return hcGrade;
	}

	public HcRole getHcRole() {
		return this.hcRole;
	}

	public void setHcRole(HcRole hcRole) {
		this.hcRole = hcRole;
	}

	public HcStudent getHcStudent() {
		return this.hcStudent;
	}

	public void setHcStudent(HcStudent hcStudent) {
		this.hcStudent = hcStudent;
	}

}
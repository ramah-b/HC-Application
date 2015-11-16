package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HC_STUDENTS database table.
 * 
 */
@Entity
@Table(name="HC_STUDENTS", schema = "TESTUSERDB")
@NamedQuery(name="HcStudent.findAll", query="SELECT h FROM HcStudent h")
public class HcStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_ID")
	private String personId;

	private String major;

	private String name;

	@Column(name="YEAR_OF_ENTRY")
	private String yearOfEntry;

	//bi-directional one-to-one association to HcPerson
	@OneToOne
	@JoinColumn(name="PERSON_ID")
	private HcPerson hcPerson;

	public HcStudent() {
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYearOfEntry() {
		return this.yearOfEntry;
	}

	public void setYearOfEntry(String yearOfEntry) {
		this.yearOfEntry = yearOfEntry;
	}

	public HcPerson getHcPerson() {
		return this.hcPerson;
	}

	public void setHcPerson(HcPerson hcPerson) {
		this.hcPerson = hcPerson;
	}

}
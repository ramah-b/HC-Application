package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HC_MAJORS database table.
 * 
 */
@Entity
@Table(name="HC_MAJORS", schema = "TESTUSERDB")
@NamedQuery(name="HcMajor.findAll", query="SELECT h FROM HcMajor h")
public class HcMajor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_MAJORS_MAJORID_GENERATOR", sequenceName="MAJORS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_MAJORS_MAJORID_GENERATOR")
	@Column(name="MAJOR_ID")
	private String majorId;

	@Column(name="EXISTS_FLAG")
	private String existsFlag;

	private String name;

	//bi-directional many-to-one association to HcDepartment
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private HcDepartment hcDepartment;

	public HcMajor() {
	}

	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
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

	public HcDepartment getHcDepartment() {
		return this.hcDepartment;
	}

	public void setHcDepartment(HcDepartment hcDepartment) {
		this.hcDepartment = hcDepartment;
	}

}
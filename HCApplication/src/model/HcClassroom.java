package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HC_CLASSROOMS database table.
 * 
 */
@Entity
@Table(name="HC_CLASSROOMS")
@NamedQuery(name="HcClassroom.findAll", query="SELECT h FROM HcClassroom h")
public class HcClassroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLASSROOM_NUMBER")
	private String classroomNumber;

	@Column(name="BUILDING_NAME")
	private String buildingName;

	@Column(name="EXISTS_FLAG")
	private String existsFlag;

	@Column(name="MAX_CAPACITY")
	private BigDecimal maxCapacity;

	//bi-directional many-to-one association to HcClass
	@OneToMany(mappedBy="hcClassroom")
	private List<HcClass> hcClasses;

	public HcClassroom() {
	}

	public String getClassroomNumber() {
		return this.classroomNumber;
	}

	public void setClassroomNumber(String classroomNumber) {
		this.classroomNumber = classroomNumber;
	}

	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getExistsFlag() {
		return this.existsFlag;
	}

	public void setExistsFlag(String existsFlag) {
		this.existsFlag = existsFlag;
	}

	public BigDecimal getMaxCapacity() {
		return this.maxCapacity;
	}

	public void setMaxCapacity(BigDecimal maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public List<HcClass> getHcClasses() {
		return this.hcClasses;
	}

	public void setHcClasses(List<HcClass> hcClasses) {
		this.hcClasses = hcClasses;
	}

	public HcClass addHcClass(HcClass hcClass) {
		getHcClasses().add(hcClass);
		hcClass.setHcClassroom(this);

		return hcClass;
	}

	public HcClass removeHcClass(HcClass hcClass) {
		getHcClasses().remove(hcClass);
		hcClass.setHcClassroom(null);

		return hcClass;
	}

}
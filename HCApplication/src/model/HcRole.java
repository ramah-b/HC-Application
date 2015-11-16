package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HC_ROLES database table.
 * 
 */
@Entity
@Table(name="HC_ROLES")
@NamedQuery(name="HcRole.findAll", query="SELECT h FROM HcRole h")
public class HcRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_ROLES_ROLEID_GENERATOR", sequenceName="ROLES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_ROLES_ROLEID_GENERATOR")
	@Column(name="ROLE_ID")
	private String roleId;

	private String description;

	//bi-directional many-to-one association to HcPerson
	@OneToMany(mappedBy="hcRole")
	private List<HcPerson> hcPersons;

	public HcRole() {
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<HcPerson> getHcPersons() {
		return this.hcPersons;
	}

	public void setHcPersons(List<HcPerson> hcPersons) {
		this.hcPersons = hcPersons;
	}

	public HcPerson addHcPerson(HcPerson hcPerson) {
		getHcPersons().add(hcPerson);
		hcPerson.setHcRole(this);

		return hcPerson;
	}

	public HcPerson removeHcPerson(HcPerson hcPerson) {
		getHcPersons().remove(hcPerson);
		hcPerson.setHcRole(null);

		return hcPerson;
	}

}
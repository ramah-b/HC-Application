package customPackage;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcEmployee;
import customTools.DBUtil;

public class HcEmployeesDB {
	public static HcEmployee selectAnEmployee(String person_id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcEmployee h where h.hcPerson.personId = :person_id";
		TypedQuery<HcEmployee> q = em.createQuery(qString, HcEmployee.class);
		q.setParameter("person_id", person_id);
		HcEmployee employee = null;
		try {
			employee = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return employee;
	}
	
	

}

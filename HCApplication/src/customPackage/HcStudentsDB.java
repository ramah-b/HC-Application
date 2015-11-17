package customPackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcPerson;
import model.HcStudent;
import customTools.DBUtil;

public class HcStudentsDB {
	
	public static void insert(HcStudent student) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(student);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	
	public static HcStudent selectStudetnByPersonId(String person_id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcStudent h where h.hcPerson.personId = :person_id";
		TypedQuery<HcStudent> q = em.createQuery(qString, HcStudent.class);
		q.setParameter("person_id", person_id);
		HcStudent student = null;
		try {
			student = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return student;
	}

}

package customPackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcEmployee;
import model.HcPerson;
import model.HcStudent;
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
	
	public static void insert(HcEmployee emp) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(emp);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(HcEmployee emp) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(emp));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	

}

package customPackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcGrade;
import model.HcPerson;
import customTools.DBUtil;

public class HcGradesDB {
	public static List<HcGrade> getEnrolledClasses(String person_id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcGrade h where h.hcPerson.personId = :person_id";
		TypedQuery<HcGrade> q = em.createQuery(qString, HcGrade.class);
		q.setParameter("person_id", person_id);
		List<HcGrade> enrolledClasses = null;
		try {
			enrolledClasses = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return enrolledClasses;
	}

	public static List<HcGrade> getEnrolledClassesSorted(String person_id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcGrade h where h.hcPerson.personId = :person_id order by h.hcClass.year";
		TypedQuery<HcGrade> q = em.createQuery(qString, HcGrade.class);
		q.setParameter("person_id", person_id);
		List<HcGrade> enrolledClasses = null;
		try {
			enrolledClasses = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return enrolledClasses;
	}

	public static HcGrade selectEnrolledClass(String crn, String personId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcGrade h where h.hcClass.crn = :crn and h.hcPerson.personId = :personId";
		TypedQuery<HcGrade> q = em.createQuery(qString, HcGrade.class);
		q.setParameter("crn", crn);
		q.setParameter("personId", personId);
		HcGrade enrolledClass = null;
		try {
			enrolledClass = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return enrolledClass;
	}

	public static void insert(HcGrade grade) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(grade);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HcGrade grade) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(grade);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void delete(HcGrade grade) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(grade));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}

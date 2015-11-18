package customPackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcMajor;
import customTools.DBUtil;

public class HcMajorsDB {
	
	
	public static void insert(HcMajor major) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(major);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HcMajor major) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(major);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<HcMajor> getAllMajors() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcMajor h";
		TypedQuery<HcMajor> q = em.createQuery(qString, HcMajor.class);
		List<HcMajor> major_list = null;
		try {
			major_list = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return major_list;
	}
	
	public static HcMajor getMajorByMajorID(String major_id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcMajor h where h.majorId= :major_id";
		TypedQuery<HcMajor> q = em.createQuery(qString, HcMajor.class);
		q.setParameter("major_id", major_id);
		HcMajor major = null;
		try {
			major = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return major;
	}
	public static boolean majorExists(String major_id){
		HcMajor major = getMajorByMajorID(major_id);
		return major != null;
	}

}

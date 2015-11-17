package customPackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcCours;
import customTools.DBUtil;

public class HcCoursesDB {
	public static List<HcCours> getAllCourses() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcCours h where h.existsFlag = '1'";
		TypedQuery<HcCours> q = em.createQuery(qString, HcCours.class);
		List<HcCours> courses = null;
		try {
			courses = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return courses;
	}
	
	public static List<HcCours> getAllCoursesByDepartmentName(String deparment_name) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcCours h where h.hcDepartment.name = :name";
		TypedQuery<HcCours> q = em.createQuery(qString, HcCours.class);
		q.setParameter("name", deparment_name);
		List<HcCours> courses = null;
		try {
			courses = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return courses;
	}

}

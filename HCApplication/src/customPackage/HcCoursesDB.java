package customPackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcCours;
import customTools.DBUtil;

public class HcCoursesDB {
	
	public static void insert(HcCours course) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(course);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HcCours course) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(course);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
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
	
	public static List<HcCours> getAllCoursesWithFlags() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcCours h";
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
	
	public static HcCours selectCourseByCourseNumebrSubjectCode(String course_number, String subject_code){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		subject_code = subject_code.toUpperCase();
		String qString = "SELECT h FROM HcCours h where h.courseNumber = :course_number and h.subjectcode= :subject_code";
		TypedQuery<HcCours> q = em.createQuery(qString, HcCours.class);
		q.setParameter("course_number", course_number);
		q.setParameter("subject_code", subject_code);
		HcCours course = null;
		try {
			course = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return course;
	}
	
	public static boolean courseExists(String course_number, String subject_code){
		HcCours course = selectCourseByCourseNumebrSubjectCode(course_number,subject_code);
		return course != null;
	}

}

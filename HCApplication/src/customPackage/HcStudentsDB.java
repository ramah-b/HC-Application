package customPackage;

import java.util.List;

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
	public static HcStudent selectStudetnByStudentId(String student_id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcStudent h where h.studentId = :student_id";
		TypedQuery<HcStudent> q = em.createQuery(qString, HcStudent.class);
		q.setParameter("student_id", student_id);
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
	public static List<HcStudent> selectAllStudetns() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcStudent h";
		TypedQuery<HcStudent> q = em.createQuery(qString, HcStudent.class);
		List<HcStudent> student_list = null;
		try {
			student_list = q.getResultList();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return student_list;
	}
	public static void delete(HcStudent student) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(student));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

}

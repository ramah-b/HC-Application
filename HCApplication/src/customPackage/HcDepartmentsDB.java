package customPackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;





import model.HcCours;
import model.HcDepartment;
import customTools.DBUtil;

public class HcDepartmentsDB {
	
	public static void insert(HcDepartment dept) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(dept);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(HcDepartment dept) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(dept);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<HcDepartment> getAllDepartments() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcDepartment h";
		TypedQuery<HcDepartment> q = em.createQuery(qString, HcDepartment.class);
		List<HcDepartment> department_list = null;
		try {
			department_list = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return department_list;
	}
	
	public static HcDepartment getDepartmentByDepartmentID(String department_id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcDepartment h where h.departmentId= :department_id";
		TypedQuery<HcDepartment> q = em.createQuery(qString, HcDepartment.class);
		q.setParameter("department_id", department_id);
		HcDepartment department = null;
		try {
			department = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return department;
	}
	public static boolean departmentExists(String department_id){
		HcDepartment dept = getDepartmentByDepartmentID(department_id);
		return dept != null;
	}
}

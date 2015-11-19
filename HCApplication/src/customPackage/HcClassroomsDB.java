package customPackage;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcClassroom;
import model.HcCours;
import customTools.DBUtil;

public class HcClassroomsDB {
	public static void insert(HcClassroom classroom) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(classroom);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void update(HcClassroom classroom) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(classroom);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<HcClassroom> getAllClassrooms() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcClassroom h";
		TypedQuery<HcClassroom> q = em.createQuery(qString, HcClassroom.class);
		List<HcClassroom> classrooms = null;
		try {
			classrooms = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return classrooms;
	}
	
	public static HcClassroom selectAClassroom(String classroom_number, String bldg_name){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		bldg_name = bldg_name.toUpperCase();
		String qString = "SELECT h FROM HcClassroom h where h.classroomNumber = :classroom_number and h.buildingName= :bldg_name";
		TypedQuery<HcClassroom> q = em.createQuery(qString, HcClassroom.class);
		q.setParameter("classroom_number", classroom_number);
		q.setParameter("bldg_name", bldg_name);
		HcClassroom classroom = null;
		try {
			classroom = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return classroom;
	}
	
	public static boolean classroomExists(String classroom_number, String bldg_name){
		HcClassroom classroom = selectAClassroom(classroom_number, bldg_name);
		return classroom != null;
	}

}

package customPackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcClass;
import customTools.DBUtil;

public class HcClassesDB {

	public static List<HcClass> getActiveClasses(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcClass h where h.existsFlag = :exists";
		String exists = "1";
		TypedQuery<HcClass> q = em.createQuery(qString, HcClass.class);
		q.setParameter("exists", exists);
		List<HcClass> classes = null;
		try {
			classes = q.getResultList();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return classes;
	}
	
	
	
	public static HcClass getAClassByCRN(String crn){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcClass h where h.crn = :crn";
		TypedQuery<HcClass> q = em.createQuery(qString, HcClass.class);
		q.setParameter("crn", crn);
		HcClass selected_class = null;
		try {
			selected_class = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return selected_class;
	}
	
	public static List<HcClass> getAClassByPersonID(String person_id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcClass h where h.hcPerson.personId = :person_id";
		TypedQuery<HcClass> q = em.createQuery(qString, HcClass.class);
		q.setParameter("person_id", person_id);
		List<HcClass> selected_classes = null;
		try {
			selected_classes = q.getResultList();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return selected_classes;
	}
	
	public static List<HcClass> getClassesByPersonIDinCurrentSemester(String person_id, String year, String semester){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcClass h where h.hcPerson.personId = :person_id and h.year= :year and h.semester = :semester";
		TypedQuery<HcClass> q = em.createQuery(qString, HcClass.class);
		q.setParameter("person_id", person_id);
		q.setParameter("year", year);
		q.setParameter("semester", semester);
		List<HcClass> class_list = null;
		try {
			class_list = q.getResultList();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return class_list;
	}
}

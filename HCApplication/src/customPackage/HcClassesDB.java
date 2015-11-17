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
}

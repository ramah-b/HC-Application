package customPackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HcPerson;
import customTools.DBUtil;

public class HcPersonsDB {

		public static void insert(HcPerson person) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.persist(person);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void update(HcPerson person) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.merge(person);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void delete(HcPerson person) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.remove(em.merge(person));
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}
		
		public static boolean usernameExists(String username) {
			HcPerson p = selectPersonByUsername(username);
			return p != null;
		}

		public static boolean emailExists(String email) {
			HcPerson p = selectPersonByEmail(email);
			return p != null;
		}

		public static HcPerson selectPersonByUsername(String username) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			username = username.toLowerCase();
			String qString = "SELECT h FROM HcPerson h where h.username = :username";
			TypedQuery<HcPerson> q = em.createQuery(qString, HcPerson.class);
			q.setParameter("username", username);
			HcPerson person = null;
			try {
				person = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return person;
		}
		
		public static HcPerson selectPersonByPersonId(String personId) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			
			String qString = "SELECT h FROM HcPerson h where h.personId = :personId";
			TypedQuery<HcPerson> q = em.createQuery(qString, HcPerson.class);
			q.setParameter("personId", personId);
			HcPerson person = null;
			try {
				person = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return person;
		}
		
		public static HcPerson selectPersonByEmail(String email){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			email = email.toLowerCase();
			String qString = "SELECT h FROM HcPerson h where h.email = :email";
			TypedQuery<HcPerson> q = em.createQuery(qString, HcPerson.class);
			q.setParameter("email", email);
			HcPerson person = null;
			try {
				person = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return person;
		}

		public static HcPerson selectAPerson(String username, String password) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			username = username.toLowerCase();
			String qString = "select h FROM HcPerson h where h.username = :username and h.password= :password";
			TypedQuery<HcPerson> q = em.createQuery(qString, HcPerson.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			HcPerson person = null;
			try {
				person = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return person;
		}



	

}

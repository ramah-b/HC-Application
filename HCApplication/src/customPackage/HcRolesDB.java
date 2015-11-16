package customPackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.HcRole;
import customTools.DBUtil;

public class HcRolesDB {

	public static HcRole selectDefaultRole() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcRole h where h.roleId = :roleId";
		TypedQuery<HcRole> q = em.createQuery(qString, HcRole.class);
		String role_id = "1";
		q.setParameter("roleId", role_id);
		HcRole defaultRole = null;
		try {
			defaultRole = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return defaultRole;
	}


}

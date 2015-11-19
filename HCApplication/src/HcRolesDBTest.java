import static org.junit.Assert.*;

import org.junit.Test;

import model.HcRole;
import customPackage.HcRolesDB;


public class HcRolesDBTest {
	
	 @Test
	   public void test_returnDefault() {
	      System.out.println("Test ifdefaultRole test") ;
	      String roleId ="4" ;
	      HcRole defaultRole = HcRolesDB.selectDefaultRole();
	      HcRole selectedRole = HcRolesDB.selectRoleByRoleID(roleId);
	      assertTrue(defaultRole.getRoleId().equals(selectedRole.getRoleId())) ;
	   }

}

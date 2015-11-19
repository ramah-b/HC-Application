import static org.junit.Assert.*;
import model.HcRole;

import org.junit.Test;

import customPackage.HcRolesDB;


public class selectDefaultRoleTest {

	@Test
	public static void test() {
		String role_id = "4"; //default role should be 4 indicating student
		HcRole defaultRole = HcRolesDB.selectDefaultRole();
		HcRole expectedRole = HcRolesDB.selectRoleByRoleID(role_id);
		System.out.println(defaultRole.getRoleId());
		System.out.println("test");
		assertEquals(Integer.parseInt(defaultRole.getRoleId()), Integer.parseInt(expectedRole.getRoleId()));
	}

}
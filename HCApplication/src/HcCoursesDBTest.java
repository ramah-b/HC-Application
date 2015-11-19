import static org.junit.Assert.assertTrue;
import model.HcCours;


import org.junit.Test;

import customPackage.HcCoursesDB;


public class HcCoursesDBTest {
	 @Test
	   public void test_returnDefault() {
	      System.out.println("Test ifdefaultRole test") ;
	      HcCours course = HcCoursesDB.selectCourseByCourseNumebrSubjectCode("6202", "ISTM");
	   
	     
	      assertTrue(course.getHcDepartment().getDepartmentId().equals("2")) ;
	   }

}

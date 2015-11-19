package adminCustomPackage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HcClass;
import model.HcCours;
import model.HcDepartment;
import model.HcGrade;
import model.HcStudent;
import customPackage.HcClassesDB;
import customPackage.HcCoursesDB;
import customPackage.HcDepartmentsDB;
import customPackage.HcGradesDB;

/**
 * Servlet implementation class courseServlet
 */
@WebServlet("/courseServlet")
public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String updateFlag="";
	private static String createFlag="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		
		if (action.equals("createJSP"))
			processCreateCourseJSP(request, response);
		else if (action.equals("create"))
			processCreateCourse(request, response);
		else if(action.equals("list"))
			processListCoursesJSP(request, response);
		else if(action.equals("updateJSP"))
			processUpdateCourseJSP(request, response);
		else if(action.equals("update"))
			processUpdateCourse(request, response);
		else if(action.equals("disable"))
			processEnableDisable(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processListCoursesJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<HcCours> courses_list = HcCoursesDB.getAllCoursesWithFlags();
		
		if (courses_list == null || courses_list.isEmpty())
			courses_list = null;
		
		request.setAttribute("courses", courses_list);
		if (updateFlag.equals("yes")){
			String message = "Course has been updated.";
			request.setAttribute("message", message);
			updateFlag="no";
		}
		if (createFlag.equals("yes")){
			String message = "Course has been created.";
			request.setAttribute("message", message);
			createFlag="no";
		}
		getServletContext().getRequestDispatcher("/adminViewAllCourses.jsp").forward(request,
				response);
		
		
		}
	
	private void processCreateCourseJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<HcDepartment> department_list = HcDepartmentsDB.getAllDepartments();
		
		if (department_list == null || department_list.isEmpty())
			department_list = null;
		
		request.setAttribute("departments", department_list);
		

		getServletContext().getRequestDispatcher("/adminCreateCourseJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processCreateCourse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String course_number = request.getParameter("course_number");
		String subject_code = request.getParameter("subject_code");
		String name = request.getParameter("name");
		System.out.println(name);
		String description = request.getParameter("description");
		System.out.println(description);
		String credits = request.getParameter("credits");
		String department_id = request.getParameter("department_id");
		HcDepartment dept = HcDepartmentsDB.getDepartmentByDepartmentID(department_id);
		BigDecimal bd = new BigDecimal(Integer.parseInt(credits));
		if (!HcCoursesDB.courseExists(course_number, subject_code)){
			HcCours new_course = new HcCours();
			new_course.setCourseNumber(course_number);
			new_course.setSubjectcode(subject_code.toUpperCase());
			new_course.setCredits(bd);
			new_course.setHcDepartment(dept);
			new_course.setExistsFlag("1");
			//if (name != null)
				new_course.setName(name);
			//if (description != null)
				new_course.setDescription(description);
			
			HcCoursesDB.insert(new_course);
			createFlag="yes";
			processListCoursesJSP(request, response);
				
			
		}else{
			String message="Course Already Exists.";
			request.setAttribute("message", message);
			List<HcDepartment> department_list = HcDepartmentsDB.getAllDepartments();
			
			if (department_list == null || department_list.isEmpty())
				department_list = null;
			
			request.setAttribute("departments", department_list);
			getServletContext().getRequestDispatcher("/adminCreateCourseJSP.jsp").forward(
					request, response);
		}
		
		}
	private void processUpdateCourseJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<HcDepartment> department_list = HcDepartmentsDB.getAllDepartments();
		
		if (department_list == null || department_list.isEmpty())
			department_list = null;
		
		request.setAttribute("departments", department_list);
		
		request.setAttribute("course_number",request.getParameter("course_number"));
		request.setAttribute("subject_code",request.getParameter("subject_code"));
		
		
		

		getServletContext().getRequestDispatcher("/adminUpdateCourseJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processUpdateCourse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String course_number = request.getParameter("course_number");
		String subject_code = request.getParameter("subject_code");
		
		HcCours new_course = new HcCours();
		new_course.setCourseNumber(course_number);
		new_course.setSubjectcode(subject_code.toUpperCase());
		
		String name = request.getParameter("name");
		if (name != null)
			new_course.setName(name);
		String description = request.getParameter("description");
		if (description != null)
			new_course.setDescription(description);
		
		String credits = request.getParameter("credits");
		if (!credits.isEmpty() ){
			BigDecimal bd = new BigDecimal(Integer.parseInt(credits));
			new_course.setCredits(bd);
		}
		String department_id = request.getParameter("department_id");
		HcDepartment dept = new HcDepartment();
		if (department_id != null){
			dept = HcDepartmentsDB.getDepartmentByDepartmentID(department_id);
			new_course.setHcDepartment(dept);
		}
			
			HcCoursesDB.update(new_course);
			updateFlag="yes";
			processListCoursesJSP(request, response);
		}

	private void processEnableDisable(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String course_number = request.getParameter("course_number");
		String subject_code = request.getParameter("subject_code");
		
		
		
		HcCours course = new HcCours();
		course = HcCoursesDB.selectCourseByCourseNumebrSubjectCode(course_number, subject_code);
		System.out.println(course.getExistsFlag());
		if (course.getExistsFlag().equals("1"))
			course.setExistsFlag("0");
		
		else if (course.getExistsFlag().equals("0"))
			course.setExistsFlag("1");
	
			HcCoursesDB.update(course);
			
			processListCoursesJSP(request, response);
		}
}

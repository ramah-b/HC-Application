package adminCustomPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HcClass;
import model.HcEmployee;
import model.HcGrade;
import model.HcStudent;
import customPackage.HcClassesDB;
import customPackage.HcEmployeesDB;
import customPackage.HcGradesDB;
import customPackage.HcStudentsDB;

/**
 * Servlet implementation class adminViewServlet
 */
@WebServlet("/adminViewServlet")
public class adminViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equals("listInstructors"))
			processInstructorsListJSP(request, response);
		else if (action.equals("viewStudents"))
			processInstructorsStudentsList(request, response);
		else if (action.equals("listStudents"))
			processStudentsListJSP(request, response);
		else if (action.equals("viewClasses"))
			processStudentsClassesList(request, response);
		else if (action.equals("listInstructorsClasses"))
			processInstructorsListForClassesJSP(request, response);
		else if (action.equals("viewInstructorClasses"))
			processInstructorsClassesList(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processInstructorsListJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<HcEmployee> instructors = HcEmployeesDB.selectInstructors();
	
		if (instructors == null || instructors.isEmpty())
			instructors = null;
		
		request.setAttribute("instructors", instructors);

		getServletContext().getRequestDispatcher("/instructorListJSP.jsp").forward(request,
				response);
		
		
		}
	private void processInstructorsStudentsList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String person_id = request.getParameter("person_id");
		List<HcClass> class_list = HcClassesDB.getAClassByPersonID(person_id);
	
		if (class_list == null || class_list.isEmpty())
			class_list = null;
		
		request.setAttribute("class_list", class_list);

		getServletContext().getRequestDispatcher("/instructorStudentListJSP.jsp").forward(request,
				response);
		
		
		}
	private void processInstructorsListForClassesJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<HcEmployee> instructors = HcEmployeesDB.selectInstructors();
	
		if (instructors == null || instructors.isEmpty())
			instructors = null;
		
		request.setAttribute("instructors", instructors);

		getServletContext().getRequestDispatcher("/instructorListForClassesJSP.jsp").forward(request,
				response);
		
		
		}
	private void processInstructorsClassesList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String person_id = request.getParameter("person_id");
		List<HcClass> class_list = HcClassesDB.getAClassByPersonID(person_id);
	
		if (class_list == null || class_list.isEmpty())
			class_list = null;
		
		request.setAttribute("class_list", class_list);

		getServletContext().getRequestDispatcher("/adminInstructorClassesJSP.jsp").forward(request,
				response);
		
		
		}
	private void processStudentsListJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<HcStudent> students = HcStudentsDB.selectAllStudetns();
	
		if (students == null || students.isEmpty())
			students = null;
		
		request.setAttribute("students", students);

		getServletContext().getRequestDispatcher("/adminStudenetListJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processStudentsClassesList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String person_id = request.getParameter("person_id");
		List<HcGrade> grade_list = HcGradesDB.getEnrolledClasses(person_id);
	
		if (grade_list == null || grade_list.isEmpty())
			grade_list = null;
		
		request.setAttribute("grade_list", grade_list);

		getServletContext().getRequestDispatcher("/adminStudentClassListJSP.jsp").forward(request,
				response);
		
		
		}
}

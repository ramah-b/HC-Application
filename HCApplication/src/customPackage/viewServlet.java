package customPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HcClass;
import model.HcCours;
import model.HcDepartment;
import model.HcStudent;

/**
 * Servlet implementation class viewServlet
 */
@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		
		if (action.equals("courses"))
			viewCourses(request, response);
		else if (action.equals("departments"))
			viewDepartments(request, response);
		else if (action.equals("dep_courses"))
			viewCoursesInDepartment(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void viewCourses(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HcStudent student = (HcStudent) session.getAttribute("student");
		List<HcCours> courses_list =  HcCoursesDB.getAllCourses();
		ArrayList<HcCours> courses_array = new ArrayList<HcCours>();
		if (courses_list == null || courses_list.isEmpty())
			courses_array = null;
		else{
			int j=0;
			for (int i=0; i<courses_list.size(); i++){
					courses_array.add(j, courses_list.get(i));
			}
			
		}
		request.setAttribute("avail_courses", courses_array);
		getServletContext().getRequestDispatcher("/viewCoursesJSP.jsp").forward(
				request, response);
		
		
	}

	protected void viewDepartments(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HcStudent student = (HcStudent) session.getAttribute("student");
		EntityManager em = customTools.DBUtil.getEmFactory()
				.createEntityManager();
		
		String query = "SELECT h FROM HcDepartment h";
		TypedQuery<HcDepartment> q = em.createQuery(query, HcDepartment.class);

		List<HcDepartment> department_list = q.getResultList();
		if (department_list == null || department_list.isEmpty())
			department_list = null;
		
		request.setAttribute("department", department_list);
		

		getServletContext().getRequestDispatcher("/departmentListJSP.jsp").forward(request,
				response);
		
	}
	
	protected void viewCoursesInDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HcStudent student = (HcStudent) session.getAttribute("student");
		String dep_name = request.getParameter("name");
		List<HcCours> courses_list =  HcCoursesDB.getAllCoursesByDepartmentName(dep_name);
		
		if (courses_list == null || courses_list.isEmpty())
			courses_list = null;
		
		request.setAttribute("dep_courses", courses_list);
		getServletContext().getRequestDispatcher("/depCourse.jsp").forward(
				request, response);
	}
}



import java.io.IOException;
import java.util.Calendar;
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
import customPackage.HcClassesDB;
import customPackage.HcGradesDB;

/**
 * Servlet implementation class studentRelatedServlet
 */
@WebServlet("/studentRelatedServlet")
public class studentRelatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentRelatedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equals("roster"))
			processRoster(request, response);
		else if(action.equals("grade"))
			processAssignGradesJSP(request, response);
		else if (action.equals("assignGrade"))
			processAssignGrades(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processRoster(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HcEmployee instructor = (HcEmployee) session.getAttribute("instructor");
		String person_id = instructor.getHcPerson().getPersonId();
		String semester = request.getParameter("semester");
		String year = request.getParameter("year");
		
		
		
		
		List<HcClass> class_list= HcClassesDB.getClassesByPersonIDinCurrentSemester(person_id, year, semester);
		
		
		if (class_list == null || class_list.isEmpty())
			class_list = null;
		
		request.setAttribute("class_list", class_list);
		request.setAttribute("year", year);
		request.setAttribute("semester", semester);

		getServletContext().getRequestDispatcher("/instructorViewRoster.jsp").forward(request,
				response);
		
		
		}
	
	private void processAssignGradesJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HcEmployee instructor = (HcEmployee) session.getAttribute("instructor");
		String person_id = instructor.getHcPerson().getPersonId();
		
		
		
		
		
		List<HcClass> class_list= HcClassesDB.getAClassByPersonID(person_id);
		
		
		if (class_list == null || class_list.isEmpty())
			class_list = null;
		
		request.setAttribute("class_list", class_list);
		

		getServletContext().getRequestDispatcher("/instructorAssignGradesJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processAssignGrades(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HcEmployee instructor = (HcEmployee) session.getAttribute("instructor");
		String crn = request.getParameter("crn");
		String person_id = request.getParameter("person_id");
		String grade = request.getParameter("grade");
		HcGrade graded_student = HcGradesDB.selectEnrolledClass(crn, person_id);
		graded_student.setGrade(grade);

		HcGradesDB.update(graded_student);

		processAssignGradesJSP(request, response);
		
		
		}


}

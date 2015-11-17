package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customPackage.HcClassesDB;
import customPackage.HcGradesDB;
import customPackage.HcStudentsDB;

/**
 * Servlet implementation class advisorsViewStudentServlet
 */
@WebServlet("/advisorsViewStudentServlet")
public class advisorsViewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public advisorsViewStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		 if (action.equals("enrollJSP"))
			 processEnrollJSP(request, response);
		 else if (action.equals("enroll"))
			 processEnrollStudent(request, response);
		 else if (action.equals("dropJSP"))
			processDropJSP(request, response);
		else if (action.equals("drop"))
			processDropStudent(request, response);
		else if (action.equals("transcript"))
			processUnofficialTranscript(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private void processViewStudentsList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//HcStudent student = (HcStudent) session.getAttribute("student");
		List<HcStudent> student_list = HcStudentsDB.selectAllStudetns();
		if (student_list == null || student_list.isEmpty())
			student_list= null;
		
		request.setAttribute("student_list", student_list);
		getServletContext().getRequestDispatcher("/studentListJSP.jsp").forward(
				request, response);

	}
	
	private void processEnrollJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//HcStudent student = (HcStudent) session.getAttribute("student");
		String student_id = request.getParameter("student_id");
		HcStudent student = HcStudentsDB.selectStudetnByStudentId(student_id);
		List<HcClass> class_list =  HcClassesDB.getActiveClasses();
		ArrayList<HcClass> class_array = new ArrayList<HcClass>();
		if (class_list == null || class_list.isEmpty())
			class_array = null;
		else{
			int j=0;
			for (int i=0; i<class_list.size(); i++){
					if (HcGradesDB.selectEnrolledClass(class_list.get(i).getCrn(), student.getHcPerson().getPersonId()) == null){
						class_array.add(j, class_list.get(i));
						j++;
					}
			}
			
		}
		request.setAttribute("student", student);
		request.setAttribute("student_id", student_id);
		request.setAttribute("avail_class", class_array);
		getServletContext().getRequestDispatcher("/advisorsEnrollClass.jsp").forward(
				request, response);
		
	}

	private void processEnrollStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//HcStudent student = (HcStudent) session.getAttribute("student");
		String student_id = request.getParameter("student_id");
		HcStudent student = HcStudentsDB.selectStudetnByStudentId(student_id);
		String selected_crn = request.getParameter("crn");
		HcClass selected_class = HcClassesDB.getAClassByCRN(selected_crn);
		
		HcGrade grade = new HcGrade();
		grade.setHcPerson(student.getHcPerson());
		grade.setHcClass(selected_class);
		HcGradesDB.insert(grade);
		processEnrollJSP(request, response);
		
		}
	
	private void processDropJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//HcStudent student = (HcStudent) session.getAttribute("student");
		String student_id = request.getParameter("student_id");
		HcStudent student = HcStudentsDB.selectStudetnByStudentId(student_id);
		List<HcGrade> grade_list = HcGradesDB.getEnrolledClasses(student_id);
		ArrayList<HcGrade> grade_array = new ArrayList<HcGrade>();
		if (grade_list == null || grade_list.isEmpty())
			grade_array = null;
		else {
			for (int i = 0; i < grade_list.size(); i++) {

				grade_array.add(i, grade_list.get(i));

			}

		}
		request.setAttribute("avail_grade", grade_array);
		request.setAttribute("student_id", student_id);
		request.setAttribute("student", student);
		getServletContext().getRequestDispatcher("/advisorsDropClass.jsp").forward(
				request, response);

	}
	
	private void processDropStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//HcStudent student = (HcStudent) session.getAttribute("student");
		String student_id = request.getParameter("student_id");
		String selected_crn = request.getParameter("crn");
		HcGrade selected_class = HcGradesDB.selectEnrolledClass(selected_crn,student_id);

		HcGradesDB.delete(selected_class);
		processDropJSP(request, response);

	}
	
	private void processUnofficialTranscript(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//HcStudent student = (HcStudent) session.getAttribute("student");
		String student_id = request.getParameter("student_id");
		HcStudent student = HcStudentsDB.selectStudetnByStudentId(student_id);
		List<HcGrade> selected_class = HcGradesDB
				.getEnrolledClassesSorted(student.getHcPerson().getPersonId());

		ArrayList<HcGrade> filtered_array = new ArrayList<HcGrade>();

		if (selected_class == null || selected_class.isEmpty())
			filtered_array = null;
		else {
			for (int i = 0; i < selected_class.size(); i++) {
				filtered_array.add(i, selected_class.get(i));
			}

		}
		request.setAttribute("transcript", filtered_array);
		request.setAttribute("student", student);
		getServletContext().getRequestDispatcher("/advisorsUnofficialTranscript.jsp")
				.forward(request, response);

	}
	
	
}

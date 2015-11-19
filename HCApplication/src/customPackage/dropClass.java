package customPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HcClass;
import model.HcGrade;
import model.HcStudent;

/**
 * Servlet implementation class dropClass
 */
@WebServlet("/dropClass")
public class dropClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dropClass() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("dropJSP"))
			processDropJSP(request, response);
		else if (action.equals("drop"))
			processDrop(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void processDropJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HcStudent student = (HcStudent) session.getAttribute("student");
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = (c.get(Calendar.MONTH))+1;
		
		String currSemester = "";
		
		if (month >= 1 && month <= 5){
			currSemester = "Spring";
		}
		else if (month >= 8 && month <= 12){
			currSemester = "Fall";
		}
		
		
		
		List<HcGrade> grade_list = HcGradesDB.getCurrentEnrolledClasses(student
				.getHcPerson().getPersonId(), Integer.toString(year), currSemester);
		ArrayList<HcGrade> grade_array = new ArrayList<HcGrade>();
		if (grade_list == null || grade_list.isEmpty())
			grade_array = null;
		else {
			for (int i = 0; i < grade_list.size(); i++) {

				grade_array.add(i, grade_list.get(i));

			}

		}
		request.setAttribute("avail_grade", grade_array);
		getServletContext().getRequestDispatcher("/dropClassForm.jsp").forward(
				request, response);

	}

	private void processDrop(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HcStudent student = (HcStudent) session.getAttribute("student");
		String selected_crn = request.getParameter("crn");
		HcGrade selected_class = HcGradesDB.selectEnrolledClass(selected_crn,
				student.getHcPerson().getPersonId());

		HcGradesDB.delete(selected_class);
		processDropJSP(request, response);

	}

}

package customPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HcGrade;
import model.HcStudent;

/**
 * Servlet implementation class transcriptServlet
 */
@WebServlet("/transcriptServlet")
public class transcriptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public transcriptServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("unofficial"))
			processUnofficialTranscript(request, response);
		else if (action.equals("official"))
			processOfficialTranscript(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void processUnofficialTranscript(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HcStudent student = (HcStudent) session.getAttribute("student");

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
		getServletContext().getRequestDispatcher("/unofficialTranscript.jsp")
				.forward(request, response);

	}

	private void processOfficialTranscript(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HcStudent student = (HcStudent) session.getAttribute("student");

		getServletContext().getRequestDispatcher("/officialTranscript.jsp")
				.forward(request, response);

	}
}



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
import model.HcClassroom;
import model.HcEmployee;
import customPackage.HcClassesDB;
import customPackage.HcClassroomsDB;

/**
 * Servlet implementation class viewClassesServlet
 */
@WebServlet("/viewClassesServlet")
public class viewClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewClassesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equals("currentClasses"))
			processInstructorClasses(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void processInstructorClasses(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HcEmployee instructor = (HcEmployee) session.getAttribute("instructor");
		String person_id = instructor.getHcPerson().getPersonId();
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = (c.get(Calendar.MONTH))+1;
		
		String yearStr = Integer.toString(year);
		String currSemester = "";
		
		if (month >= 1 && month <= 5){
			currSemester = "Spring";
		}
		else if (month >= 8 && month <= 12){
			currSemester = "Fall";
		}
		
		List<HcClass> class_list= HcClassesDB.getClassesByPersonIDinCurrentSemester(person_id, yearStr, currSemester);
		
		
		if (class_list == null || class_list.isEmpty())
			class_list = null;
		
		request.setAttribute("class_list", class_list);
		request.setAttribute("year", yearStr);
		request.setAttribute("semester", currSemester);

		getServletContext().getRequestDispatcher("/instructorViewCurrentClasses.jsp").forward(request,
				response);
		
		
		}
	
}

package customPackage;

import java.io.IOException;
import java.math.BigDecimal;
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
import model.HcClassroom;
import model.HcGrade;
import model.HcStudent;

/**
 * Servlet implementation class enrollClass
 */
@WebServlet("/enrollClass")
public class enrollClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enrollClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		
		if (action.equals("enrollJSP"))
			processEnrollJSP(request, response);
		else if (action.equals("enroll"))
			processEnroll(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void processEnrollJSP(HttpServletRequest request,
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
		
		List<HcClass> class_list =  HcClassesDB.getCurrentActiveClasses(Integer.toString(year), currSemester);
		ArrayList<HcClass> class_array = new ArrayList<HcClass>();
		if (class_list == null || class_list.isEmpty())
			class_array = null;
		else{
			int j=0;
			for (int i=0; i<class_list.size(); i++){
				long num_of_students = HcGradesDB.getEnrolledStudents(class_list.get(i).getCrn());
				
				BigDecimal bd = new BigDecimal(num_of_students);
				if (class_list.get(i).getHcClassroom().getMaxCapacity().compareTo(bd) == 1 )
					if (HcGradesDB.selectEnrolledClass(class_list.get(i).getCrn(), student.getHcPerson().getPersonId()) == null){
						class_array.add(j, class_list.get(i));
						j++;
					}
			}
			
		}
		request.setAttribute("avail_class", class_array);
		getServletContext().getRequestDispatcher("/enrollClassForm.jsp").forward(
				request, response);
		
	}

	private void processEnroll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HcStudent student = (HcStudent) session.getAttribute("student");
		String selected_crn = request.getParameter("crn");
		HcClass selected_class = HcClassesDB.getAClassByCRN(selected_crn);
		
		HcGrade grade = new HcGrade();
		grade.setHcPerson(student.getHcPerson());
		grade.setHcClass(selected_class);
		HcGradesDB.insert(grade);
		processEnrollJSP(request, response);
		
		}
	
}

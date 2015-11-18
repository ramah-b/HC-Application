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

import model.HcClassroom;
import model.HcCours;
import model.HcDepartment;
import customPackage.HcClassroomsDB;
import customPackage.HcCoursesDB;
import customPackage.HcDepartmentsDB;

/**
 * Servlet implementation class classroomServlet
 */
@WebServlet("/classroomServlet")
public class classroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String updateFlag="";
	private static String createFlag="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classroomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action= request.getParameter("action");
		
		if (action.equals("createJSP"))
			processCreateClassroomJSP(request, response);
		else if (action.equals("create"))
			processCreateClassroom(request, response);
		else if(action.equals("list"))
			processListClassroomsJSP(request, response);
		else if(action.equals("updateJSP"))
			processUpdateClassroomJSP(request, response);
		else if(action.equals("update"))
			processUpdateClassroom(request, response);
		else if(action.equals("disable"))
			processEnableDisable(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processListClassroomsJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<HcClassroom> classrooms_list = HcClassroomsDB.getAllClassrooms();
		
		if (classrooms_list == null || classrooms_list.isEmpty())
			classrooms_list = null;
		
		request.setAttribute("classrooms", classrooms_list);
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

		getServletContext().getRequestDispatcher("/adminViewAllClassrooms.jsp").forward(request,
				response);
		
		
		}
	
	private void processCreateClassroomJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		

		getServletContext().getRequestDispatcher("/adminCreateClassroomJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processCreateClassroom(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String classroom_number = request.getParameter("classroom_number");
		String bldg_name = request.getParameter("bldg_name");
		String max_capacity = request.getParameter("max_capacity");
		
		BigDecimal bd = new BigDecimal(Integer.parseInt(max_capacity));
		if (!HcClassroomsDB.classroomExists(classroom_number, bldg_name)){
			HcClassroom new_classroom = new HcClassroom();
			new_classroom.setClassroomNumber(classroom_number);
			new_classroom.setBuildingName(bldg_name);
			new_classroom.setMaxCapacity(bd);
			new_classroom.setExistsFlag("1");
			
			
			HcClassroomsDB.insert(new_classroom);
			createFlag="yes";
			processListClassroomsJSP(request, response);
				
			
		}else{
			String message="Course Already Exists.";
			request.setAttribute("message", message);
			List<HcDepartment> department_list = HcDepartmentsDB.getAllDepartments();
			
			if (department_list == null || department_list.isEmpty())
				department_list = null;
			
		
			getServletContext().getRequestDispatcher("/adminCreateCourseJSP.jsp").forward(
					request, response);
		}
		
		}
	private void processUpdateClassroomJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		request.setAttribute("classroom_number",request.getParameter("classroom_number"));
		request.setAttribute("bldg_name",request.getParameter("bldg_name"));
		
		getServletContext().getRequestDispatcher("/adminUpdateClassroomJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processUpdateClassroom(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String classroom_number = request.getParameter("classroom_number");
		String bldg_name = request.getParameter("bldg_name");
		
		HcClassroom classroom = new HcClassroom();
		classroom.setClassroomNumber(classroom_number);
		classroom.setBuildingName(bldg_name);
		
		String max_capacity = request.getParameter("max_capacity");
		if (!max_capacity.isEmpty()){
			BigDecimal bd = new BigDecimal(Integer.parseInt(max_capacity));
			classroom.setMaxCapacity(bd);
		}
		
			
			HcClassroomsDB.update(classroom);
			updateFlag="yes";
			processListClassroomsJSP(request, response);
		}

	private void processEnableDisable(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String classroom_number = request.getParameter("classroom_number");
		String bldg_name = request.getParameter("bldg_name");
		
		
		
		HcClassroom classroom = new HcClassroom();
		classroom = HcClassroomsDB.selectAClassroom(classroom_number, bldg_name);
		if (classroom.getExistsFlag().equals("1"))
			classroom.setExistsFlag("0");
		
		else if (classroom.getExistsFlag().equals("0"))
			classroom.setExistsFlag("1");
	
		HcClassroomsDB.update(classroom);
			
		processListClassroomsJSP(request, response);
		}

}

package adminCustomPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HcDepartment;
import model.HcMajor;
import customPackage.HcDepartmentsDB;
import customPackage.HcMajorsDB;

/**
 * Servlet implementation class majorServlet
 */
@WebServlet("/majorServlet")
public class majorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String updateFlag="";
	private static String createFlag="";
	
    public majorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action= request.getParameter("action");
		
		if (action.equals("createJSP"))
			processCreateMajorJSP(request, response);
		else if (action.equals("create"))
			processCreateMajor(request, response);
		else if(action.equals("list"))
			processListMajorsJSP(request, response);
		else if(action.equals("updateJSP"))
			processUpdateMajorJSP(request, response);
		else if(action.equals("update"))
			processUpdateMajor(request, response);
		else if(action.equals("disable"))
			processEnableDisable(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processListMajorsJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<HcMajor> major_list = HcMajorsDB.getAllMajors();
		
		if (major_list == null || major_list.isEmpty())
			major_list = null;
		
		request.setAttribute("majors", major_list);
		
		if (updateFlag.equals("yes")){
			String message = "Major has been updated.";
			request.setAttribute("message", message);
			updateFlag="no";
		}
		if (createFlag.equals("yes")){
			String message = "Major has been created.";
			request.setAttribute("message", message);
			createFlag="no";
		}

		getServletContext().getRequestDispatcher("/adminViewAllMajors.jsp").forward(request,
				response);
		
		
		}
	
	private void processCreateMajorJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<HcDepartment> department_list = HcDepartmentsDB.getAllDepartments();
		
		if (department_list == null || department_list.isEmpty())
			department_list = null;
		
		request.setAttribute("departments", department_list);

		getServletContext().getRequestDispatcher("/adminCreateMajorJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processCreateMajor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String department_id = request.getParameter("department_id");
		System.out.println("dept id "+ department_id);
		if (!HcMajorsDB.majorExists(name)){
			HcMajor new_major = new HcMajor();
			new_major.setName(name);
			HcDepartment dept = new HcDepartment();
			dept = HcDepartmentsDB.getDepartmentByDepartmentID(department_id);
			new_major.setHcDepartment(dept);
			new_major.setExistsFlag("1");

			
			
			HcMajorsDB.insert(new_major);
			createFlag="yes";
			processListMajorsJSP(request, response);
				
			
		}else{
			String message="Major Already Exists.";
			request.setAttribute("message", message);
			
			
		
			getServletContext().getRequestDispatcher("/adminCreateMajorJSP.jsp").forward(
					request, response);
		}
		
		}
	private void processUpdateMajorJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		List<HcDepartment> department_list = HcDepartmentsDB.getAllDepartments();
		
		if (department_list == null || department_list.isEmpty())
			department_list = null;
		
		request.setAttribute("departments", department_list);

		
		request.setAttribute("major_id",request.getParameter("major_id"));
		
		getServletContext().getRequestDispatcher("/adminUpdateMajorJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processUpdateMajor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String department_id = request.getParameter("department_id");
		String name = request.getParameter("name");
		String major_id = request.getParameter("major_id");
		
		HcMajor major = new HcMajor();
		major = HcMajorsDB.getMajorByMajorID(major_id);
		if (!major.getName().equalsIgnoreCase(name)){
			major.setName(name);
			HcMajorsDB.update(major);
			updateFlag="yes";
			processListMajorsJSP(request, response);
		}else{
			String message ="Name is not Different";
			request.setAttribute("message",message);
			
			getServletContext().getRequestDispatcher("/adminUpdateMajorJSP.jsp").forward(request,
					response);
			
			
		}
		}

	private void processEnableDisable(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String major_id = request.getParameter("major_id");
		
		HcMajor major = new HcMajor();
		major = HcMajorsDB.getMajorByMajorID(major_id);
		
		if (major.getExistsFlag().equals("1"))
			major.setExistsFlag("0");
		
		else if (major.getExistsFlag().equals("0"))
			major.setExistsFlag("1");
	
		HcMajorsDB.update(major);
			
		processListMajorsJSP(request, response);
		}

}

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
import customPackage.HcDepartmentsDB;

/**
 * Servlet implementation class departmentServlet
 */
@WebServlet("/departmentServlet")
public class departmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String updateFlag="";
	private static String createFlag="";
	
	
    public departmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action= request.getParameter("action");
		
		if (action.equals("createJSP"))
			processCreateDepartmentJSP(request, response);
		else if (action.equals("create"))
			processCreateDepartment(request, response);
		else if(action.equals("list"))
			processListDepartmentsJSP(request, response);
		else if(action.equals("updateJSP"))
			processUpdateDepartmentJSP(request, response);
		else if(action.equals("update"))
			processUpdateDepartment(request, response);
		else if(action.equals("disable"))
			processEnableDisable(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processListDepartmentsJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<HcDepartment> department_list = HcDepartmentsDB.getAllDepartments();
		
		if (department_list == null || department_list.isEmpty())
			department_list = null;
		
		request.setAttribute("departments", department_list);
		
		if (updateFlag.equals("yes")){
			String message = "Department has been updated.";
			request.setAttribute("message", message);
			updateFlag="no";
		}
		if (createFlag.equals("yes")){
			String message = "Department has been created.";
			request.setAttribute("message", message);
			createFlag="no";
		}

		getServletContext().getRequestDispatcher("/adminViewAllDepartments.jsp").forward(request,
				response);
		
		
		}
	
	private void processCreateDepartmentJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		

		getServletContext().getRequestDispatcher("/adminCreateDepartmentJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processCreateDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		
		if (!HcDepartmentsDB.departmentExists(name)){
			HcDepartment new_dept = new HcDepartment();
			new_dept.setName(name);
			new_dept.setExistsFlag("1");
			
			
			HcDepartmentsDB.insert(new_dept);
			createFlag="yes";
			processListDepartmentsJSP(request, response);
				
			
		}else{
			String message="Department Already Exists.";
			request.setAttribute("message", message);
			
			
		
			getServletContext().getRequestDispatcher("/adminCreateDepartmentJSP.jsp").forward(
					request, response);
		}
		
		}
	private void processUpdateDepartmentJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		
		request.setAttribute("department_id",request.getParameter("department_id"));
		
		getServletContext().getRequestDispatcher("/adminUpdateDepartmentJSP.jsp").forward(request,
				response);
		
		
		}
	
	private void processUpdateDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String department_id = request.getParameter("department_id");
		String name = request.getParameter("name");
		
		HcDepartment dept = new HcDepartment();
		dept = HcDepartmentsDB.getDepartmentByDepartmentID(department_id);
		if (!dept.getName().equalsIgnoreCase(name)){
			dept.setName(name);
			HcDepartmentsDB.update(dept);
			updateFlag="yes";
			processListDepartmentsJSP(request, response);
		}else{
			String message ="Name is not Different";
			request.setAttribute("message",message);
			
			getServletContext().getRequestDispatcher("/adminUpdateDepartmentJSP.jsp").forward(request,
					response);
			
			
		}
		}

	private void processEnableDisable(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String department_id = request.getParameter("department_id");
		System.out.println("dept id" + department_id);
		HcDepartment dept = new HcDepartment();
		dept = HcDepartmentsDB.getDepartmentByDepartmentID(department_id);
		System.out.println("dept flag" + dept.getExistsFlag());
		if (dept.getExistsFlag().equals("1"))
			dept.setExistsFlag("0");
		
		else if (dept.getExistsFlag().equals("0"))
			dept.setExistsFlag("1");
	
		HcDepartmentsDB.update(dept);
			
		processListDepartmentsJSP(request, response);
		}
}

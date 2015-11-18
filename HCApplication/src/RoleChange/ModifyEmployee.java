package RoleChange;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customPackage.HcEmployeesDB;
import customPackage.HcPersonsDB;
import customPackage.HcRolesDB;
import customPackage.HcStudentsDB;
import model.HcEmployee;
import model.HcPerson;
import model.HcRole;
import model.HcStudent;

/**
 * Servlet implementation class ModifyEmployee
 */
@WebServlet("/ModifyEmployee")
public class ModifyEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertEmployee(request,response);
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertEmployee(request,response);
		
	}
	
	protected void insertEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		
		String pid = request.getParameter("personId");
		String roid = request.getParameter("roleId");
		System.out.println("role id " + roid);
		
		HcPerson person = new HcPerson();
		person = HcPersonsDB.selectPersonByPersonId(pid);
		
		HcRole role = new HcRole();
		role = HcRolesDB.selectRoleByRoleID(roid);
		person.setHcRole(role);
		
		HcEmployee emp = new HcEmployee();
		emp=HcEmployeesDB.selectAnEmployee(pid);
		HcStudent st = new HcStudent();
		
		if(!roid.equals(4)){
		HcPersonsDB.update(person);
		}
		else if(roid.equals(4)){
				
			st.setHcPerson(person);
			st.setName(emp.getName());
			HcStudentsDB.insert(st);
			HcEmployeesDB.delete(emp);
		}
		

		
		getServletContext().getRequestDispatcher("/adminsHomepage.jsp").forward(request,
				response);
		
	}	

}

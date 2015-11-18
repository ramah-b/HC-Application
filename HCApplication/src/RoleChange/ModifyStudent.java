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
@WebServlet("/ModifyStudent")
public class ModifyStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertStudent(request,response);
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertStudent(request,response);
		
	}
	
	protected void insertStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		EntityManager em = customTools.DBUtil.getEmFactory()
				.createEntityManager();
		
		String pid = request.getParameter("personId");
		String roid = request.getParameter("roleId");
		
		HcPerson person = new HcPerson();
		person = HcPersonsDB.selectPersonByPersonId(pid);
		
		HcRole role = new HcRole();
		role = HcRolesDB.selectRoleByRoleID(roid);
		person.setHcRole(role);		
		
		HcPersonsDB.update(person);
		
		
		HcStudent st = new HcStudent();
		st = HcStudentsDB.selectStudetnByPersonId(pid);
		HcEmployee emp = new HcEmployee();
		
		emp.setHcPerson(person);
		emp.setName(st.getName());
		
		HcEmployeesDB.insert(emp);
		
		
		
		HcStudentsDB.delete(st);
		
		
		getServletContext().getRequestDispatcher("/adminsHomepage.jsp").forward(request,
				response);
		
}	

}

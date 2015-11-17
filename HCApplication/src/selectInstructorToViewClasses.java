

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HcDepartment;
import model.HcEmployee;

/**
 * Servlet implementation class selectInstructorToViewClasses
 */
@WebServlet("/selectInstructorToViewClasses")
public class selectInstructorToViewClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectInstructorToViewClasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
		
		String q = "SELECT h FROM HcEmployee h where h.hcPerson.hcRole.roleId = 3";
		
		TypedQuery<HcEmployee> qT = em.createQuery(q, HcEmployee.class);
		
		List<HcEmployee> Instructors = null;

		String tableinfo = "";
		
		Instructors = qT.getResultList();
		String eID = null;
		String name = null;
		
		for(int i=0;i<Instructors.size();i++)
		{
			eID = Instructors.get(i).getEmployeeId();
			name = Instructors.get(i).getName();
			tableinfo += "<tr><td><a href=\"AllClassesByInstructorCurrSem?eID="+eID+"&name="+name+"\">" + Instructors.get(i).getName() +"</td></tr>";
			
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/selectInstructor.jsp")
		.forward(request, response);
	}

}

package RoleChange;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HcEmployee;
import model.HcPerson;

/**
 * Servlet implementation class advisorsCourseServlet
 */
@WebServlet("/RoleChangeEmployeeServlet")
public class RoleChangeEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleChangeEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getEmployeeRole(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getEmployeeRole(request,response);
		
	}
	
	protected void getEmployeeRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		EntityManager em = customTools.DBUtil.getEmFactory()
				.createEntityManager();
		
		String personId = request.getParameter("personId");
		
		String query = "SELECT h FROM HcEmployee h where h.hcPerson.personId = :personId "; 
		TypedQuery<HcEmployee> q = em.createQuery(query, HcEmployee.class);
		
		q.setParameter("personId",personId);

		HcEmployee pr;
		pr = q.getSingleResult();



		request.setAttribute("employee", pr);


		getServletContext().getRequestDispatcher("/RoleChangeEmployee.jsp").forward(request,
				response);
	}

}


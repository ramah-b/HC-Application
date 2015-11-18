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
import model.HcStudent;

/**
 * Servlet implementation class advisorsCourseServlet
 */
@WebServlet("/RoleChangeStudentServlet")
public class RoleChangeStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleChangeStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getStudentRole(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getStudentRole(request,response);
		
	}
	
	protected void getStudentRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		EntityManager em = customTools.DBUtil.getEmFactory()
				.createEntityManager();
		
		String personId = request.getParameter("personId");
		
		String query = "SELECT h FROM HcStudent h where h.hcPerson.personId = :personId "; 
		TypedQuery<HcStudent> q = em.createQuery(query, HcStudent.class);
		
		q.setParameter("personId",personId);

		HcStudent pr;
		pr = q.getSingleResult();



		request.setAttribute("student", pr);
		request.setAttribute("personId", personId);


		getServletContext().getRequestDispatcher("/RoleChangeStudent.jsp").forward(request,
				response);
	}

}



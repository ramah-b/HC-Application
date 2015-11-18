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

import model.HcPerson;

/**
 * Servlet implementation class advisorsCourseServlet
 */
@WebServlet("/StudentRoleChangeServlet")
public class StudentRoleChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRoleChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getPersonList(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getPersonList(request,response);
		
	}
	
	protected void getPersonList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		EntityManager em = customTools.DBUtil.getEmFactory()
				.createEntityManager();
		
		
		
		String query = "SELECT h FROM HcStudent h"; 
		TypedQuery<HcPerson> q = em.createQuery(query, HcPerson.class);
		
	

		List<HcPerson> pr;
		pr = q.getResultList();



		request.setAttribute("person", pr);


		getServletContext().getRequestDispatcher("/StudentList.jsp").forward(request,
				response);
	}

}


package model;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class departmentCoursesServlet
 */
@WebServlet("/DepartmentMajorsServlet")
public class DepartmentMajorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentMajorsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getDepartmentMajor(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getDepartmentMajor(request,response);
		// TODO Auto-generated method stub
	}
	
	protected void getDepartmentMajor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		EntityManager em = customTools.DBUtil.getEmFactory()
				.createEntityManager();
		
		String query = "SELECT h FROM HcDepartment h";
		TypedQuery<HcDepartment> q = em.createQuery(query, HcDepartment.class);

		List<HcDepartment> dep;
		dep = q.getResultList();



		request.setAttribute("department", dep);


		getServletContext().getRequestDispatcher("/DepartmentMajor.jsp").forward(request,
				response);
	}


}
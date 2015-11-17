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
 * Servlet implementation class findCourseDepartmentServlet
 */
@WebServlet("/findDepartmentClassServlet")
public class findDepartmentClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findDepartmentClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getDepartmentClass(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getDepartmentClass(request,response);
		
		// TODO Auto-generated method stub
	}
	
	protected void getDepartmentClass(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		EntityManager em = customTools.DBUtil.getEmFactory()
				.createEntityManager();
		
		String dep = request.getParameter("name"); 
		
		String query = "SELECT h FROM HcCours h where h.hcDepartment.name = :name AND h.existsFlag = '1'";
		TypedQuery<HcCours> q = em.createQuery(query, HcCours.class);
		
		q.setParameter("name", dep);

		List<HcCours> cour;
		cour = q.getResultList();

		for (HcCours courses : cour) {
			System.out.println("************************"+ courses.getName());
			System.out.println("**********************"+ courses.getCourseNumber());
			System.out.println("**********************" + courses.getCredits());
			System.out.println(courses.getHcClasses().size());
			
			
		for(int i=0; i < courses.getHcClasses().size();i++){
			
			System.out.println("***********************"+ courses.getHcClasses().get(i).getDay());
			
			System.out.println("***********************"+ courses.getHcClasses().get(i).getSemester());
		
	}
		


		request.setAttribute("courses", cour );


		getServletContext().getRequestDispatcher("/depClass.jsp").forward(request,
				response);
	}

	}
}


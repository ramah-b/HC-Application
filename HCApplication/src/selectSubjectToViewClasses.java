

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HcClass;
import model.HcDepartment;

/**
 * Servlet implementation class selectSubjectToViewClasses
 */
@WebServlet("/selectSubjectToViewClasses")
public class selectSubjectToViewClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
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
		
		String q = "SELECT h FROM HcDepartment h";
		
		TypedQuery<HcDepartment> qT = em.createQuery(q, HcDepartment.class);
		
		List<HcDepartment> Departments = null;

		String tableinfo = "";
		
		Departments = qT.getResultList();
		String dID = null;
		String dept = null;
		
		for(int i=0;i<Departments.size();i++)
		{
			dID = Departments.get(i).getDepartmentId();
			dept = Departments.get(i).getName();
			tableinfo += "<tr><td><a href=\"pullSubject?dID="+dID+"\">" + Departments.get(i).getName() +"</td></tr>";
			
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/selectSubject.jsp")
		.forward(request, response);
	}


}

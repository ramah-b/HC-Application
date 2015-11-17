

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
import javax.servlet.http.HttpSession;

import model.HcClass;
import model.HcDepartment;

/**
 * Servlet implementation class pullSubject
 */
@WebServlet("/pullSubject")
public class pullSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pullSubject() {
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
		
		String q = "SELECT h FROM HcDepartment h where h.departmentId = :dID and h.existsFlag = 1";
		
		TypedQuery<HcDepartment> qT = em.createQuery(q, HcDepartment.class);
		
		qT.setParameter("dID", request.getParameter("dID"));
		
		HcDepartment dept = null;
		
		dept = qT.getSingleResult();
		
		String subject = dept.getName();
		
		request.setAttribute("subject", subject);

		getServletContext()
		.getRequestDispatcher("/AllClassesInSubjCurrSem")
		.forward(request, response);
	}

}

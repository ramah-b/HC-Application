

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

/**
 * Servlet implementation class AllClassesAtTimeCurrSem
 */
@WebServlet("/AllClassesAtTimeCurrSem")
public class AllClassesAtTimeCurrSem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllClassesAtTimeCurrSem() {
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
		HttpSession session = request.getSession();
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = (c.get(Calendar.MONTH))+1;
		
		String currSemester = "";
		
		if (month >= 1 && month <= 5){
			currSemester = "Spring";
		}
		else if (month >= 8 && month <= 12){
			currSemester = "Fall";
		}
		
		String q = "SELECT h FROM HcClass h where h.existsFlag = 1 and h.semester = :sem and h.year = :yr and h.time = :time";
		
		TypedQuery<HcClass> qT = em.createQuery(q, HcClass.class);
		
		qT.setParameter("sem", currSemester);
		qT.setParameter("yr", String.valueOf(year));
		qT.setParameter("time", request.getParameter("time"));
		
		List<HcClass> Classes = null;

		String tableinfo = "";
		
		Classes = qT.getResultList();
		
		for(int i=0;i<Classes.size();i++)
		{
			tableinfo += "<tr><td>" + Classes.get(i).getCrn()+"</td><td>" + Classes.get(i).getDay()+"</td><td>" + Classes.get(i).getTime()+"</td><td>" + Classes.get(i).getHcPerson().getHcEmployee().getName()+"</td><td>" + Classes.get(i).getHcCours().getName()+"</td><td>" + Classes.get(i).getHcClassroom().getBuildingName()+"</td><td>" + "Rm "+ Classes.get(i).getHcClassroom().getClassroomNumber()+"</td></tr>";
		}
		request.setAttribute("tableinfo", tableinfo);
		session.setAttribute("currSem", currSemester);
		session.setAttribute("currYear", year);
		request.setAttribute("time", request.getParameter("time"));

		getServletContext()
		.getRequestDispatcher("/AllClassesAtTimeCurrSem.jsp")
		.forward(request, response);
	}

}

package customPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HcEmployee;
import model.HcPerson;
import model.HcRole;



/**
 * Servlet implementation class generalServlet
 */
@WebServlet("/generalServlet")
public class generalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equals("signupJSP"))
			processSignupJSP(request, response);
		else if (action.equals("signup"))
			processSignup(request, response);
		else if (action.equals("login"))
			processLogin(request, response);
		else if (action.equals("logout"))
			processLogout(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void processSignupJSP(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/signup.jsp").forward(
				request, response);

	}

	private void processSignup(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		HcPerson newPerson = new HcPerson();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		HcRole defaultRole = HcRolesDB.selectDefaultRole();

		if (!HcPersonsDB.usernameExists(username)) {
			if (!HcPersonsDB.emailExists(email)) {

				newPerson.setUsername(username);
				newPerson.setPassword(password);
				newPerson.setEmail(email);
				newPerson.setHcRole(defaultRole);

				HcPersonsDB.insert(newPerson);

				newPerson = HcPersonsDB.selectPersonByUsername(username);

				session.setAttribute("person", newPerson);

			} else {
				String emailError = "Email Already Registered!";
				request.setAttribute("emailError", emailError);
				getServletContext().getRequestDispatcher("/signup.jsp")
						.forward(request, response);

			}
		} else {

			String message = "Username Already Exists.";

			request.setAttribute("message", message);

			getServletContext().getRequestDispatcher("/signup.jsp").forward(
					request, response);
		}

	}

	private void processLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HcPerson personUser = HcPersonsDB.selectAPerson(username, password);

		if (personUser == null) {
			String message = "Invalid Username and/or Password.";

			session.setAttribute("message", message);

			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);
		}

		else {
			session.setAttribute("person", personUser);
			
		}

	}
	
	private void processHomepage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		HcPerson person = (HcPerson) session.getAttribute("person");
		String role_id = person.getHcRole().getRoleId();
		String person_id = person.getPersonId();

		if (role_id.equals("1")){
			HcEmployee empUser = HcEmployeesDB.selectAnEmployee(person_id);
			if (empUser == null){
				empUser= null;
			}else{
				
				session.setAttribute("admin", empUser);
			getServletContext().getRequestDispatcher("/adminHomepage.jsp").forward(
					request, response);
			}
		}else if (role_id.equals("2")){
			HcEmployee empUser = HcEmployeesDB.selectAnEmployee(person_id);
			if (empUser == null){
				empUser= null;
			}else{
				
				session.setAttribute("advisor", empUser);
			getServletContext().getRequestDispatcher("/advisorHomepage.jsp").forward(
					request, response);
			}
		}else if (role_id.equals("3")){
			HcEmployee empUser = HcEmployeesDB.selectAnEmployee(person_id);
			if (empUser == null){
				empUser= null;
			}else{
				
				session.setAttribute("student", empUser);
			getServletContext().getRequestDispatcher("/studentHomepage.jsp").forward(
					request, response);
			}
		}else{
			getServletContext().getRequestDispatcher("/notClassified.jsp").forward(
					request, response);
		}
		
		

	}

	
	

	private void processLogout(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();

		HcPerson person = (HcPerson) session.getAttribute("person");

		session.removeAttribute("person");

		try {

			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

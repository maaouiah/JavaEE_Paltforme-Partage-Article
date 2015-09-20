package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import controllers.AuthentificationCtlr;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/connexion.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		
		
		if (  session.getAttribute("user") == null ){
			
			AuthentificationCtlr auth = new AuthentificationCtlr();
			User user = auth.connexion(request);
			
			if (  auth.getErreurs().isEmpty() ){
				
				session.setAttribute("user", user);
				session.setAttribute("info", "Vous êtes maintenant connecter au site, bonne visite");
				response.sendRedirect("/ProjetEE/index");
				
			}
			else{
				request.setAttribute("erreurs", auth.getErreurs() );
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/connexion.jsp").forward( request, response );
			}
			
		}
		else
				response.sendRedirect("/ProjetEE/index");
	}


}

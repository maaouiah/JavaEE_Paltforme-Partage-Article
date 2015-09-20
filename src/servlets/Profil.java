package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.ProfilCtlr;
import bean.User;
import bean.News;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
				User user  =  (User) session.getAttribute("user") ;
				request.setAttribute("profil", user);
				
				ProfilCtlr profilCtlr  = new ProfilCtlr();
				List<News> listeNews = profilCtlr.mesArticlesProfil(request);
				
				request.setAttribute("listeNews", listeNews );
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/profil.jsp").forward( request, response );
		
		}
		else{
			session.setAttribute("msgAll", "Veuillez vous connecter pour accèder à cette section");
			response.sendRedirect("/ProjetEE/index");
		}
		
	}


}

package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.NewsCtlr;

/**
 * Servlet implementation class SupprimerNews
 */
@WebServlet("/deleteNews")
public class SupprimerNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null )
		{
			if (  request.getParameter("id") != null ){
				
				NewsCtlr newsCtlr = new NewsCtlr();
				newsCtlr.supprimerNews(request);
				response.sendRedirect("/ProjetEE/mesArticles");
				}
			else
				response.sendRedirect("/ProjetEE/index");
			}
		else{
			session.setAttribute("msgAll", "Veuillez vous connecter pour effectuer cette opération");
			response.sendRedirect("/ProjetEE/index");
			}
	   }



}

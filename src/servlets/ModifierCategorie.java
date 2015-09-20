package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Categorie;
import controllers.CategorieCtlr;

/**
 * Servlet implementation class ModifierCategorie
 */
@WebServlet("/updateCat")
public class ModifierCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
		
			if (  request.getParameter("id") != null ){
				
				CategorieCtlr catCtlr = new CategorieCtlr();
				Categorie cat = catCtlr.getCategorie( request.getParameter("id") );
				
				if (  cat != null ){
					request.setAttribute("categorie", cat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/views/modifierCategorie.jsp").forward( request, response );
				}
				
			}
			else{
				response.sendRedirect("/ProjetEE/categories");
				}
		}
		else{
			session.setAttribute("msgAll", "Veuillez vous connecter pour effectuer cette opération");
			response.sendRedirect("/ProjetEE/index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
		
		
			CategorieCtlr catCtlr = new CategorieCtlr();
			Categorie cat = catCtlr.ModifierCategorie(request);
			if (  cat != null ){
				request.setAttribute("message", "Modification effectuée avec succès.");
				request.setAttribute("categorie", cat);
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/modifierCategorie.jsp").forward( request, response );
			}
		}
		else{
			session.setAttribute("msgAll", "Pas d'accès à cette opération");
			response.sendRedirect("/ProjetEE/index");
		}
		
	}

}

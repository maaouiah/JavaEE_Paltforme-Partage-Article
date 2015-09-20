package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.CategorieCtlr;

/**
 * Servlet implementation class AjouterCategorie
 */
@WebServlet("/addCat")
public class AjouterCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/AjouterCategorie.jsp").forward( request, response );
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
		// Ajouter catégorie ( POST ) 
		CategorieCtlr catCtlr = new CategorieCtlr();
		boolean result = catCtlr.ajouterCategorie(request);
		
		if (  result == true )
			request.setAttribute("succes", "Catégorie ajoutée aves succès.");
		else
			request.setAttribute("erreurs", catCtlr.getErreurs() );

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/AjouterCategorie.jsp").forward( request, response );
		}
		else{
			session.setAttribute("msgAll", "Pas d'accès à cette opération");
			response.sendRedirect("/ProjetEE/index");
		}
		
	}

}

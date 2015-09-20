package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Categorie;
import controllers.CategorieCtlr;

/**
 * Servlet implementation class Categories
 */
@WebServlet("/categories")
public class Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categories() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
		
			CategorieCtlr catCtlr = new CategorieCtlr() ;
			List<Categorie> listCat  = catCtlr.listeCategories();
			request.setAttribute("listeCats", listCat );
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeCategories.jsp").forward( request, response );
		
		}
		else{
			session.setAttribute("msgAll", "Veuillez vous connecter pour effectuer cette opération");
			response.sendRedirect("/ProjetEE/index");
		}
		
	}

}

package servlets;

import java.io.File;
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
import controllers.NewsCtlr;

/**
 * Servlet implementation class AjouterNews
 */
@WebServlet("/addNews")
public class AjouterNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterNews() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 // récupération de la liste des catégories
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
			
		
		CategorieCtlr catCtlr = new CategorieCtlr() ;
		List<Categorie> listeCats = catCtlr.listeCategories();
		request.setAttribute("listeCategories", listeCats);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/ajouterNews.jsp").forward( request, response );
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
		// 2 // envoie du formaulire
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
			
		NewsCtlr NewsCtlr = new NewsCtlr() ;
		CategorieCtlr catCtlr = new CategorieCtlr() ;
		List<Categorie> listeCats = catCtlr.listeCategories();

        
		boolean result  =  NewsCtlr.ajouterNews(request );
		request.setAttribute("listeCategories", listeCats);
		if (  result )
			request.setAttribute("message",  "Article ajouté avec succès." );
		else
			request.setAttribute("erreurs",  NewsCtlr.getErreurs() );
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/ajouterNews.jsp").forward( request, response );
		}
		else{
			session.setAttribute("msgAll", "Pas d'accès à cette opération");
			response.sendRedirect("/ProjetEE/index");
		}
	}

}

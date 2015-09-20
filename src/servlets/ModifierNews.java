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
import bean.News;
import controllers.CategorieCtlr;
import controllers.NewsCtlr;

/**
 * Servlet implementation class ModifierNews
 */
@WebServlet("/updateNews")
public class ModifierNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierNews() {
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
			
			NewsCtlr newsCtlr = new NewsCtlr();
			News news = newsCtlr.getNews( request.getParameter("id") );
			
			if (  news != null ){
				
				CategorieCtlr catCtlr = new CategorieCtlr() ;
				List<Categorie> listeCats = catCtlr.listeCategories();
				request.setAttribute("listeCategories", listeCats);
				request.setAttribute("news", news);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/modifierNews.jsp").forward( request, response );
			}
			else
				response.sendRedirect("/ProjetEE/news");
		}
		else{
			response.sendRedirect("/ProjetEE/news");
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
			
			NewsCtlr NewsCtlr = new NewsCtlr() ;
			CategorieCtlr catCtlr = new CategorieCtlr() ;
			List<Categorie> listeCats = catCtlr.listeCategories();
			request.setAttribute("listeCategories", listeCats);
			
			boolean result  =  NewsCtlr.modifierNews(request );
			if (  result ){
				
				News news = NewsCtlr.getTheNews() ;
				if( news != null ){
					request.setAttribute("message",  "Article à jour." );
					request.setAttribute("news",  news );
				}

			}
			else
				request.setAttribute("erreurs",  NewsCtlr.getErreurs() );
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/modifierNews.jsp").forward( request, response );
		
		}
		else{
			session.setAttribute("msgAll", "Pas d'accès à cette opération");
			response.sendRedirect("/ProjetEE/index");
		}
	}

}

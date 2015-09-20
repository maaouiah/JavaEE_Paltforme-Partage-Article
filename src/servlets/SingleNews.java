package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CategorieCtlr;
import controllers.NewsCtlr;
import bean.Categorie;
import bean.News;
/**
 * Servlet implementation class SingleNews
 */
@WebServlet("/singlenews")
public class SingleNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleNews() {

        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (  request.getParameter("id") != "" ){
			
			NewsCtlr newsCtlr 	= new NewsCtlr();
			News news = newsCtlr.getNews(  request.getParameter("id") );
			request.setAttribute("news", news);
			
			CategorieCtlr catCtlr = new CategorieCtlr() ;
			List<Categorie> listeCats = catCtlr.listeCategories();
			request.setAttribute("listeCategories", listeCats);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/singleNews.jsp").forward( request, response );
			
		}
		else
			response.sendRedirect("/ProjetEE/index");
		
	}


}

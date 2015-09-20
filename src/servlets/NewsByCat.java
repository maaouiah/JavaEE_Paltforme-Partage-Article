package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Categorie;
import bean.News;
import controllers.CategorieCtlr;
import controllers.NewsCtlr;

/**
 * Servlet implementation class NewsByCat
 */
@WebServlet("/news/cat")
public class NewsByCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsByCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (  request.getParameter("id") != null ){
			
			// news
			NewsCtlr newsCtlr 	= new NewsCtlr();
			List<News> news 	=  newsCtlr.getListNewsByCat(request);
			request.setAttribute("listeNews", news);
			
			// cats
			CategorieCtlr catCtlr = new CategorieCtlr() ;
			List<Categorie> listeCats = catCtlr.listeCategories();
			request.setAttribute("listeCategories", listeCats);
			
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeNewsByCat.jsp").forward( request, response );
			
		}
		else
			response.sendRedirect("/ProjetEE/index");
			
		
		
		
	}

}

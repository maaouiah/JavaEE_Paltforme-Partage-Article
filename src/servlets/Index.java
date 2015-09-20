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
 * Servlet implementation class Index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Liste catégories
		CategorieCtlr catCtlr = new CategorieCtlr() ;
		List<Categorie> listeCats = catCtlr.listeCategories();
		request.setAttribute("listeCategories", listeCats);
		
		// Liste news
		NewsCtlr NewsCtlr = new NewsCtlr();
		List<News> listeNews = NewsCtlr.getListNews() ;
		request.setAttribute("listeNews", listeNews);
		

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward( request, response );
		
	}


}

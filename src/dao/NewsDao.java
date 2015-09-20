package dao;

import java.util.List;

import bean.News;
import bean.User;



public interface NewsDao {

	public void creer( News news );
	public void supprimer( News news);
	public void modifier(News news);
	public List<News> getNews() ;
	public List<News> getNewsByUser( User id ) ;
	public List<News> getNewsByUserForProfil( User id );
	public List<News> getNewsByCategorie(long catID ) ;
	public News findNews( long id );
}

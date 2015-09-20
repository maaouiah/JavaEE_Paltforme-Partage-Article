package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bean.Categorie;
import bean.News;
import bean.User;

public class NewsDaoImpl implements NewsDao{

	EntityManagerFactory factory ;
	EntityManager entityManager ;
	
	public NewsDaoImpl(){
		
		factory = Persistence.createEntityManagerFactory("news");
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	@Override
	public void creer(News news) {
		
		entityManager.merge(news);
		entityManager.getTransaction().commit();
	}

	@Override
	public void modifier(News news) {
		
		News nn = findNews( news.getId() );
		
		// on supprimer les anciennes catégories
		nn.removeCats();
		entityManager.merge(nn);
		
		// et on mets à jout l'entité
		
		entityManager.merge(news);
		entityManager.getTransaction().commit();
		
	}
	
	@Override
	public void supprimer(News news) {
		
		news.removeCats();
		entityManager.remove(news);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNews() {
		 Query query = entityManager.createQuery("SELECT m from News as m Order BY m.dateAjout DESC ");
		 return query.getResultList();
	}

	@Override
	public News findNews(long id) {
		return entityManager.find(News.class, id) ;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNewsByUser( User id ) {
		//select r from Order o left outer join o.renewedOrders r where o.id =:orderId 
		Query query = entityManager.createQuery("SELECT m from News as m WHERE m.user = :userid Order BY m.dateAjout DESC ");
		query.setParameter("userid", id);
		return query.getResultList();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNewsByCategorie(long catID) {
		Query query = entityManager.createQuery("SELECT m from News as m join m.categories c WHERE c.id = :catID Order BY  m.dateAjout DESC ");
		query.setParameter("catID", catID);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNewsByUserForProfil(User id) {
		Query query = entityManager.createQuery("SELECT m from News as m WHERE m.user = :userid Order BY m.dateAjout DESC ").setMaxResults(5);
		query.setParameter("userid", id);
		return query.getResultList();
	}


}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.Categorie;

public class CategorieDaoImpl implements CategorieDao{

	EntityManagerFactory factory ;
	EntityManager entityManager ;
	
	public CategorieDaoImpl(){
		
		factory = Persistence.createEntityManagerFactory("news");
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	@Override
	public void creer(Categorie categorie) {

		entityManager.persist(categorie);
		entityManager.getTransaction().commit();

	}

	@Override
	public void supprimer(Categorie categorie) {
		entityManager.remove(categorie);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Categorie> getCategories() {

		 Query query = entityManager.createQuery("SELECT m from Categorie as m");
		 @SuppressWarnings("unchecked")
		List<Categorie> test = (List<Categorie>)  query.getResultList();
		 return test ;
	}

	@Override
	public Categorie findCategorie(long id) {
		return entityManager.find(Categorie.class, id) ;
	}

	@Override
	public Categorie findCategorieByName(String name) {
		

		Query query = entityManager.createQuery(" SELECT u FROM Categorie u WHERE u.nom = :nomcat ") ;
		query.setParameter("nomcat", name);
		try{
            Categorie cat = (Categorie) query.getSingleResult();
        	  return cat ;

        }catch(Exception e){
            return null;
        }
	}

	@Override
	public void modifier(Categorie categorie) {

		entityManager.merge(categorie);
		entityManager.getTransaction().commit();
	}

}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bean.User;



public class UserDaoImpl implements UserDao {

	EntityManagerFactory factory ;
	EntityManager entityManager ;
	
	public UserDaoImpl(){
		
		factory = Persistence.createEntityManagerFactory("news");
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	@Override
	public void creer(User user) {

		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		
	}
	@Override
	public void supprimer(User user) {
		
		entityManager.remove(user);
		entityManager.getTransaction().commit();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		
		 Query query = entityManager.createQuery("SELECT m from User as m");
		 return query.getResultList();
	}
	
	
	@Override
	public User findUser(long id) {
			return entityManager.find(User.class, id) ;
	}
	@Override
	public User findUserByEmailAndPasse(String email, String passe) {
		
		Query query = entityManager.createQuery(" SELECT u FROM User u WHERE u.email = :email AND u.motdepasse = :pass ").setMaxResults(1) ;
		query.setParameter("email", email);
		query.setParameter("pass", passe);
		
		try{
            User user = (User) query.getSingleResult();
          if (email.equalsIgnoreCase(user.getEmail() ) && passe.equals(user.getMotdepasse() )) {
        	  
        	  return user ;
        	  
          }
        }catch(Exception e){
            return null;
        }
		
		return null ;
	
	}

}

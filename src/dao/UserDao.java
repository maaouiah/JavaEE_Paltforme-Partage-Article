package dao;

import java.util.List;

import bean.User;

public interface UserDao {
	
		public void creer( User user );
		public void supprimer( User user);
		public List<User> getUsers() ;
		public User findUser( long id );
		public User findUserByEmailAndPasse( String email , String passe );
}

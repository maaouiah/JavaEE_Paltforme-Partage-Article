package dao;

import java.util.List;

import bean.Categorie;



public interface CategorieDao {

	public void creer( Categorie categorie );
	public void supprimer( Categorie categorie );
	public void modifier( Categorie categorie );
	public List<Categorie> getCategories() ;
	public Categorie findCategorie( long id );
	public Categorie findCategorieByName( String name );
}

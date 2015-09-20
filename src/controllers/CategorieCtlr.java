package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.CategorieDaoImpl;
import bean.Categorie; 

public class CategorieCtlr {
	
	private Map<String, String> erreurs  = new HashMap<String, String>();
	
	
	public boolean ajouterCategorie( HttpServletRequest request){
		
		String nom = getValeur( request , "categorie" ) ;
		
		try{
			validationNom( nom );
		}catch(Exception e ){
			setErreur("nom", e.getMessage());
		}
		
		if (erreurs.isEmpty() ){
				
			CategorieDaoImpl catImpl = new CategorieDaoImpl() ;
			Categorie cat = catImpl.findCategorieByName(nom);
			if ( cat != null ){
				setErreur("ajout", "Cette catégorie existe déjà !");
				return false ;
			}
			else
			{
				cat = new Categorie(nom) ;
				catImpl.creer(cat);
				return true ;
			}
			
		}
		else
			return false ;
		
	}
	
	public boolean SupprimerCategorie( HttpServletRequest request){
		
		String id = getValeur( request , "id" );
		if ( id.matches("\\d*")){
			
				CategorieDaoImpl catImpl = new CategorieDaoImpl() ;
				Categorie cat = catImpl.findCategorie( Long.valueOf(id).longValue() );
				
				if ( cat != null ){
						catImpl.supprimer(cat);
						return true ;
				}
				else
						return false ;
		}
		
		return false ;
		
	}
	
	public Categorie getCategorie( String id ){
		
		if ( id.matches("\\d*")){
			
				CategorieDaoImpl catImpl = new CategorieDaoImpl() ;
				Categorie cat = catImpl.findCategorie( Long.valueOf(id).longValue() );
				
				if ( cat != null ){
						return cat ;
				}
		}
		return null ;
		
	}
	public Categorie ModifierCategorie( HttpServletRequest request){
		
		String id = getValeur( request , "id");
		String categorie = getValeur( request , "categorie");
		Categorie cat = new Categorie( Long.valueOf(id).longValue() , categorie ) ;
		CategorieDaoImpl catImpl = new CategorieDaoImpl() ;
		catImpl.modifier(cat);
		return cat ;
	}
	
	public List<Categorie> listeCategories(){
		
		CategorieDaoImpl catImpl = new CategorieDaoImpl() ;
		return catImpl.getCategories();
	}
	
	
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    private static String getValeur( HttpServletRequest request, String champ ) {
        String valeur = request.getParameter( champ );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
    private void validationNom( String nom ) throws Exception {
        if ( nom != null ) {
            if ( nom.length() < 3 ) {
                throw new Exception( "Le nom doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir le nom de la catégorie." );
        }
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    


}

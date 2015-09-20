package controllers;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.UserDaoImpl;
import bean.User; 

public class AuthentificationCtlr {

	
	private Map<String, String> erreurs  = new HashMap<String, String>();
	
	
	public User connexion( HttpServletRequest request ){
		
		// vérification des données saisies par l'utilisateur
		String email =  getValeur( request , "email");
		System.out.println( email );
		String motdepasse = getValeur( request , "motdepasse");
		System.out.println( motdepasse );
		
		
		// validation de l'adresse email
		try{
			validationEmail( email );
		}catch(Exception e ){
			setErreur("email", e.getMessage());
		}
		
		// validation du mot de passe
		try{
			validationMotDePasse( motdepasse );
		}catch(Exception e ){
			setErreur("motdepasse", e.getMessage());
		}
		
		if (  erreurs.isEmpty() ){
			UserDaoImpl userImpl = new UserDaoImpl() ;
			User utilisateur = userImpl.findUserByEmailAndPasse(email, motdepasse );
			
			if (  utilisateur != null )
				return utilisateur ;
			else
				{

					setErreur("compte", "Identifiant / mot de passe incorrecte .");
					return null ;
				}
		}
		else
			return null ;
		
	}
	
	
	
	public User inscription( HttpServletRequest request ){
		
		String pseudo = getValeur( request , "pseudo");
		String nom = getValeur( request , "nom");
		String email = getValeur( request , "email");
		String motdepasse = getValeur( request , "motdepasse");
		
		// date 
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp dateinscription = new java.sql.Timestamp(calendar.getTime().getTime());
		
		// validation du mot de passe
		try{
			validationPseudo( pseudo );
		}catch(Exception e ){
			setErreur("pseudo", e.getMessage());
		}
		
		try{
			validationPseudo( nom );
		}catch(Exception e ){
			setErreur("nom", e.getMessage());
		}
		
		
		// validation de l'adresse email
		try{
			validationEmail( email );
		}catch(Exception e ){
			setErreur("email", e.getMessage());
		}
		
		// validation du mot de passe
		try{
			validationMotDePasse( motdepasse );
		}catch(Exception e ){
			setErreur("motdepasse", e.getMessage());
		}
		
		
		if (  erreurs.isEmpty() ){
			
			User user = new  User( nom , pseudo , motdepasse , email , dateinscription ) ;
			UserDaoImpl userImpl = new UserDaoImpl();
			userImpl.creer(user);
			return userImpl.findUserByEmailAndPasse( email , motdepasse );
		}
		else
			return null ;
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
    
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }
    
    private void validationPseudo( String pseudo )throws Exception {
    	if (  pseudo.matches("([a-zA-Z-0-9]+)") && pseudo.length() < 8  ){
    		throw new Exception("Le pseudo doit contenir au moins 8 caractères et composé uniquement d'une suite alphanumérique");
    	}
    }
    
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
}

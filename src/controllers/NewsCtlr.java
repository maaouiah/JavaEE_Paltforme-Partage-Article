package controllers;




import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.CategorieDaoImpl;
import dao.NewsDaoImpl;
import dao.UserDaoImpl;
import bean.Categorie;
import bean.News;
import bean.User;

public class NewsCtlr {

	private Map<String, String> erreurs  = new HashMap<String, String>();
	private String titre = "" ;
	private String filmeName ;
	private String contenu = "" ;
	private Long id  ;
	private News thenews = null ;
	private Collection<Categorie> listCats = new ArrayList<Categorie>();
	
	
	/**
	 * Ajout news
	 * @param request
	 * @return
	 */
	public boolean ajouterNews(  HttpServletRequest request   ){

		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		// début traitement par type input
		if (isMultipart){
			
			 FileItemFactory factory = new DiskFileItemFactory();
		     ServletFileUpload upload = new ServletFileUpload(factory);
			try{
				
				List<?> items = upload.parseRequest(request);
				Iterator<?> iterator = items.iterator();
				//----
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					if ( item.isFormField())
						inputs( item );
					else
						uploadImage( item  , request.getServletContext().getRealPath("/")  ) ;
				}
				
			}catch( FileUploadException e ){
				e.printStackTrace();
			}
			
		}
		// traitement général
		if ( this.getErreurs().isEmpty() ){
				
				if( this.listCats.size() == 0  ){
						CategorieDaoImpl catImpl = new CategorieDaoImpl();
						Categorie c = catImpl.findCategorieByName("unknown") ;
						listCats.add(c);
				}
				//date
				
				Calendar calendar = Calendar.getInstance();
				java.sql.Timestamp dateinscription = new java.sql.Timestamp(calendar.getTime().getTime());
				
				
				// Recherche du profil ajouteur 
				UserDaoImpl userImpl = new UserDaoImpl();
				User user = userImpl.findUser( Long.valueOf(1) ) ;

				// préparation de l'objet News
				News news = new News( titre , contenu , filmeName , dateinscription , listCats , user);
				
				NewsDaoImpl newsImpl = new NewsDaoImpl() ;
				newsImpl.creer(news);
				return true ;
				
		}
		return false ;
	}
	
	/**
	 * Get single news
	 * @param id
	 * @return
	 */
	public News getNews( String id ){
		
		if ( id.matches("\\d*")){
			
				NewsDaoImpl newsImpl = new NewsDaoImpl() ;
				News news = newsImpl.findNews( Long.valueOf(id).longValue() );
				
				if ( news != null ){
						return news ;
				}
		}
		return null ;
		
	}
	
	/**
	 * GET list news
	 * @return
	 */
	public List<News> getListNews(){
		
		//---
		NewsDaoImpl newsImpl = new NewsDaoImpl() ;
		return newsImpl.getNews() ;
	}
	
	
	/**
	 * Delete news
	 * @param request
	 * @return
	 */
	public boolean supprimerNews( HttpServletRequest request ){
		
		String id = getValeur( request , "id" );
		if ( id.matches("\\d*")){
			
				NewsDaoImpl NewsImpl = new NewsDaoImpl() ;
				News news = NewsImpl.findNews( Long.valueOf(id).longValue() );
	
				if ( news != null ){
						NewsImpl.supprimer(news);
						return true ;
				}
				else
						return false ;
		}
		
		return false ;
	}
	
	
	/**
	 * Update news
	 * @return
	 */
	public boolean modifierNews(  HttpServletRequest request  ){
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				
				// début traitement par type input
				if (isMultipart){
					
					 FileItemFactory factory = new DiskFileItemFactory();
				     ServletFileUpload upload = new ServletFileUpload(factory);
					try{
						
						List<?> items = upload.parseRequest(request);
						Iterator<?> iterator = items.iterator();
						//----
						while (iterator.hasNext()) {
							FileItem item = (FileItem) iterator.next();
							if ( item.isFormField())
								inputs( item );
							else
								uploadImage( item  , request.getServletContext().getRealPath("/")  ) ;
						}
						
					}catch( FileUploadException e ){
						e.printStackTrace();
					}
					
				}
				// traitement général
				if ( this.getErreurs().isEmpty() ){
						
						if( this.listCats.size() == 0  ){
								CategorieDaoImpl catImpl = new CategorieDaoImpl();
								Categorie c = catImpl.findCategorieByName("unknown") ;
								listCats.add(c);
						}
						//date
						
						Calendar calendar = Calendar.getInstance();
						java.sql.Timestamp dateinscription = new java.sql.Timestamp(calendar.getTime().getTime());
						
						
						// Recherche du profil ajouteur 
						HttpSession session 	= request.getSession() ;
						User user 				= (User) session.getAttribute("user") ;
		
						// préparation de l'objet News
						News news = new News( this.id , titre , contenu , filmeName , dateinscription , listCats , user);
						
						NewsDaoImpl newsImpl = new NewsDaoImpl() ;
						newsImpl.modifier(news);
						this.thenews = newsImpl.findNews(this.id) ;
						return true ;
						
				}
				return false ;
	}
	
	
	/**
	 * Get list news by category
	 * @param request
	 * @return
	 */
	public List<News> getListNewsByCat( HttpServletRequest request ){
		
		String avl = getValeur(request, "id" );
		NewsDaoImpl NewsImpl = new NewsDaoImpl() ;
		List<News> news = NewsImpl.getNewsByCategorie(Long.valueOf(avl).longValue());
		return news ;
		
	}
	
	/**
	 * get param from request
	 * @param request
	 * @param champ
	 * @return
	 */
    private static String getValeur( HttpServletRequest request, String champ ) {
        String valeur = request.getParameter( champ );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
	/**
	 * add error to error list
	 * @param champ
	 * @param message
	 */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    

    public News getTheNews(){
    	return this.thenews ;
    }
    
    /**
     * get error
     * @return
     */
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    /**
     * specific traitement to simple inputs types
     * @param item
     */
    public void inputs( FileItem item ) {
    	
    	String nfield = item.getFieldName() ;
    	
    	if ( nfield.equals("titre")  ){
    		
    		this.titre = item.getString();
    		try{
    			verifieTitle(  this.titre );
    		}catch( Exception e ){
    			setErreur("titre",  e.getMessage() );
    		}
    	}
    	if (  nfield.equals("contenu") ){
    		this.contenu = item.getString();
    	}
    	if (  nfield.equals("id")  ){
    		
    		this.id = Long.valueOf(item.getString()).longValue() ;
    	}
    	
    	if ( nfield.equals("categorie")  ){
    		
			CategorieDaoImpl catImpl = new CategorieDaoImpl();
			Categorie c  = catImpl.findCategorie( Long.valueOf( item.getString()).longValue() ) ;
			listCats.add( c ) ;			
    	}
    	

    	
    }
    
    /**
     * specific traitement to upload image
     * @param item
     * @param path
     */
    public void uploadImage( FileItem item , String path ){
    		
				// chemin + file 
    			if ( item.getName()  != ""  ){
    				
					File filepath = new File( path + File.separator + "uploads");
					
					if (!filepath.exists()) {
	                    filepath.mkdirs();
	                }
					
					if ( item.getSize() > 500000 )
						{
						setErreur("image" , "Tailler maximum d'upload dépassée . Veuillez choisir une image de taille <= 500 ko ");
						}
					System.out.println( item.getContentType() );
					if ( !item.getContentType().equals("image/png")  && !item.getContentType().equals("image/jpeg") )
						{
						setErreur("image" , "Only images !!");
						}
					
						String cleanName =  item.getName() ;
						
						File uploadedFile = new File( filepath + "/" + cleanName );
						try {
							item.write(uploadedFile);
							this.filmeName = cleanName ;
						} catch (Exception e) {
							setErreur("image" , "Erreur de l'upload du fichier ");
						}
					
    			}	
		
    }
    
    /**
     * Verifie title
     * @param t
     * @throws Exception
     */
    private void verifieTitle( String t  ) throws Exception{
    	
    	if (  t != null ){
    		if (  t.length() < 3 )
    			 throw new Exception( "Le titre doit contenir au moins 3 caractères." );
    	}
    	else
    		throw new Exception( "Merci de saisir un titre.");
    }
	
}

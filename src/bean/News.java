package bean;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class News {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id ;
	@Column
	String titre ;
	
	@Column(columnDefinition = "TEXT")
	String contenu ;
	
	@Column
	String image ;
	
	@Column
	java.sql.Timestamp dateAjout ;
	
	@ManyToMany(  cascade = CascadeType.ALL , fetch=FetchType.LAZY)
	private Collection<Categorie> categories;
	
	@OneToOne(  cascade = CascadeType.MERGE , fetch=FetchType.LAZY)
    private User user ;
	

	/**
	 * Constructeur utilisé lors de la création d'un article
	 * @param titre
	 * @param contenu
	 * @param image
	 * @param dateAjout
	 * @param categories
	 * @param user
	 */
	public News(String titre, String contenu, String image,
		Timestamp dateAjout, Collection<Categorie> categories, User user) {
		
		super();
		this.titre = titre			;
		this.contenu = contenu		;
		this.image = image			;
		this.dateAjout = dateAjout	;
		this.categories = categories;
		this.user = user			;
		
	}

	/**
	 * Constructeur utilisé lors de la mise à jour d'un article
	 * @param id
	 * @param titre
	 * @param contenu
	 * @param image
	 * @param dateAjout
	 * @param categories
	 * @param user
	 */
	public News(Long id , String titre, String contenu, String image,
			Timestamp dateAjout, Collection<Categorie> categories, User user) {
			
			super();
			this.id = id 				;
			this.titre = titre			;
			this.contenu = contenu		;
			this.image = image			;
			this.dateAjout = dateAjout	;
			this.categories = categories;
			this.user = user			;
			
			
		}
	
	/**
	 * un genti constructeur 
	 */
	News(){ super() ;}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Timestamp dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Categorie> categories) {
		this.categories.addAll(categories) ;
	}
	
	public void removeCats(){
		this.categories.clear();
	}

}

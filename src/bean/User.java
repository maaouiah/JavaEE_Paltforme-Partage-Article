package bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id ;
	
	@Column
	String nom ;
	
	@Column
	String pseudo ;
	
	@Column
	String motdepasse ;
	
	@Column
	String email ;
	
	@Column
	java.sql.Timestamp dateInscription ;
	
	public User(){
		super();
	}

	public User(long id, String nom, String pseudo, String motdepasse,
			String email, java.sql.Timestamp dateInscription) {
		super();
		this.id = id;
		this.nom = nom;
		this.pseudo = pseudo;
		this.motdepasse = motdepasse;
		this.email = email;
		this.dateInscription = dateInscription;
	}

	public User(String nom, String pseudo, String motdepasse,
			String email , java.sql.Timestamp dateinscription2 ) {
		super();
		this.nom = nom;
		this.pseudo = pseudo;
		this.motdepasse = motdepasse;
		this.email = email;
		this.dateInscription = dateinscription2;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public java.sql.Timestamp getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(java.sql.Timestamp dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

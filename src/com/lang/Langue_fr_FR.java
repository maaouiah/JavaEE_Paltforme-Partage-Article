package com.lang;

import java.util.ListResourceBundle;

public class Langue_fr_FR extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	
	static final Object[][] contents = {
		
		  {"action.update", "Mettre à jour"},
		  {"action.submit", "Ajouter"},
		  {"action.delete", "Supprimer"},
		  {"action.add", "Ajouter"},
		  {"app.home", "Accueil"},
		  
		  {"app.connect" , "Connexion" },
		  {"app.register" , "Inscription" },
		  {"app.logout" , "Déconnexion" },
		  {"app.profil" , "Mon profil"},
		  {"app.share" , "Nouveau article"},
		  {"app.allshare" , "Mes articles"},
		  {"app.start" , "Bonjour"},
		  {"app.account" , "Mon compte"},
		  
		  
		  {"login.title", "Connexion"},
		  {"login.label.password", "Mot de passe"},
		  {"login.label.email", "Adresse Email"},
		  {"login.button.submit", "connexion"},
		  
		  
		  {"register.title", "Inscription"},
		  {"register.label.nom", "Nom"},
		  {"register.label.username", "Pseudo"},
		  {"register.label.email", "Adresse email"},
		  {"register.label.password", "Mot de passe"},
		  {"register.button.submit", "S'inscrire"},
		  
		  {"cat.title", "Catégorie"},
		  {"cat.title.list", "Gérer les catégories"},
		  {"cat.add", "Ajouter une catégorie"},
		  {"cat.update", "Modifier la catégorie"},
		  {"cat.label.add", "Nom catégorie"},
		  
		  {"news.add", "Ajouter un article"},
		  {"news.update", "Mettre à jour"},
		  {"news.label.title", "Titre"},
		  {"news.label.contenu", "Contenu"},
		  {"news.label.image", "Image"},
		  {"news.title.list" , "Mes articles"},
		  {"news.title" , "Articles"},
		  {"news.readmore" , "Lire la suite"},
		  {"select.cats.for.news", "Veuillez choisir une ou plusieurs catégories, Vous pouvez  ajouter des nouvelles catégories"},
		  
		  
		  };
}

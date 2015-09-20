package com.lang;

import java.util.ListResourceBundle;

public class Langue_en_EN extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
		{"action.update", "Update"},
		  {"action.submit", "Submit"},
		  {"action.delete", "Delete"},
		  {"action.add", "ADD"},
		  {"app.home", "Home"},
		  
		  {"app.connect" , "Login" },
		  {"app.register" , "Register" },
		  {"app.logout" , "Logout" },
		  {"app.profil" , "My profil"},
		  {"app.share" , "New article"},
		  {"app.allshare" , "My articles"},
		  {"app.start" , "Hello"},
		  {"app.account" , "My account"},
		  
		  {"login.title", "Login"},
		  {"login.label.password", "Password"},
		  {"login.label.email", "Adresse Email"},
		  {"login.button.submit", "Login"},
		  
		  
		  {"register.title", "Register"},
		  {"register.label.nom", "Name"},
		  {"register.label.username", "User name"},
		  {"register.label.email", "Email adress"},
		  {"register.label.password", "Password"},
		  {"register.button.submit", "Register"},
		  
		  {"cat.title", "Categorys"},
		  {"cat.title.list", "Manage categorys"},
		  {"cat.add", "Add category"},
		  {"cat.update", "Update category"},
		  {"cat.label.add", "Name category"},
		  
		  {"news.add", "Add article"},
		  {"news.update", "Update article"},
		  {"news.label.title", "Title"},
		  {"news.label.contenu", "Content"},
		  {"news.label.image", "Image"},
		  {"news.title.list" , "My articles"},
		  {"news.title" , "News"},
		  {"news.readmore" , "Read more"},
		  {"select.cats.for.news", "Please, select one or many categorys. If the cotegory don't exist, you can add it"},
		  };
}

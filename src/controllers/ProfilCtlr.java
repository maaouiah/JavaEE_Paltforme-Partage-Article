package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.NewsDaoImpl;
import bean.News;
import bean.User;

public class ProfilCtlr {

	
	public List<News> mesArticles( HttpServletRequest request){
		
		NewsDaoImpl newsImpl 	= new NewsDaoImpl();
		HttpSession session 	= request.getSession() ;
		User user 				= (User) session.getAttribute("user") ;
		List<News> news = newsImpl.getNewsByUser( user );
		return news ;
		
	}
	
	public List<News> mesArticlesProfil( HttpServletRequest request){
		
		NewsDaoImpl newsImpl 	= new NewsDaoImpl();
		HttpSession session 	= request.getSession() ;
		User user 				= (User) session.getAttribute("user") ;
		List<News> news 		= newsImpl.getNewsByUserForProfil( user );
		return news ;
		
	}
	
	
}

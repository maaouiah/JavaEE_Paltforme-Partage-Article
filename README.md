Projet Master 2 (Java EE) : Projet Plates-formes pour le Développement Web
===================

###Sujet

J'ai réalisé une application permettant d'alimenter et de visualiser un fil d'articles rangés par  catégories. Un utilisateur devra être connecté sur le compte qu'il aura préalablement créé pour  pouvoir créer/modifier/supprimer un article. Un article aura les attributs suivants :
	• un titre ;

	• un corps ;

	• une (ou plusieurs) catégorie(s) ;

	• une image ;

	• un auteur ;

	• une date de création.

Un utilisateur anonyme (qui ne possède pas de compte) pourra : 
	• visualiser l'ensemble des articles (un aperçu de chaque article) par ordre anti-chronologique ;

	• visualiser les articles (un aperçu de chaque article) par catégorie et par ordre anti-chronologique ;

	• visualiser un article en particulier dans son intégralité (toutes les informations devront être affichées) ;

	• créer un compte.

Un utilisateur authentifié (qui possède un compte) pourra :
	• faire tout ce qu'un utilisateur anonyme peut faire ;

	• visualiser son profil constitué de quelques informations élémentaires ;

	• visualiser la liste des articles (un aperçu de chaque article) dont il est l'auteur ;

	• ajouter un article ;

	• modifier un article dont il est l'auteur ;

	• supprimer un article dont il est l'auteur.

###Implémentation

	• les vues de votre application sous la forme de pages JSP. Dans les pages JSP, la logique devra être réduite à son strict minimum et implémentée grâce à la bibliothèque de tags JSTL core ou JSTL Function ;

	• les contrôleurs de ces vues sous la forme de servlets grâce à l'interface de programmation servlet.api ;

	• un modèle composé de classes Java (beans) annotées pour l'accès à une base de données par le biais d'un mapping objet-relationnel grâce à l'interface de programmation JPA 2 ;

	• l'externalisation du code des en-tête et pied de page de votre site vers des pages JSP que vous appellerez dans vos pages JSP principales pour éviter la redondance ;

	• l'internationalisation de l'ensemble des textes de l'interface en français et en anglais par le biais de fichiers .properties grâce à la bibliothèque de tags JSTL fmt.

###Ressources
	• ensemble de bibliothèques de tags JSTL dont l'interface de programmation et son implémentation sont disponibles à l'adresse suivante : jstl.java.net/download.html

	• l'interface de programmation servlet-api que vous trouverez dans le répertoire /lib du conteneur Web Tomcat ;

	• la bibliothèque de tag JSP jsp-api que vous trouverez également dans le répertoire /lib du conteneur Web Tomcat ;

	• interface de programmation JPA 2 : openJPA, disponible au téléchargement à l'adresse suivante : openjpa.apache.org/downloads.html ;

	• un driver jdbc pour accéder à la base de données. Pour MySQL, disponible à l'adresse suivante : dev.mysql.com/downloads/connector/j/. Pour PostgreSQL, disponible à l'adresse suivante : jdbc.postgresql.org/download.html

	• la bibliothèque Apache Commons FileUpload disponible à l'adresse suivante : commons.apache.org/proper/commons-fileupload/download_fileupload.cgi ;

	• la bibliothèque Apache Commons FileUpload est dépendante de la bibliothèque Apache Commons IO disponible à l'adresse suivante : commons.apache.org/proper/commons-io/download_io.cgi.
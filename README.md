#Créez un site communautaire autour de l’escalade

##Projet 5 Parcours développeur d'application Java
###Prérequis
####Java
Installer java (version 11 du jdk disponible [ici](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html).
La suite du démarrage du projet suppose que vous ayez des notions en java et que vous soyez capable de démarrer un
 projet avec un IDE.
 
 ####Maven
 La version utilisé lors du développement du projet est la version 3.6.1. Maven est directement téléchargeable sur le
  site prévu à cet effet [ici](https://maven.apache.org/download.cgi).
  
  ####MYQSL
  La version de Mysql utilisé est la version 8.0.16 disponible directement sur le site de [mysql](https://www.mysql.com/fr/downloads/).
  Préférez la version community et disponible avec le workbench.
  
  Des tests ont également étés réalisé dans un environnement Linux (Manjaro) avec MariaDB (fork de mysql).
  
  ####Un IDE (Environnement de développement intégré)
  Enfin, vous devez avoir un IDE, j'utilise dans mon cas Intellij. Les exemples de démonstrations seront uniquement basé
  sur cet IDE. Aucun support ne sera fourni pour démarrer le projet sur un autre IDE. Merci de rechercher par vous même
  pour démarrer le projet via les lignes de commandes ou par le biais d'un autre IDE tel qu'Eclipse.
   
 ###Contexte : 
  
  L'expression du besoin est estimé à cette [addresse](https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DAJava_P6/Recueil+des+besoins+client+-+Amis+de+l'Escalade.pdf),
   merci de vous y référer.
   
   ###Travail demandé :
   Le travail demandé est celui d'un développeur, à savoir développer une solution pour un client.
   Les contraintes sont l'utilisateur d'une technologie backend java (Java EE) pour créer un site communautaire autour
   de l'escalade.
   
   ###Livrables fournis : 
   -    Code source de l'application
   -    Instructions SQL à rentrer dans la base de données avant le démarrage de l'application
   -    Modèle Physique de Données pour représenter les entités et leurs relations dans l'application.
   
   
   ###Lancement du projet.
   
   ####Prérequis 
   On est jamais trop prudent, entrez donc les commandes :
   
   ```java --version```
   
   ```mvn -version```
   
   ```mysql --version```
   
   Aucune de ces commandes ne doit renvoyer d'erreur.
   
   Connectez vous à votre espace Mysql (par défaut username: root et password: root).
   Exécutez l'instruction :
   
   ```create database openclassrooms_parcours_java_escalade```
   
   Créez un utilisateur ``openclassrooms`` avec le mot de passe ``openclassrooms``.
   
   Assurez vous de lui créer les droits sur la base ``openclassrooms_parcours_java_escalade``.
   Tentez de vous connecter pour vous assurer que la connexion est possible avec cet user.
   
   C'est bon? On passe à la suite alors : 
   
   Ouvrez votre IDE préféré (Intellij au hasard), et ouvrez le projet. Sur votre droite, vous verrez un champs Maven.
   Cliquez dessus et exécuté les instructions ``clean`` et ``install``.
   (ceci installera les dépendances pour le projet, dont spring boot, thymeleaf et spring security);
   
   Si aucune erreur n'est détecté, on peut passer à la suite. Sinon vous avez des problèmes (voir ci après).
   
   Si tout s'est bien passé, vous devriez pouvoir lancer l'application directement depuis la commande run d'Intellij. 
   
   Cliquez dessus et l'application démarre (la classe main est situé dans EscaladeApplication.java).
   
   Pour observer le résultat, rendez vous sur votre navigateur à l'adresse http://localhost:8000.
   
   ##Ça ne démarre pas !!!
   
   Si malgré tous vos efforts vous ne parvenez pas à lancer l'application, vérifiez tout d'abord la version utilisé
   pour java et maven (jdk 11 et maven 3.6.1).
   Vérifiez ensuite le path (le chemin) utilisé par votre IDE pour utiliser Java.
   
   Si besoin n'hésitez pas à me contacter à l'adresse ci dessous ci malgré vos efforts et votre tenacité vous ne
    parvenez pas à démarrer le projet.
   
   ##Copyright
   Ce projet est en licence libre, toutefois n'hésitez pas à ajouter une étoile à ce projet s'il vous a été utile.
   Vous pouvez également me contacter par mail à l'adresse [lehchibi.gael@gmail.com](mailto:lehchibi.gael@gmail.com).
   
   Merci.
   
   
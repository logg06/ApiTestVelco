# Api Test Velco

- Lancer un terminal et récupérer le projet depuis le repo GIT : 
	git clone https://github.com/logg06/ApiTestVelco.git

- Se placer dans le répertoire api
	cd api

- Exécuter la commande ./mvnw -e spring-boot:run pour démarrer l'application Spring Boot

- Importer dans Postman la collection API Velco.postman_collection.json située dans api/src/main/resources

- Exécuter les requêtes suivantes dans Postman :
	- POST (http://localhost:8888/api/json) : pour un affichage suivant l'ordre des références du fichier
	- POST sortBy price (http://localhost:8888/api/json?sortBy=price) : pour un tri d'ordre croissant suivant le prix des références contenues dans le fichier
	- POST sortBy size (http://localhost:8888/api/json?sortBy=size) : pour un tri d'ordre croissant suivant la taille des références contenues dans le fichier
	
Les requêtes ont comme BODY de type form-data un fichier à uploader (de key : "file" et de value le fichier à uploader) : deux exemples de fichiers sont disponibles dans src/main/resources
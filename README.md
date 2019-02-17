# Projet Java EE : Simple Online Ticketing

## BLANCHARD Dorian
## TRONCHE Arthur

### Fonctionnalités

Les fonctionnalités qui ont été implémentées sur ce projet sont :
- la présentation d’une liste d’évènements accessible sur la page d’accueil du site
- la présentation des détails d’un évènement
- la réservation des places pour un évènement
- l’ajout d’évènement par un utilisateur
- l’inscription d’un utilisateur
- la connexion et déconnexion d’un utilisateur
- l’accès d’un utilisateur à son profil

La visualisation de la liste des réservations pour un évènement et la possibilité à un utilisateur de voir ses réservations ont été partiellement implémenté mais ne sont pas fonctionnelles.

L’accès restreint au profil pour les visiteurs non connectés se fait avec un Filter qui redirige sur la page d’accueil.

### Difficultés

La création d’un système d’authentification a requis l’implémentation de plusieurs  concepts qui sont la gestions de la session d’un utilisateur, la vérification de la validité de la session et le protection de certaines ressources ainsi que la mise en place d’un système de hashage pour les mots de passe. La validation d’un utilisateur nécessite en effet de comparer des mots de passe chiffrés pour garder les mots de passe stockés secrets et irrécurrables.

La récupération des détails d’un évènement n’a pas été simple à implémenter. En effet, il a fallu créer un Servlet qui récupère un évènement depuis la base depuis l’id passé en paramètre de requête.

La gestion des erreurs est complexe et nécessite de faire attention à retourner les réponses adéquates aux différents cas qui peuvent survenir sans laisser de failles dans l’application.

La validation des champs d’un formulaire n’est pas complète, des classes de validation n’ont pas été implémentées.

La plupart des fonctionnalités sont longues à implémenter et demandent de nombreuses étapes pour être totalement fonctionnelles.

### Instructions pour l’installation

Pour lancer le projet, il faut utiliser le serveur d’applications Wildfly avec une base de données. Il n’y a pas d’initialisations de données nécessaires, tout peut être créé de base depuis l’application, il n’y a pas d’administrateur à créer puisque le système de rôles n’a pas été implémenté. 

Il faut vérifier que la stratégie de création des tables est bien en création dans le fichier “persistence.xml” pour pouvoir initialiser le schéma de la base.

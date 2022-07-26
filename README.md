# Roundtable

Cette application est un prototype de Roundtable permettant de suivre, visualiser, gérer les membres et les activités, etc.

## Fonctionnalités

- Parcourir l'ensemble des membres
  - Visualiser la liste des membres
  - Effectuer une recherche sur la liste des membres
  - Visualiser la fiche d'un membre
- Parcourir l'ensemble des articles
  - Visualiser la liste des articles
  - Effectuer une recherche sur la liste des articles
  - Visualiser la fiche d'un article
- Parcourir l'ensemble des outils
  - Visualiser la liste des outils
  - Visualiser la fiche d'un outil
- Parcourir l'ensemble des projets
  - Visualiser la liste des projets
  - Visualiser la fiche d'un projet
- Parcourir l'ensemble des intérêts
  - Visualiser les membres associés des intérêts
  - Visualiser les activités associés des intérêts
- Consulter ses notifications
- S'inscrire ou se désinscrire à un intérêt
- S'inscrire ou se désinscrire à une activité
- Modifier la liste des intérêts suivis
- Créer une activité (article/outil/projet)
  - Envoyer une notification
- Modifier une activité (article/outil/projet)
  - Envoyer une notification
- Fonctions spéciales pour les superviseurs:
  - Créer un intérêt
  - Modifier un intérêt
  - Supprimer un intérêt
- Fonctions spéciales pour les administrateurs:
  - Supprimer une activité (article/outil/projet)
  - Changer le statut d'un compte

## Manuel d'utilisation

Pour utiliser l'application, il vous faut exécuter la commande suivante: `java App`.
Étant un prototype, nous avons inclus un jeu de données afin de tester l'application.
À l'ouverture, vous devez vous connecter en tant que membre, superviseur ou administrateur. Ceci vous donnera accès au menu principal propre au rôle.

### Données incluses dans l'application

- Article (ID;titre;date de publication;statut;auteurs;mots-clés;intérêts liés)
  - A001;AST-Probe: Recovering abstract syntax trees;null;pret;Houari Sahraoui;pre-trained, abstract;machineLearning, softwareEngineering
  - A002;Promoting social diversity of MDE artifacts;null;brouillon;Houari Sahraoui;genetic, model-driven, diversity;softwareEngineering
  - A003;Real-time Collaborative Multi-Level Modeling;null;brouillon;Martin Weyssow;collaborative, model-driven, conflict-free;softwareEngineering
  - A004;Better Modeling the Programming World;2021-01-10;publie;Martin Weyssow;natural, identifiers, neural;domainModel
  - A005;DSMCompare: domain-specific model differencing;2022-01-07;publie;Mohammadamin Zaheri, Istvan David;software, DSMCompare, domain-specific;domainModel
- Outil (ID;nom;version;responsable;collaborateursl;mots-clés;intérêts liés)
  - O001;ATomPM;AToMPM;v0.9.0;Eugene Syriani;Oussama Sgxhaier, Martin Weyssow;graphical-editor,language-workbench;domainModel
  - O002;Gentleman;v0.4.0;Louis-Edouard Lafontant;Eugene Syriani;contextual, configurable, customizable;goalModeling
  - O003;ReLiS;v1.0;Eugene Syriani;Mohammadamin Zaheri, Istvan David;domain-specific-language, model-driven-engineering, conducting-systematic-reviews;goalModeling
  - O004;BiBler;v1.4.3;Martin Weyssow;Mouna Dhaouadi;references, UML, test-driven, agile;domainModel
  - O005;T-Core;v1.0;Houari Sahraoui;Martin Weyssow;domain-specific, custom-built, transformation;goalModeling
- Projet (ID;titre;date de début;date de fin;responsable;intérêts liés)
  - P001;Towards using Artificial Intelligence techniques;2019-09-01;2021-01-31;Houari Sahraoui;aiAssistance
  - P002;Articulating design-time uncertainty with DRUIDE;2020-06-012;2020-09-18;Eugene Syriani;modelEngineer, collaModel
  - P003;Multi-paradigm digital twin framework;2021-01-01;2023-12--31;Eugene Syriani;collaModel, modelEngineer
  - P004;Optimization of task sequencing and allocation;2021-01-01;2022-12-27;Eugene Syriani;collaModel, modelEngineer
  - P005;Semantic versioning of model changes;2021-03-01;2021-06-28;Houari Sahraoui;aiAssistance, goalModeling

### Connexion

Pour se connecter à l'application, veuillez utiliser un des identifiants suivants:

- Rôle du membre
  - email: oussama.ben.sghaier@iro.umontreal.ca | password: 111 | statut: VALIDE
  - email: mouna.dhaouadi@umontreal.ca | password: 8696 | statut: VALIDE
  - email: martin.weyssow@umontreal.ca | password: 7654 | statut: EN_ATTENTE
  - email: mohammadAmin.zaheri@umontreal.ca | password: 7897962 | statut: EN_ATTENTE
  - email: istvan.david@umontreal.ca | password: 35779 | statut: SUSPENDU
- Rôle du supervisuer
  - email: sahraoui@iro.umontreal.ca | password: 687846 | statut: VALIDE
  - email: syriani@iro.umontreal.ca | password: 6902342 | statut: VALIDE
- Rôle de l'administrateur
  - email: louis.edouard.lafontant@umontreal.ca | password: 78203 | statut: VALIDE

### Menu principal

À partir du menu principal, dans le rôle du membre, vous pouvez choisir l'une des options suivantes en tapant le chiffre correspondant.

- [1] Consulter un membre: Accédez à la liste des membres ou effectuer une recherche.
- [2] Consulter une activité: Accédez à la liste des activités.
- [3] Chercher une article: Effectuer une recherche des articles par le titre ou l'auteur ou les mots-clés.
- [4] Consulter un intérêt: Accédez à la liste des articles ou effectuer une recherche.
- [5] Ajouter une activité: Ajouter une activité 
- [6] Modifier une activité: Modifiez une activité dont je suis responsable.
- [7] Gérer la souscription: Accédez à la liste de vos inscriptions et ajouter, modifier ou supprimer une inscription.
- [8] Mon compte: Voir mes notifications.
- [9] Fonction spéciale: Pour le superviseur et l'administrateur.
- [0] Quitter

#### Gestion de mes activités

Dans cette section, vous pouvez accéder à vos activités en cours et passées, et en créer de nouvelles.
Suivez les instructions à l'écran pour compléter la tache.

- [a1] Créer un article | [a2] Modifier un article | [a3] Supprimer un article
- [o1] Créer un outil | [o2] Modifier un outil | [o3] Supprimer un outil
- [p1] Créer un projet | [p2] Modifier un projet | [p3] Supprimer un projet
- [4] Voir les activités en cours
- [5] Voir les activités suivies
- ...
- [0] Revenir au menu principal

### Menu principal (Superviseur)

### Menu principal (Administrateur)

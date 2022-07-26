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
- Membre (ID;prénom;nom de famille;numéro de téléphone;adresse courriel;titre;superviseur;intérêts
  - Pr001;Houari;Sahraoui;1990-01-13;sahraoui@iro.umontreal.ca;5148203842;professeur;null;goalModeling
  - Pr002;Eugene;Syriani;1994-10-06;syriani@iro.umontreal.ca;5143436111;professeur;null;collaModel
  - Ad001;Louis-Edouard;Lafontant;4389271920;louis.edouard.lafontant@umontreal.ca;professeur;Eugene Syriani
  - M001;Oussama;Sghaier;4389263336;oussama.ben.sghaier@iro.umontreal.ca;doctorat;Houari Sahraoui
  - M002;Mouna;Dhaouadi;4389672391;mouna.dhaouadi@umontreal.ca;doctorat;Eugene Syriani
  - M003;Martin;Weyssow;5148936934;martin.weyssow@umontreal.ca;doctorat;Houari Sahraoui
  - M004;Mohammadamin;Zaheri;5148240022;MohammadAmin.Zaheri@umontreal.ca;doctorat;Eugene Syriani
  - M005;Istvan;David;4380279389;istvan.david@umontreal.ca;doctorat;Eugene Syriani
- Compte (membre;adresse courriel;mot de passe;statut;role)
  - Oussama Sghaier;oussama.ben.sghaier@iro.umontreal.ca;111;valide;membre
  - Mouna Dhaouadi;MohammadAmin.Zaheri@umontreal.ca;8696;valide;membre
  - Martin Weyssow;martin.weyssow@umontreal.ca;7654;enAttente;membre
  - Mohammadamin Zaheri;MohammadAmin.Zaheri@umontreal.ca;7897962;enAttente;membre
  - Istvan David;istvan.david@umontreal.ca;35779;suspendu;membre
  - Houari Sahraoui;sahraoui@iro.umontreal.ca;687846;valide;superviseur
  - Eugene Syriani;syriani@iro.umontreal.ca;6902342;valide;superviseur
  - Louis-Edouard Lafontant;louis.edouard.lafontant@umontreal.ca;78203;valide;administrateur
### Connexion

Pour se connecter Ã  l'application, veuillez utiliser un des identifiants suivants:

- RÃ´le du membre
  - email: jessie.galasso-carbonnel@umontreal.ca | password: jessie#pass | statut: VALIDE
  - email: oussama.ben.sghaier@umontreal.ca | password: oussama#pass | statut: VALIDE
  - email: aurelien.ducoin@umontreal.ca | password: aurelien#pass | statut: SUSPENDU
  - email: meriem.ben.chaaben@umontreal.ca | password: meriem#pass | statut: EN_ATTENTE
- RÃ´le du supervisuer
  - email: syriani@iro.umontreal.ca | password: syriani#pass | statut: VALIDE
  - email: sahraouh@iro.umontreal.ca | password: sahraouh#pass | statut: EN_ATTENTE
- RÃ´le de l'administrateur
  - email: louis.edouard.lafontant@umontreal.ca | password: lelafontant#pass | statut: VALIDE

### Menu principal (Membre)

Ã€ partir du menu principal, dans le rÃ´le du membre, vous pouvez choisir l'une des options suivantes en tapant le chiffre correspondant.

- [1] Trouver un membre: AccÃ©dez Ã  la liste des membres ou effectuer une recherche.
- [2] Trouver un article: AccÃ©dez Ã  la liste des articles ou effectuer une recherche.
- [3] Trouver un outil: AccÃ©dez Ã  la liste des articles ou effectuer une recherche.
- [4] Trouver un projet: AccÃ©dez Ã  la liste des articles ou effectuer une recherche.
- [5] GÃ©rer mes activitÃ©s: AccÃ©dez Ã  la liste de vos activitÃ©s et ajouter, modifier ou supprimer une activitÃ©.
- [6] GÃ©rer mes inscriptions: AccÃ©dez Ã  la liste de vos inscriptions et ajouter, modifier ou supprimer une inscription.
- [7] Consulter mes notifications: Voir mes notifications
- ...
- [0] Quitter

#### Gestion de mes activitÃ©s

Dans cette section, vous pouvez accÃ©der Ã  vos activitÃ©s en cours et passÃ©es, et en crÃ©er de nouvelles.
Suivez les instructions Ã  l'Ã©cran pour complÃ©ter la tache.

- [a1] CrÃ©er un article | [a2] Modifier un article | [a3] Supprimer un article
- [o1] CrÃ©er un outil | [o2] Modifier un outil | [o3] Supprimer un outil
- [p1] CrÃ©er un projet | [p2] Modifier un projet | [p3] Supprimer un projet
- [4] Voir les activitÃ©s en cours
- [5] Voir les activitÃ©s suivies
- ...
- [0] Revenir au menu principal

### Menu principal (Superviseur)

### Menu principal (Administrateur)

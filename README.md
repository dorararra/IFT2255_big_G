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

- Article
  - A001;AST-Probe: Recovering abstract syntax trees;2022-06-23;prêt;houari;houari;##colla###;pre-trained language models, abstract syntax tree;machineLearning, softwareEngineering
  - A002;Promoting social diversity of MDE artifacts;2022-06-19;brouillon;houari;houari;mouna, istvan;Genetic programming, Model-driven engineering, Social diversity;softwareEngineering
  - A003;Real-time Collaborative Multi-Level Modeling;2021-03-23;brouillon;martin;martin, istvan;eugene;real-time collaborative solution, model-driven engineering, Conflict-free replicated data types;softwareEngineering
  - A004;Better Modeling the Programming World;2021-01-10;publie;houari;
- Outil
  - 000001;ATomPM;AToMPM (A Tool for Multi-Paradigm Modeling) is the modeling tool we are developing at the University of Montreal;...;graphical-editor,language-workbench;2
  - 000002;Gentleman;Gentleman is a lightweight web-based projectional editor that aims to make modeling more accessible to domain experts and practitioners;...;projectional-editing,mde;2
- Projet
  - 000001;From domain-specific languages to domain-specific environments;...;2021;2025;4;mde,ai;2,3
  - 000002;Artificial intelligence for and by software engineering;...;2018;2023;ai,code;1,2
- Membre
  - 202010250001;cortez;juan;1990-01-13;juan.cortez@gmail.com;5147836802
  - 202004280010;d;isabelle;1994-10-06;isa.hannoune@gmail.com;4382835821
- ...

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

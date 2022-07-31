import java.util.ArrayList;

public class RoundTable {

	public static void main(String[] args) {
        RepertoireEquipier repertoireEquipier = new RepertoireEquipier();
        RepertoireArticle repertoireArticle = new RepertoireArticle();
        RepertoireOutil repertoireOutil = new RepertoireOutil();
        RepertoireProjet repertoireProjet = new RepertoireProjet();

        ControleurEquipier controleurEquipier = new ControleurEquipier();
        ControleurActivite controleurActivite = new ControleurActivite();
        ControleurInteret controleurInteret = new ControleurInteret();
        ControleurCompte controleurCompte = new ControleurCompte();

        controleurEquipier.setRepertoire(repertoireEquipier);
        controleurActivite.setRepertoire(repertoireArticle,repertoireOutil,repertoireProjet);

            Superviseur eugene = new Superviseur("Pr002","Eugene","Syriani","5143436111","syriani@iro.umontreal.ca","http://www-ens.iro.umontreal.ca/~syriani/",Condition.professeur,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
            Superviseur houari = new Superviseur("Pr001", "Houari", "Sahraoui", "5148203842", "sahraoui@iro.umontreal.ca", "http://www.iro.umontreal.ca/~sahraouh/", Condition.professeur, new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
            Administrateur louisEdouard = new Administrateur("Ad001","Louis-Edouard","Lafontant","4389271920","louis.edouard.lafontant@umontreal.ca"," http://www-ens.iro.umontreal.ca/~lafontle/",Condition.professeur,eugene,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
            Membre oussama = new Membre("M001", "Oussama", "Sghaier", "4389263336", "oussama@gmail.com", "https://oussamasghaier.github.io/", Condition.doctorat, houari, new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
            Membre mouna = new Membre("M002", "Mouna", "Dhaouadi", "4389672391", "mouna.dhaouadi@umontreal.ca", " http://www-ens.iro.umontreal.ca/~dhaouadm/", Condition.doctorat, eugene, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            Membre martin = new Membre("M003", "Martin", "Weyssow", "5148936934", "martin.weyssow@umontreal.ca", "https://martin-wey.github.io/", Condition.doctorat, houari, new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
            Membre mohammadamin = new Membre("M004", "Mohammadamin", "Zaheri", "5148240022", "MohammadAmin.Zaheri@umontreal.ca", "http://zaheri.info/", Condition.doctorat, eugene, new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
            Membre istvan = new Membre("M005", "Istvan", "David", "4380279389", "istvan.david@umontreal.ca", "https://istvandavid.com/", Condition.doctorat, eugene, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

            controleurEquipier.ajouterMembre(eugene);
            controleurEquipier.ajouterMembre(houari);
            controleurEquipier.ajouterMembre(louisEdouard);
            controleurEquipier.ajouterMembre(oussama);
            controleurEquipier.ajouterMembre(mouna);
            controleurEquipier.ajouterMembre(martin);
            controleurEquipier.ajouterMembre(mohammadamin);
            controleurEquipier.ajouterMembre(istvan);



            Compte compteOussama = new Compte("oussama.ben.sghaier@iro.umontreal.ca", "111", CompteStatus.valide,oussama, Role.membre, "001");
        Compte compteMouna = new Compte("mouna.dhaouadi@umontreal.ca", "8696", CompteStatus.valide,mouna, Role.membre, "002");
        Compte compteMartin = new Compte("martin.weyssow@umontreal.ca", "7654", CompteStatus.enAttente,martin, Role.membre, "003");
        Compte compteMohammadamin = new Compte("mohammadAmin.zaheri@umontreal.ca", "7897962", CompteStatus.enAttente,mohammadamin, Role.membre, "004");
        Compte compteIstvan = new Compte("istvan.david@umontreal.ca", "35779", CompteStatus.suspendu,istvan, Role.membre, "005");
    //superviseur
        Compte compteHouari = new Compte("sahraoui@iro.umontreal.ca", "687846", CompteStatus.valide,houari, Role.superviseur, "101");
        Compte compteEugene = new Compte("syriani@iro.umontreal.ca","6902342",CompteStatus.valide,eugene,Role.superviseur,"102");
    //administrateur
        Compte compteLouisEdouard = new Compte("louis.edouard.lafontant@umontreal.ca","78203",CompteStatus.valide,louisEdouard, Role.administrateur,"201");

        controleurCompte.ajouterCompte(compteOussama);
        controleurCompte.ajouterCompte(compteMouna);
        controleurCompte.ajouterCompte(compteMartin);
        controleurCompte.ajouterCompte(compteMohammadamin);
        controleurCompte.ajouterCompte(compteIstvan);
        controleurCompte.ajouterCompte(compteHouari);
        controleurCompte.ajouterCompte(compteEugene);
        controleurCompte.ajouterCompte(compteLouisEdouard);




        Interet collaModel = new Interet("Collaborative modeling","The Collaboration Model reveals how the people in the user’s world communicate and coordinate to get activities done, often using technology. The Connection concept also highlights the transformation of life when this coordination can happen with necessary information ready to hand and when people can coordinate instantly to get things done when on the go.");
        Interet goalModeling = new Interet("Goal modeling"," UML's use case diagram provides a simple goal modeling notation. The bubbles name functional goals, so a Use case diagram forms a simple functions-only goal model: as Cockburn writes, use cases cover only the behavioral requirements. Roles are shown as actors (stickmen on the diagram), linked to the use cases in which they take part. The use cases are drawn as elliptical bubbles, representing desired behavioral goals");
        Interet modelEngineer = new Interet("Model-driven engineering","Model-driven engineering (MDE) is a software development methodology that focuses on creating and exploiting domain models, which are conceptual models of all the topics related to a specific problem. Hence, it highlights and aims at abstract representations of the knowledge and activities that govern a particular application domain, rather than the computing (i.e. algorithmic) concepts.");
        Interet aiAssistance = new Interet("AI-powered assistance","A virtual assistant, also called AI assistant or digital assistant, is an application program that understands natural language voice commands and completes tasks for the user.");
        Interet domainModel = new Interet("Domain-specific modeling","Domain-specific modeling (DSM) is a software engineering methodology for designing and developing systems, such as computer software. It involves systematic use of a domain-specific language to represent the various facets of a system.");
        Interet machineLearning = new Interet("Machine Learning"," A method of data analysis that automates analytical model building.");
        Interet softwareEngineering = new Interet("Software Engineering","The application of principles used in the field of engineering, which usually deals with physical systems, to the design, development, testing, deployment and management of software systems.");

        eugene.inscrireInteret(collaModel);
        collaModel.setMembreSouscrit(eugene);
        houari.inscrireInteret(goalModeling);
        goalModeling.setMembreSouscrit(houari);
        mohammadamin.inscrireInteret(aiAssistance);
        aiAssistance.setMembreSouscrit(mohammadamin);
        mohammadamin.inscrireInteret(modelEngineer);
        modelEngineer.setMembreSouscrit(mohammadamin);
        istvan.inscrireInteret(domainModel);
        domainModel.setMembreSouscrit(istvan);
        oussama.inscrireInteret(machineLearning);
        machineLearning.setMembreSouscrit(oussama);
        martin.inscrireInteret(softwareEngineering);
        softwareEngineering.setMembreSouscrit(martin);

        controleurInteret.ajouterInteret(collaModel);
        controleurInteret.ajouterInteret(goalModeling);
        controleurInteret.ajouterInteret(modelEngineer);
        controleurInteret.ajouterInteret(aiAssistance);
        controleurInteret.ajouterInteret(domainModel);
        controleurInteret.ajouterInteret(machineLearning);
        controleurInteret.ajouterInteret(softwareEngineering);

        Article article1 =  new Article("A001","AST-Probe: Recovering abstract syntax trees",
                "In our experimentations, we show that this syntactic subspace exists in five state-of-the-art" +
                        " pre-trained language models. Finally, we estimate the optimal size of this syntactic subspace" +
                        " and show that its dimension is substantially lower than those of the models' representation" +
                        " spaces. This suggests that pre-trained language models use a small part of their " +
                        "representation spaces to encode syntactic information of the programming languages.",
                " https://arxiv.org/abs/2206.11719","null",
                articleStatus.pret,houari,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        article1.addAuteur(houari);
        houari.inscrireActivite(article1);
        article1.addInteretsLie(machineLearning);
        machineLearning.setActiviteSouscrit(article1);
        article1.addInteretsLie(softwareEngineering);
        softwareEngineering.setActiviteSouscrit(article1);
        article1.addMotcles("pre-trained");
        article1.addMotcles("abstract");

        Article article2 = new Article("A002","Promoting social diversity of MDE artifacts",
                "Software modeling activities typically involve a tedious and time-consuming effort by " +
                        "specially trained personnel. This lack of automation hampers the adoption of model-driven " +
                        "engineering (MDE). Nevertheless, in the recent years, much research work has been dedicated" +
                        " to learn executable MDE artifacts instead of writing them manually.",
                "https://link.springer.com/article/10.1007/s10270-021-00969-9","null",articleStatus.brouillon,houari,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        article2.addAuteur(houari);
        houari.inscrireActivite(article2);
        article2.addCollaborateurs(mouna);
        mouna.inscrireActivite(article2);
        article2.addCollaborateurs(istvan);
        istvan.inscrireActivite(article2);
        article2.addInteretsLie(softwareEngineering);
        softwareEngineering.setActiviteSouscrit(article2);
        article2.addMotcles("genetic");
        article2.addMotcles("model-driven");
        article2.addMotcles("diversity");

        Article article3 = new Article("A003","Real-time Collaborative Multi-Level Modeling",
                "Conflict-free replicated data types (CRDT) provide scalable and robust replication mechanisms" +
                        " that align well with the requirements of real-time collaborative environments. " +
                        "In this paper, we propose a real-time collaborative multi-level modeling framework to support " +
                        "advanced modeling scenarios, built on a collection of custom CRDTs. We demonstrate the" +
                        " benefits of the framework through an illustrative modeling case and compare it with" +
                        " other state-of-the-art modeling frameworks.",
                "https://arxiv.org/abs/2205.11303","null",articleStatus.brouillon,martin,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        article3.addAuteur(martin);
        martin.inscrireActivite(article3);
        article3.addAuteur(istvan);
        istvan.inscrireActivite(article3);
        article3.addCollaborateurs(eugene);
        eugene.inscrireActivite(article3);
        article3.addInteretsLie(softwareEngineering);
        softwareEngineering.setActiviteSouscrit(article3);
        article3.addMotcles("collaborative");
        article3.addMotcles("model-driven");
        article3.addMotcles("conflict-free");

        Article article4 = new Article("A004","Better Modeling the Programming World",
                "In this paper, we investigate one of the underlying idea of our vision whose objective based " +
                        "on concept graphs of identifiers aims at leveraging high-level relationships between domain " +
                        "concepts manipulated through particular language constructs. In particular, we propose to " +
                        "enhance an existing pretrained language model of code by joint-learning it with a graph neural" +
                        " network based on our concept graphs.",
                "https://arxiv.org/abs/2201.03346","2021-01-10",
                articleStatus.publie,houari,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        article4.addAuteur(martin);
        martin.inscrireActivite(article4);
        article4.addInteretsLie(domainModel);
        domainModel.setActiviteSouscrit(article4);
        article4.addMotcles("natural");
        article4.addMotcles("identifiers");
        article4.addMotcles("neural");

        Article article5 = new Article("A005","DSMCompare: domain-specific model differencing",
                "There is a need to understand model differences in terms of the semantics of the modeling " +
                        "language. To address these issues, we propose a comprehensive approach—called DSMCompare—that " +
                        "considers both the abstract and the concrete syntax of a domain-specific language (DSL) " +
                        "when expressing model differences, and which supports defining domain-specific semantics for specific difference patterns.",
                "https://link.springer.com/article/10.1007/s10270-021-00971-1","2022-01-07",
                articleStatus.publie,eugene,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        article5.addAuteur(mohammadamin);
        mohammadamin.inscrireActivite(article5);
        article5.addAuteur(istvan);
        istvan.inscrireActivite(article5);
        article5.addCollaborateurs(martin);
        martin.inscrireActivite(article5);
        article5.addInteretsLie(domainModel);
        domainModel.setActiviteSouscrit(article5);
        article5.addMotcles("software");
        article5.addMotcles("DSMCompare");
        article5.addMotcles("domain-specific");

            Outil outil1 = new Outil("O001","AToMPM","AToMPM (A Tool for Multi-Paradigm Modeling)" +
                    " is the modeling tool we are developing at the University of Montreal in collaboration with " +
                    "McGill University, the University of Antwerp, and the University of Alabama. AToMPM provides" +
                    " facilities for generating web-based, domain-specific modeling tools that run on the cloud.",
                    "v0.9.0","https://github.com/AToMPM/atompm",eugene,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
            outil1.addCollaborateur(oussama);
            eugene.inscrireActivite(outil1);
            outil1.addInteretsLie(goalModeling);
            goalModeling.setActiviteSouscrit(outil1);
            outil1.addMotcles("modelling");
            outil1.addMotcles("abstract");
            outil1.addMotcles("concrete");



            Outil outil2 = new Outil("O002","Gentleman","Gentleman is a lightweight web-based projectional editor that aims to make modeling more accessible to domain experts and practitioners. In Gentleman, a model is structured using concepts and interacted with using projections (visuals). The editor is highly configurable to provide greater customization and deeper integration with an existing application.",
                    "v0.4.0"," https://github.com/geodes-sms/gentleman",louisEdouard,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
            outil2.addCollaborateur(eugene);
            eugene.inscrireActivite(outil2);
            outil2.addCollaborateur(martin);
            martin.inscrireActivite(outil2);
            outil2.addMotcles("contextual");
            outil2.addMotcles("configurable");
            outil2.addMotcles("customizable");
            outil2.addInteretsLie(goalModeling);
            goalModeling.setActiviteSouscrit(outil2);


            Outil outil3 = new Outil("O003","ReLiS","Conducting a systematic review involves many steps over a long period of time, and it is typically repetitive and labor-intensive. ReLiS (Revue Littéraire Systématique - Systematic Literature Review) can considerably reduce the effort of many of these steps by providing essential software support to reviewers. ReLiS supports planning, conducting and reporting a review, while following a previously defined process, which can be automatically adapted as the project evolves.",
                    "v1.0", "https://github.com/geodes-sms/relis",eugene,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
            outil3.addCollaborateur(mohammadamin);
            mohammadamin.inscrireActivite(outil3);
            outil3.addCollaborateur(istvan);
            istvan.inscrireActivite(outil3);
            outil3.addMotcles("domain-specific-language");
            outil3.addMotcles("model-driven-engineering");
            outil3.addMotcles("conducting-systematic-reviews");
            outil3.addInteretsLie(domainModel);
            domainModel.setActiviteSouscrit(outil3);


            Outil outil4 = new Outil("O004","BiBler","BiBler is a software for managing references to scientific articles using BibTeX. Not only is it a fully functional software, the tool has been entirely modeled and synthesized in Python. It is used for educational purposes in order to understand how to generate a complete application from UML models in an agile and test-driven environment.",
                    "v1.4.3","https://github.com/geodes-sms/bibler",martin,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
            outil4.addCollaborateur(mouna);
            mouna.inscrireActivite(outil4);
            outil4.addMotcles("references");
            outil4.addMotcles("UML");
            outil4.addMotcles("test-driven");
            outil4.addMotcles("agile");
            outil4.addInteretsLie(goalModeling);
            goalModeling.setActiviteSouscrit(outil4);


            Outil outil5 = new Outil("O005","T-Core","Py-T-Core is a Python implementation of T-Core. T-Core is a framework to build your own domain-specific, custom-built model transformation engines. It offers primitive transformation constructs that can be combined to define and encapsulate reusable model transformation idioms. The user can use existing transformation building blocks from an extensible library or define his own transformation units.",
                    "v1.0","https://github.com/geodes-sms/py-t-core",houari,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
            outil5.addCollaborateur(martin);
            martin.inscrireActivite(outil5);
            outil5.addMotcles("domain-specific");
            outil5.addMotcles("custom-built");
            outil5.addMotcles("transformation");
            outil5.addInteretLie(domainModel);
            domainModel.setActiviteSouscrit(outil5);

        Projet projet1 = new Projet("P001","Towards using Artificial Intelligence techniques",
                "Quality-driven multi-objective optimization approach for metamodel refactoring.","2019-09-01","2021-01-31",houari,new ArrayList<>());
        projet1.addInteretsLie(aiAssistance);
        aiAssistance.setActiviteSouscrit(projet1);

        Projet projet2 = new Projet("P002","Articulating design-time uncertainty with DRUIDE","Dans cette thèse, nous prenons des pas pour combler cette lacune en proposant de créer un langage de modélisation d’incertitude et une approche pour articuler l’incertitude au moment de la conception. Nous illustrons notre proposition sur un exemple et l’évaluons non seulement sur deux scénarios d’ingénierie logicielle, mais aussi sur une étude de cas réel basée sur les incertitudes causées par la pandémie COVID-19.",
             "2020-06-01","2020-09-18",eugene,new ArrayList<>());
        projet2.addInteretsLie(modelEngineer);
        modelEngineer.setActiviteSouscrit(projet2);
        projet2.addInteretsLie(collaModel);
        collaModel.setActiviteSouscrit(projet2);

        Projet projet3 = new Projet("P003","Multi-paradigm digital twin framework",
              "Inappropriate food autonomy poses serious threats to the sustainable development of Canada and the global society in general. This issue is further exacerbated by the four-season climate of Quebec that prevents year-round open-air farming. The framework achieves this by supporting various simulators and machine learning components and orchestrating them appropriately.The project is carried out in collaboration with Ferme d'Hiver.",
              "2021-01-01","2023-12--31",eugene,new ArrayList<>());
        projet3.addInteretsLie(collaModel);
        collaModel.setActiviteSouscrit(projet3);
        projet3.addInteretsLie(modelEngineer);
        modelEngineer.setActiviteSouscrit(projet3);

        Projet projet4 = new Projet("P004","Optimization of task sequencing and allocation","Nowadays, software projects are no longer isolated but drive the business process of many non-IT companies. In this project, we aim to deliver a computer-aided optimization solution. We formalize the underlying information and develop a simulation-based optimization technique. The results will elevate the project/resource planning maturity of the partner organization and, as a consequence, directly impact the time, cost, and quality of their projects.",
               "2021-01-01","2022-12-27",eugene,new ArrayList<>());
        projet4.addInteretsLie(collaModel);
        collaModel.setActiviteSouscrit(projet4);
        projet4.addInteretsLie(modelEngineer);
        modelEngineer.setActiviteSouscrit(projet4);

        Projet projet5 = new Projet("P005","Semantic versioning of model changes","Nowadays, almost any company in Canada in operation heavily relies on software solutions to improve their productivity. Decision support systems (DSS) help enterprises to take significant business decisions, such as finding the best software solution.We employ on advanced software engineering techniques to take into account the semantical changes that may occur and report them in a meaningful way to the user.",
              "2021-03-01","2021-06-28",houari,new ArrayList<>());
        projet5.addInteretsLie(aiAssistance);
        aiAssistance.setActiviteSouscrit(projet5);
        projet5.addInteretsLie(goalModeling);
        goalModeling.setActiviteSouscrit(projet5);

        controleurActivite.ajouteArticle(article1);
        controleurActivite.ajouteArticle(article2);
        controleurActivite.ajouteArticle(article3);
        controleurActivite.ajouteArticle(article4);
        controleurActivite.ajouteArticle(article5);
        controleurActivite.ajouteOutil(outil1);
        controleurActivite.ajouteOutil(outil2);
        controleurActivite.ajouteOutil(outil3);
        controleurActivite.ajouteOutil(outil4);
        controleurActivite.ajouteOutil(outil5);

        controleurActivite.ajouteProjet(projet1);
        controleurActivite.ajouteProjet(projet2);
        controleurActivite.ajouteProjet(projet3);
        controleurActivite.ajouteProjet(projet4);
        controleurActivite.ajouteProjet(projet5);

        /*


        */
       Notification notification1 = new Notification("lllll",article1,mouna,"this is a notification",
               "2021-01-10");
       oussama.addNotification(notification1);

            /*


             */

        repertoireEquipier.getEquipier();

        Menu menu = new Menu(controleurEquipier, controleurActivite, controleurInteret, controleurCompte);
        int resultLogin = menu.loginMenu();
    }
}
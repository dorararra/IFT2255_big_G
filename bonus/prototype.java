import java.util.Scanner;

public class prototype {
    public void main_menu(){
        System.out.println("\n");
        System.out.println("------Main Menu -------");
		System.out.println("\n");
        System.out.println("\n");
        System.out.println("1. Consulter un membre");
        System.out.println('\n');
        System.out.println("2. Consulter une activité par liste");
        System.out.println('\n');
        System.out.println("3. Chercher une activité");
        System.out.println('\n');
        System.out.println("4. Consulter une activité je participe");
        System.out.println('\n');
        System.out.println("5. Consulter un intérêt");
        System.out.println('\n');
        System.out.println("6. Gestion activité");
        System.out.println('\n');
        System.out.println("7. Gestion souscription");
        System.out.println('\n');
        System.out.println("8. Gestion Membre");
        System.out.println('\n');
        System.out.println("9. Gestion intérêt");
        System.out.println('\n');
        System.out.println("10. Mon compte");
        System.out.println('\n');
        System.out.println("11. Quitter");
        System.out.println('\n');
        System.out.println('\n');
        Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch (i) {
		case 1: 
            consulter_membre();
        break;
        case 2: 
            consulter_activite();
        break;      
        case 3: 
            chercher_activite();    
            break;
        case 4: 
            System.out.println("Vous ne participez à aucun activité...");
            break;
        case 5: 
        System.out.println("À bientôt");
        break;
        case 6:
        System.out.println("À bientôt");
        break;
        case 7:
        System.out.println("À bientôt");
        break;
        case 8:
        System.out.println("À bientôt");
        break;
        case 9:
        System.out.println("À bientôt");
        break;
        case 10:
        System.out.println("À bientôt");
        break;
        case 11:
        break;
    }
    if(i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10){
        System.out.println("Tapez 0 pour retourner au menu principal");
        Scanner sc1_21 = new Scanner(System.in);
        int i1_21 = sc1_21.nextInt();
        if(i1_21 == 0){
            main_menu();
    }
        
    }

        
           
    
}
        
    
    public void consulter_membre(){
        System.out.println("\n");
        System.out.println("-----Consulter un membre-----");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("1. Afficher la liste");
        System.out.println("\n");
        System.out.println("2. Chercher par son nom complet");
        System.out.println("\n");
        System.out.println("3. Retourner au menu principal");
        System.out.println("\n");
        System.out.println("4. Quitter");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("-------------------------");
        Scanner sc1 = new Scanner(System.in);
        int i1 = sc1.nextInt();
        switch(i1) {
        case 1:
            membre_list();
            break;
        case 2:
            nom_complet();                   
            break;
                
        case 3:
            main_menu();
        case 4:
        break;
    }
        if(i1!= 4){
            System.out.println("Tapez 0 pour retourner au menu principal");
            Scanner sc1_21 = new Scanner(System.in);
            int i1_21 = sc1_21.nextInt();
            if(i1_21 == 0){
                main_menu();
        }
        }
}
    public void membre_list(){
        System.out.println("****** NOM ******   ******ADRESSE COURRIEL******         ******INTÉRÊT******");
        System.out.println("Oussama Ben Sghaier oussama.ben.sghaier@iro.umontreal.ca Machine Learning, Natural Language Processing techniques");
        System.out.println("Barbara Nerissa     BarbaraNerissa@outlook.com           Goal modeling  Product linesCollaborative modeling");
        System.out.println("Oswald Gerard       mythOswaldGerard@hotmail.com         Design-time uncertainty Code synthesisModel transformations");
        System.out.println("\n");
        
    }
    public void nom_complet(){
        System.out.println("Entrez le nom complet:");
        Scanner sc1_2 = new Scanner(System.in);
        String complet_nom = sc1_2.nextLine().toLowerCase();
        if(complet_nom.equals("Oussama Ben Sghaier".toLowerCase())){
            System.out.println("Nom Complet:Oussama Ben Sghaier\nTéléphone:(438) 926-3336\n Adresse courriel:oussama.ben.sghaier@iro.umontreal.ca");
            System.out.println("Intérêt:Design-time uncertainty Code synthesisModel transformations");
            System.out.println("derniers articles:*");
            System.out.println("projets publics:*");
            System.out.println("Outils publics");
            System.out.println("\n");
            }
        else if(complet_nom.equals("Barbara Nerissa".toLowerCase())){
            System.out.println("Nom Complet:Barbara Nerissa\nTéléphone:*\nAdresse courriel:BarbaraNerissa@outlook.com");
            System.out.println("Intérêt:Goal modeling  Product linesCollaborative modeling");
            System.out.println("derniers articles:*");
            System.out.println("projets publics:*");
            System.out.println("Outils publics");
            System.out.println("\n");
        }
        else if(complet_nom.equals("Oswald Gerard".toLowerCase())){
            System.out.println("Nom Complet:Oswald Gerard\nTéléphone:*\nAdresse courriel:mythOswaldGerard@hotmail.com");
            System.out.println("Intérêt:Goal modeling  Product linesCollaborative modeling");
            System.out.println("derniers articles:*");
            System.out.println("projets publics:*");
            System.out.println("Outils publics");
            System.out.println("\n");
    }
        else {System.out.println("Rien à afficher");}
            
        
}
    public void consulter_activite(){
        System.out.println("\n");
        System.out.println("-----Consulter une activité par liste-----");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("1. Article");
        System.out.println("\n");
        System.out.println("2. Projet");
        System.out.println("\n");
        System.out.println("3. Outil");
        System.out.println("\n");
        System.out.println("4. Retourner au menu principal");
        System.out.println("\n");
        System.out.println("5. Quitter");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("-------------------------");
        Scanner sc1_2 = new Scanner(System.in);
        int i1_2 = sc1_2.nextInt();
        switch(i1_2) {
            case 1:
            System.out.println("-----Article-----");
            System.out.println("1.*\n2.*\n3.*\n4.*\n5.*\n");
            break;
            case 2:
            System.out.println("-----Projet-----");
            System.out.println("1.*\n2.*\n3.*\n4.*\n5.*\n");
            break;
            case 3:
            System.out.println("-----Outil-----");
            System.out.println("1.*\n2.*\n3.*\n4.*\n5.*\n");
            break;
            case 4:
            main_menu();
            case 5:
            break;
        }
            if(i1_2!=5){
            System.out.println("Tapez 0 pour retourner au menu principal");
            Scanner sc1_21 = new Scanner(System.in);
            int i1_21 = sc1_21.nextInt();
            if(i1_21 == 0){
                main_menu();
            }
}

    }

    public void chercher_activite(){
        System.out.println("\n");
        System.out.println("-----Chercher une activité-----");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("1. Article");
        System.out.println("\n");
        System.out.println("2. Projet");
        System.out.println("\n");
        System.out.println("4. Retourner au menu principal");
        System.out.println("\n");
        System.out.println("5. Quitter");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("-------------------------");
        Scanner sc3 = new Scanner(System.in);
        int i3 = sc3.nextInt();
        switch(i3){
            case 1:
            System.out.println("Entrez titre,auteur ou mot-clé de l'article:");
            Scanner sc31 = new Scanner(System.in);
            String answer1 = sc31.nextLine();
            System.out.println("Rien à afficher");
            break;
            case 2:
            System.out.println("Entrez responsable du projet:");
            Scanner sc32 = new Scanner(System.in);
            String answer2 = sc32.nextLine();
            System.out.println("Rien à afficher");
            break;
            case 3:
            main_menu();
            case 4:
            break;
            }
            System.out.println("Tapez 0 pour retourner au menu principal");
            Scanner sc1_1 = new Scanner(System.in);
                int i3_3 = sc1_1.nextInt();
                if(i3_3 == 0){
                    main_menu();
                }
    }
    

	public static void main(String[] args) {
        prototype person = new prototype();
		person.main_menu();
    }
    }

	
            
		



import java.util.Scanner;
import java.util.ArrayList;
import entities.ArticleConfection;
import entities.Categorie;
import entities.Unite;
import services.ArticleConfectionServiceImpl;

import services.CategorieServiceImpl;

import services.UniteServiceImpl;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner scanner = new Scanner(System.in);
        CategorieServiceImpl categorieService = new CategorieServiceImpl();
        UniteServiceImpl uniteService = new UniteServiceImpl(); 
        ArticleConfectionServiceImpl articleConfection = new ArticleConfectionServiceImpl();
        clearScreen();
        do {
            System.out.println("\nMenu Principal");
            System.out.println("1- Gérer les catégories");
            System.out.println("2- Gérer les unités");
            System.out.println("3- Gérer les articles de confections");
            System.out.println("3- Quitter");
            choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                 
                    gestionCategories(categorieService, scanner);
                    break;
                case 2:
                    
                    gestionUnites(uniteService, scanner);
                    break;
                case 3:
                    gestionArticlesConfection(articleConfection,categorieService,uniteService,scanner);
                    System.out.println("Au revoir !");
                    break;
                default:
                    clearScreen();
                    System.out.println("Option invalide !");
                    
                    break;
            }
        } while (choix != 3);

        scanner.close();
    }


    private static void gestionCategories(CategorieServiceImpl categorieService, Scanner scanner) {
        int categorieChoix;
        clearScreen();
        do {
            System.out.println("\nMenu Catégories");
            System.out.println("1- Ajouter catégorie");
            System.out.println("2- Lister catégories");
            System.out.println("3- Modifier catégorie");
            System.out.println("4- Supprimer une catégorie");
            System.out.println("5- Supprimer plusieurs catégories");
            System.out.println("6- Rechercher une catégorie");
            System.out.println("7- Retour au menu principal");
            categorieChoix = scanner.nextInt();
            scanner.nextLine();

            switch (categorieChoix) {
                case 1:
                    clearScreen();
                    System.out.println("Entrer le libellé :");
                    String libelle = scanner.nextLine();
                    Categorie categorie = new Categorie(libelle);
                    categorieService.add(categorie);
                    clearScreen();
                    System.out.println("Catégorie ajoutée avec succès !");
                    break;
                case 2:
                    clearScreen();
                    categorieService.getAll().forEach(System.out::println);
                    break;
                case 3:
                    clearScreen();
                    categorieService.getAll().forEach(System.out::println);
                    System.out.println("\nEntrer l'ID de la catégorie à mettre à jour :");
                    int categorieId = scanner.nextInt();
                    scanner.nextLine(); 
                    Categorie categorieToUpdate = categorieService.show(categorieId);
                    if (categorieToUpdate != null) {
                        System.out.println("Entrer le nouveau libellé :");
                        String newLibelle = scanner.nextLine();
                        categorieToUpdate.setLibelle(newLibelle);
                        categorieService.update(categorieToUpdate);
                        clearScreen();
                        System.out.println("Catégorie mise à jour avec succès !");
                    } else {
                        clearScreen();
                        System.out.println("Catégorie non trouvée !");
                    }
                    break;
                case 4:
                    clearScreen();
                    categorieService.getAll().forEach(System.out::println);
                    System.out.println("\nEntrer l'ID de la catégorie à supprimer :");
                    int categorieIdToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    int result = categorieService.remove(categorieIdToDelete);
                    if (result == 1) {
                        clearScreen();
                        System.out.println("Catégorie supprimée avec succès !");
                    } else {
                        clearScreen();
                        System.out.println("Catégorie non trouvée !");
                    }
                    break;
                case 5:
                    clearScreen();
                    categorieService.getAll().forEach(System.out::println);
                    System.out.println("\nEntrer les IDs des catégories à supprimer (séparés par des virgules) :");
                    String categoriesToDelete = scanner.nextLine();
                    String[] idsToDelete = categoriesToDelete.split(",");
                    int[] idsArray = new int[idsToDelete.length];
                    for (int i = 0; i < idsToDelete.length; i++) {
                        idsArray[i] = Integer.parseInt(idsToDelete[i].trim());
                    }
                    categorieService.remove(idsArray);
                    clearScreen();
                    System.out.println( " Catégories supprimées avec succès !");
                    break;
                case 6:
                    clearScreen();
                    categorieService.getAll().forEach(System.out::println);
                    System.out.println("\nEntrer l'ID de la catégorie à rechercher :");
                    int categorieIdToSearch = scanner.nextInt();
                    scanner.nextLine();
                    Categorie categorieToSearch = categorieService.show(categorieIdToSearch);
                    if (categorieToSearch != null) {
                        clearScreen();
                        System.out.println("\n[Categorie number:"+ categorieToSearch.getId() + " libelle :" + categorieToSearch.getLibelle() + "]");
                    } else {
                        clearScreen();
                        System.out.println("Catégorie non trouvée !");
                    }
                    break;
                case 7:
                    clearScreen();
                    break;
                default:
                    System.out.println("Option invalide !");
                    break;
            }
        } while (categorieChoix != 7);
    }

    private static void gestionUnites(UniteServiceImpl uniteService, Scanner scanner) {

        int uniteChoix;
        clearScreen();
        do {
            
            System.out.println("Menu Unités");
            System.out.println("1- Ajouter unité");
            System.out.println("2- Lister unités");
            System.out.println("3- Modifier une unité");
            System.out.println("4- Supprimer une unité");
            System.out.println("5- Supprimer plusieurs unités");
            System.out.println("6- Retour au menu principal");
            uniteChoix = scanner.nextInt();
            scanner.nextLine();

            switch (uniteChoix) {
                case 1:
                    clearScreen();
                    System.out.println("Entrer le libellé");
                    String libelle = scanner.nextLine();
                    Unite unite = new Unite(libelle);
                    uniteService.add(unite);
                    System.out.println("Unité ajoutée avec succès !");
                    break;
                case 2:
                    System.out.println("Liste des unités :");
                    uniteService.getAll().forEach(System.out::println);
                    break;
                case 3:
                    uniteService.getAll().forEach(System.out::println);
                    System.out.println("\nEntrer l'ID de la unité à mettre à jour :");
                    int uniteId = scanner.nextInt();
                    scanner.nextLine(); 
                    Unite uniteToUpdate = uniteService.show(uniteId);
                    if (uniteToUpdate != null) {
                        System.out.println("Entrer le nouveau libellé :");
                        String newLibelle = scanner.nextLine();
                        uniteToUpdate.setLibelle(newLibelle);
                        uniteService.update(uniteToUpdate);
                        System.out.println("Unité mise à jour avec succès !");
                    } else {
                        System.out.println("Unité non trouvée !");
                    }
                    break;
                case 4:
                    uniteService.getAll().forEach(System.out::println);
                    System.out.println("\nEntrer l'ID de la unité à supprimer :");
                    int uniteIdToDelete = scanner.nextInt();
                    scanner.nextLine(); 
                    int result = uniteService.remove(uniteIdToDelete);
                    if (result == 1) {
                        System.out.println("Unité supprimée avec succès !");
                    } else {
                        System.out.println("Unité non trouvée !");
                    }
                    break;
                case 5:
                    uniteService.getAll().forEach(System.out::println);
                    System.out.println("\nEntrer les IDs des unités à supprimer (séparés par des virgules) :");
                    String unitesToDelete = scanner.nextLine();
                    String[] idsToDelete = unitesToDelete.split(",");
                    int[] idsArray = new int[idsToDelete.length];
                    for (int i = 0; i < idsToDelete.length; i++) {
                        idsArray[i] = Integer.parseInt(idsToDelete[i].trim());
                    }
                    uniteService.remove(idsArray);
                    System.out.println( "Liste d'unités supprimées avec succès !");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Option invalide !");
                    break;
            }
        } while (uniteChoix != 6);
    }


    private static void gestionArticlesConfection(ArticleConfectionServiceImpl articleConfection,CategorieServiceImpl categorieService,UniteServiceImpl uniteService,Scanner scanner) {
    int articleChoix;
    clearScreen();
    do {
        System.out.println("\nMenu Articles de Confection");
        System.out.println("1- Ajouter article");
        System.out.println("2- Lister articles");
        System.out.println("3- Modifier un article");
        System.out.println("4- Supprimer un article");
        System.out.println("5- Supprimer plusieurs articles");
        System.out.println("6- Rechercher un article");
        System.out.println("7- Retour au menu principal");
        articleChoix = scanner.nextInt();
        scanner.nextLine();

        switch (articleChoix) {
            case 1:
            clearScreen();
            System.out.println("Entrer le libellé de l'article :");
            String libelleArticle = scanner.nextLine();
            System.out.println("Entrer le prix de l'article :");
            double prixArticle = scanner.nextDouble();
            System.out.println("Entrer la quantité de l'article :");
            double qteArticle = scanner.nextDouble();
            scanner.nextLine(); 
        
           
            System.out.println("Liste des catégories :");
            categorieService.getAll().forEach(System.out::println);
            System.out.println("Entrez l'ID de la catégorie de l'article :");
            int categorieIdArticle = scanner.nextInt();
            scanner.nextLine(); 
        
            
            System.out.println("Liste des unités :");
            ArrayList<Unite> unites = uniteService.getAll();
            for (Unite uni : unites) {
                System.out.println("[Unité number:" + uni.getId() + " libelle :" + uni.getLibelle() + "]");
            }
            System.out.println("Entrez l'ID de l'unité de l'article :");
            int uniteIdArticle = scanner.nextInt();
            scanner.nextLine(); 
        
            
            Categorie categorieArticle = categorieService.show(categorieIdArticle);
            Unite uniteArticle = uniteService.show(uniteIdArticle);
            ArticleConfection article = new ArticleConfection(libelleArticle, prixArticle, qteArticle, categorieArticle, uniteArticle);
            articleConfection.add(article);
            clearScreen();
            System.out.println("Article ajouté avec succès !");
            break;
        

            case 2 :
                articleConfection.getAll().forEach(System.out::println);
                break;


            
            case 7:
                clearScreen();
                break;
            default:
                System.out.println("Option invalide !");
                break;
        }
    } while (articleChoix != 7);
}
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

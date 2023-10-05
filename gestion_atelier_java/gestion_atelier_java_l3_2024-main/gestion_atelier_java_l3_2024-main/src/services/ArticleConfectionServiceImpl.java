package services;

import java.util.ArrayList;
import entities.ArticleConfection;
import repositories.list.TableArticleConfections;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {

   private TableArticleConfections articleRepository = new TableArticleConfections();

   public int add(ArticleConfection article) {
       return articleRepository.insert(article);
   }

   public ArrayList<ArticleConfection> getAll() {
       return articleRepository.findAll();
   }

   public int update(ArticleConfection article) {
       return articleRepository.update(article);
   }

   public ArticleConfection show(int id) {
       return articleRepository.findById(id);
   }

   public int remove(int id) {
       return articleRepository.delete(id);
   }

   public int[] remove(int[] ids) {
       int[] idsNotDelete = new int[ids.length];
       int nbre = 0;
       for (int id : ids) {
           if (articleRepository.delete(id) == 0) {
               idsNotDelete[nbre++] = id;
           }
       }
       return idsNotDelete;
   }
}

package services;

import java.util.ArrayList;

public interface IService<BAILA> {
      int  add(BAILA data);
     ArrayList<BAILA> getAll();

       int update(BAILA data);
       BAILA show(int id);
       int remove(int id);
       int[] remove(int[] ids);
}

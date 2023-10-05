package services;

import java.util.ArrayList;
import entities.Unite;
import repositories.list.TableUnites;

public class UniteServiceImpl implements UniteService {

    private TableUnites unitesRepository = new TableUnites();

    public int add(Unite unite) {
        return unitesRepository.insert(unite);
    }

        @Override
    public Unite show(int id) {
        return unitesRepository.findById(id);
    }


    public ArrayList<Unite> getAll() {
        return unitesRepository.findAll();
    }

    public int update(Unite unite) {
        return unitesRepository.update(unite);
    }

    public int remove(int id) {
        return unitesRepository.delete(id);
    }

    public int[] remove(int[] ids) {
        int[] idsNotDelete = new int[ids.length];
        int nbre = 0;
        for (int id = 0; id < ids.length; id++) {
            if (unitesRepository.delete(ids[id]) == 0) {
                idsNotDelete[nbre++] = ids[id];
            }
        }
        return idsNotDelete;
    }

}
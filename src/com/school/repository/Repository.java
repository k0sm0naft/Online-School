package com.school.repository;

import com.school.Main;
import com.school.models.Model;

import static java.lang.System.arraycopy;

public class Repository {
    private static Model[] repository = new Model[getSTANDART_INIT_CAPACITY()];
    private static final int STANDART_INIT_CAPACITY = 5;

    public static Model[] getAll() {
        return repository;
    }

    /**
     * Method to add new object in repository
     */
    public static void add(Model model) {
        for (int i = 0; i <= repository.length; i++) {
            if (i == repository.length) {
                repository = increaseCapacity(repository);
            }
            if (repository[i] == null){
            repository[i] = model;
            break;
            }
        }
    }

    public static void add(Model model, Model[] repo) {
        for (int i = 0; i < repo.length; i++) {
            if (repo[i] != null) continue;
            repo[i] = model;
            break;
        }
    }


    /**
     * Method to increase capacity of array
     */
    public static Model[] increaseCapacity(Model[] repo) {
        int newCapacity = (repo.length * 3) / 2 + 1;
        Model[] tmpArr = new Model[newCapacity];
        arraycopy(repo, 0, tmpArr, 0, repo.length);
        repo = tmpArr;
        return repo;
    }

    public static void getById(long ID, Model[] repository) {
        int i = 0;
        for (Model model : repository) {
            i++;
            if (model == null)continue;
            if (ID == model.getID()) {
                System.out.println(model);
                break;
            }
        }
        if (i == repository.length) System.out.println("Об'єкта з ID №" + ID + " не існує");

    }

    public static void deleteById(long ID, Model[] repository) {
        for (int i = 0; i <= repository.length; i++) {
            if (i == repository.length) {
                System.out.println("ID не існує.");
                break;
            }
            if (repository[i] == null)continue;
            if (ID == repository[i].getID()) {
                repository[i] = null;
                break;
            }
        }
    }

    public static int getSTANDART_INIT_CAPACITY() {
        return STANDART_INIT_CAPACITY;
    }

    public static Model[] getRepository() {
        return repository;
    }
}

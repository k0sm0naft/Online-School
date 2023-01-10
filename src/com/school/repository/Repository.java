package com.school.repository;

import com.school.models.Lecture;
import com.school.models.Model;
import com.school.models.Role;

import static java.lang.System.arraycopy;

public class Repository {
    private static Model[] repositoryArr = new Model[getSTANDART_INIT_CAPACITY()];
    private static final int STANDART_INIT_CAPACITY = 5;

    protected Repository() {
    }

    public static Model[] getAll() {
        return repositoryArr;
    }

    /**
     * Method to add new object in repository
     */
    public static void add(Model model) {
        for (int i = 0; i <= repositoryArr.length; i++) {
            if (i == repositoryArr.length) {
                repositoryArr = increaseCapacity(repositoryArr);
            }
            if (repositoryArr[i] == null) {
                repositoryArr[i] = model;
                break;
            }
        }
    }

    public static void add(Model model, Model[] repo) {
        for (int i = 0; i < repo.length; i++) {
            if (repo[i] == null) {
                repo[i] = model;
                break;
            }
        }
    }


    /**
     * Method to increase capacity of array
     */
    protected static Model[] increaseCapacity(Model[] repo) {
        int newCapacity = (repo.length * 3) / 2 + 1;
        Model[] tmpArr = new Model[newCapacity];
        arraycopy(repo, 0, tmpArr, 0, repo.length);
        repo = tmpArr;
        return repo;
    }

    public static int getById(long ID, Model[] repository) {
        int i = 0;
        for (Model model : repository) {
            if (model != null && ID == model.getID()) {
                System.out.println(model);
                if (((Lecture) model).getPersonID() != 0) {
                    PersonRepository.getPersonById(((Lecture) model).getPersonID(), Role.TEACHER);
                }
                break;
            }
            i++;
        }
        if (i == repository.length) System.out.println("Об'єкта з ID №" + ID + " у цій категорії не існує");
        return i;
    }

    public static void deleteById(long ID, Model[] repository) {
        int i = getById(ID, repository);
        if (i != repository.length) {
            repository[i] = null;
            System.out.println("Видалено!");
        }
    }

    protected static int getSTANDART_INIT_CAPACITY() {
        return STANDART_INIT_CAPACITY;
    }

    public static Model[] getRepository() {
        return repositoryArr;
    }
}

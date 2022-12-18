package com.school.repository;

import com.school.models.Model;

import java.util.Arrays;

public class Repository {
    private static Model[] repository;
    private static final int STANDARD_INIT_CAPACITY = 5;

    public Repository() {
        this.repository = new Model[STANDARD_INIT_CAPACITY];
    }

    public static Model[] getAl() {
        return repository;
    }

    public static void add(Model model, Model[] repository) {
        int emptySlot = 0;
        for (int i = 0; i < repository.length; i++) {
            if (repository[i] != null) continue;
            emptySlot++;
            repository[i] = model;
            break;
        }
        if (emptySlot == 0) {
            int indexToAdd = repository.length;
            repository = increaseCapacity(repository);
            repository[indexToAdd] = model;
        }
    }

    /**
     * Method to increase capacity of lecture array
     */
    public static Model[] increaseCapacity(Model[] repository) {
        int newCapacity = (repository.length * 3) / 2 + 1;
        Model[] tmpArr = new Model[newCapacity];
        System.arraycopy(repository, 0, tmpArr, 0, repository.length);
        return tmpArr;
    }

    /**
     * Return list of created lectures
     */
    public static String showList(Model[] repository) {
        int capacityStringArr = 0;
        for (int i = 0; i < repository.length; i++) {
            if (repository[i] == null) continue;
            capacityStringArr++;
        }
        String[] stringArr = new String[capacityStringArr];
        int i = 0;
        for (Model model : repository) {
            if (model == null) continue;
            stringArr[i] = model.toString();
            i++;
        }
        String obj = "об'єкти";
        return repository.length + "Створені " + obj + ": " + Arrays.toString(stringArr) + "\n";
    }

    public static void getById(int ID) {
    }

    public static void deleteById(int ID) {
    }

    public int getSTANDARD_INIT_CAPACITY() {
        return STANDARD_INIT_CAPACITY;
    }

    public static Model[] getRepository() {
        return repository;
    }
}

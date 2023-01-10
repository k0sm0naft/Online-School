package com.school.repository;

import com.school.models.Model;
import com.school.models.Person;
import com.school.models.Role;

public class PersonRepository extends Repository {
    private static Model[] personArr = new Model[getSTANDART_INIT_CAPACITY()];
    ;

    /**
     * Add new person to repository
     */
    public static void add(Person person) {
        for (int i = 0; i <= personArr.length; i++) {
            if (i == personArr.length) increaseCapacity();
            if (personArr[i] == null) break;
        }
        add(person, personArr);
    }

    public static int getPersonById(long ID, Role role) {
        int i = 0;
        for (Model person : personArr) {
            if (person != null && person.getID() == ID && ((Person) person).getRole() == role) {
                System.out.println(person);
                break;
            }
            i++;
            if (i == personArr.length) System.out.println("Об'єкта з ID №" + ID + " у цій категорії не існує");
        }
        return i;
    }

    public static void deleteById(long ID, Role role) {
        int i = getPersonById(ID, role);
        if (i != personArr.length) {
            personArr[i] = null;
            System.out.println("Видалено!");
        }
    }

    public static Model[] getPersonByRole(Role role) {
        Model[] roleArr = new Model[personArr.length];
        for (int i = 0; i < personArr.length; i++) {
            Model person = personArr[i];
            if (person != null && ((Person) person).getRole() == role) {
                roleArr[i] = person;
            }
        }
        return roleArr;
    }

    public static Model[] increaseCapacity() {
        return personArr = increaseCapacity(personArr);
    }

    public static Model[] getRepository() {
        return personArr;
    }
}

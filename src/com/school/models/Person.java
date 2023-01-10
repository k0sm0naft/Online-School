package com.school.models;

public class Person extends Course{
    private static long count;
    private long courseID;
    private final Role role;

    public Person(String name, Role role) {
        super(name);
        this.role = role;
        count++;
    }

    public Person(String name, long courseID, Role role) {
        super(name);
        this.courseID = courseID;
        this.role = role;
        count++;
    }

    public static long getCount() {
        return count;
    }

    public long getCourseID() {
        return courseID;
    }

    public Role getRole() {
        return role;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return  "ID: " + getID() +
                "\n    Тип: " + getRole().getRole() +
                "\n    ПІБ: " + getName() +
                "\n    ID курсу: " + courseID +
                "\n";
    }
}

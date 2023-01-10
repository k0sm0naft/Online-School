package com.school.models;

public enum Role {
    STUDENT("Сеудент"),
    TEACHER("Викладач");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

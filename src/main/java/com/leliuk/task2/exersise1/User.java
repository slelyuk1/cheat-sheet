package com.leliuk.task2.exersise1;

public class User {
    private String name;
    private String surname;
    private int age;
    private boolean active;

    public User(String name, String surname, int age, boolean active) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.active = active;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User toCheck = (User) obj;
        return name.equals(toCheck.name)
                && surname.equals(toCheck.surname)
                && age == toCheck.age
                && active == toCheck.active;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (surname == null ? 0 : surname.hashCode());
        hash = 31 * hash + age;
        hash = 31 * hash + (active ? 1231 : 1237);
        return hash;
    }
}
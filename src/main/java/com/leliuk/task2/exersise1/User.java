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
        return name == null ? name == toCheck.name : name.equals(toCheck.name)
                && surname == null ? surname == toCheck.surname : surname.equals(toCheck.surname)
                && age == toCheck.age
                && active == toCheck.active;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 7;
        hash = prime * hash + (name == null ? 0 : name.hashCode());
        hash = prime * hash + (surname == null ? 0 : surname.hashCode());
        hash = prime * hash + age;
        hash = prime * hash + (active ? 1231 : 1237);
        return hash;
    }
}
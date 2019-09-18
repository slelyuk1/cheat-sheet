package com.leliuk.task3;

public final class User {

    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final int code;

    private User(String name, String surname, String email, String password, int code) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public static class Builder {
        private String name;
        private String surname;
        private String email;
        private String password;
        private int code;

        public void withName(String name) {
            this.name = name;
        }

        public void withSurname(String surname) {
            this.surname = surname;
        }

        public void withEmail(String email) {
            this.email = email;
        }

        public void withPassword(String password) {
            this.password = password;
        }

        public void withCode(int code) {
            this.code = code;
        }

        public User build() {
            return new User(name, surname, email, password, code);
        }

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", code=" + code +
                '}';
    }
}

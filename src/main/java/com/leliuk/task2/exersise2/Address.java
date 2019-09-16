package com.leliuk.task2.exersise2;

public class Address {
    private String city;
    private int code;

    public Address(String city, int code) {
        this.city = city;
        this.code = code;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
package com.leliuk.task2.exersise2;

public final class User {
    private final String name;
    private final Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = copyAddress(address);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return copyAddress(address);
    }

    public User setName(String name) {
        return new User(name, address);
    }

    public User setAddress(Address address) {
        return new User(name, address);
    }

    private Address copyAddress(Address address) {
        return address == null ? null : new Address(address.getCity(), address.getCode());
    }
}

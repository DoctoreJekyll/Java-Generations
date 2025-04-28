package com.lists.examples.two;

public class User {
    String name;
    String lastName;
    String email;

    public User(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", lastName=" + lastName + ", email=" + email + '}';
    }
}

package com.relations.exerc1;

import java.util.List;

public class Book
{
    private String name;
    private List<Author> authorList;
    private double price;
    private int quantity;

    public Book(String name, List<Author> authorList, double price) {
        this.name = name;
        this.authorList = authorList;
        this.price = price;
    }

    public Book(String name, List<Author> authorList, double price, int quantity) {
        this.name = name;
        this.authorList = authorList;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

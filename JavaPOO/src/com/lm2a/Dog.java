package com.lm2a;

public class Dog
{
    private int size;
    private int breed;
    private String name;

    public Dog(int size, int breed, String name) {
        this.size = size;
        this.breed = breed;
        this.name = name;
    }

    public Dog() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBreed() {
        return breed;
    }

    public void setBreed(int breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "size=" + size +
                ", breed=" + breed +
                ", name='" + name + '\'' +
                '}';
    }

    public void bark()
    {
        System.out.println("Bark!!");
    }
}

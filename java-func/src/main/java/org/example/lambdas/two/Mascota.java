package org.example.lambdas.two;

public class Mascota {
    private int id;
    private String name;
    private String breed;
    private int age;


    public Mascota(int id, String name, String breed, int age) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Mascota{" + "id=" + id + ", name=" + name + ", breed=" + breed + ", age=" + age + '}';
    }
}

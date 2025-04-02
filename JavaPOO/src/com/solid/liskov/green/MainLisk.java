package com.solid.liskov.green;

public class MainLisk {
    public static void main(String[] args) throws Exception {

        Adulto adulto = new Adulto("Rafon", "lagon", "sfdsf23","2313");
        Muchacho muchacho = new Muchacho("Rafa", "laguna", adulto);

        muchacho.getTutor().pagar();
    }

}

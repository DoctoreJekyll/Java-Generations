package com.solid.iny.ko;

public class Loro implements IAve {
    @Override
    public void volar() {
        System.out.println("Loro voland");
    }

    @Override
    public void comer() {
        System.out.println("Loro comiendo");
    }

    @Override
    public void nadar() {
        System.out.println("se te va");
    }
}

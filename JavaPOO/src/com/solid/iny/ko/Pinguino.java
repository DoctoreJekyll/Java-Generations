package com.solid.iny.ko;

public class Pinguino implements IAve{
    @Override
    public void volar() {
        System.out.println("una pena");
        throw new RuntimeException("una pena si");
    }

    @Override
    public void comer() {
        System.out.println("comer si come");
    }

    @Override
    public void nadar() {
        System.out.println("de locos");
    }
}

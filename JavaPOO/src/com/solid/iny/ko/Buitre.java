package com.solid.iny.ko;

public class Buitre implements IAve {
    @Override
    public void volar() {
        System.out.println("buitre volando");
    }

    @Override
    public void comer() {
        System.out.println("comiendo el buitre que come");
    }

    @Override
    public void nadar() {
        System.out.println("se te va mucho");
    }
}

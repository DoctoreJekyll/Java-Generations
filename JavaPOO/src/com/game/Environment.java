package com.game;

import java.util.Random;

public class Environment
{
    private Rabbit rabbit;
    private Wolf wolf;
    private Deer deer;
    private Hyena hyena;

    public Environment()
    {
        rabbit = new Rabbit();
        wolf = new Wolf();
        deer = new Deer();
        hyena = new Hyena();
    }

    public void play(Peaceful peaceful, Hunter hunter)
    {
        peaceful.walk();
        hunter.stalk();
        peaceful.walk();
        hunter.stalk();
        peaceful.walk();
        hunter.stalk();

        peaceful.eat();
        hunter.attack();

        if (getRandomNumber() == 1){
            hunter.eat();
        }else{
            peaceful.escape();
        }
    }

    public int getRandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(2);
    }

}

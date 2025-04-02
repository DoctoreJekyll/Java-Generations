package com.game;

public class TestEnding
{
    public static void main(String[] args) {
        Environment environment = new Environment();

        Peaceful peaceful = new Deer();
        Hunter hunter = new Wolf();

        environment.play(peaceful, hunter);
    }
}

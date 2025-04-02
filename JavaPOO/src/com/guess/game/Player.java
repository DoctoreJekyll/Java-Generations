package com.guess.game;

import java.util.Scanner;

public class Player {

    private int number;

    public void guess()
    {
        System.out.println("Insert a number between 1 and 9");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
    }

    public int getNumber() {
        return number;
    }

}

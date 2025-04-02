package com.guess.game;

public class GuessGame {

    private boolean someBodyWinner = false;

    public void startGame()
    {
        Game();
    }

    private int createRandom()
    {
        return (int)(Math.random()*10);
    }

    private void CheckResults(int resultP1, int resultP2, int resultP3)
    {
        int gameNumber = createRandom();

        System.out.println("The secret number is: " + gameNumber);

        int[] results = { resultP1, resultP2, resultP3 };
        String[] texts = { "P1 winner!", "P2 winner!", "P3 winner!" };

        for (int i = 0; i < results.length; i++) {
            if (gameNumber == results[i]) {
                System.out.println(texts[i]);
                someBodyWinner = true;
                return;
            }
        }

        System.out.println("No winner!");
    }

    private void Game()
    {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        while (!someBodyWinner){
            player1.guess();
            player2.guess();
            player3.guess();

            int resultP1 = player1.getNumber();
            int resultP2 = player2.getNumber();
            int resultP3 = player3.getNumber();

            CheckResults(resultP1, resultP2, resultP3);
        }
    }
}

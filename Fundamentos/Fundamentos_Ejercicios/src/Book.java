import java.util.Random;

public class Book
{
    //Escribe un programa que muestre la tirada de tres dados. Se debe mostrar
    //también la suma total (los puntos que suman entre los tres dados).

    private int LaunchDice()
    {
        Random rand = new Random();
        return rand.nextInt(1,7);
    }

    public void Play(int times)
    {
        int total = 0;
        int aux = 0;

        for(int i = 0; i < times; i++)
        {
            total = LaunchDice();
            aux += total;
            System.out.println("Tirada " + i + total);
        }

        System.out.println("Suma total: " + aux);
    }

}

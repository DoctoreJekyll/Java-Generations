import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private VendingMachine create()
    {
        return new VendingMachine(listOfArticles(), 50.0);
    }

    private List<Article> listOfArticles()
    {
        List<Article> list = new ArrayList<>();
        list.add(new Article("Pizza", "PZ", 10.0, 10));
        list.add(new Article("Coca Cola", "CC", 2.0, 5));
        list.add(new Article("Fanta", "FT", 1.0, 2));
        list.add(new Article("Pepsi", "PE", 2.0, 20));

        return list;
    }


    public void start(){
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la expendedora");

        
        while(playing)
        {
            System.out.println("Ingresa que quiere hacer");
            System.out.println("1. Comprar");
            System.out.println("2. Salir");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option)
            {
                case 1:
                    buy();
                    break;
                case 2:
                    playing = false;
                    break;
                default:
            }
            
        }
        scanner.close();
    }

    private void buy() {
        VendingMachine vendingMachine = create();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el código del artículo:");
        String code = scanner.nextLine();

        System.out.println("Ingresa la cantidad a comprar:");
        double amount = Double.parseDouble(scanner.nextLine());

        vendingMachine.vend(code, amount);

        scanner.close();
    }


}

package generics;

public class Tienda {
    public static void main(String[] args) {
        Bolsa<Chocolatina> bolsaChocolatina = new Bolsa<>(10);

        bolsaChocolatina.add(new Chocolatina("Chocolate", 1.5));
        bolsaChocolatina.add(new Chocolatina("Chocolate1", 1.5));
        bolsaChocolatina.add(new Chocolatina("Chocolate2", 1.5));

        for (Chocolatina chocolatina : bolsaChocolatina)
        {
            System.out.println(chocolatina);
        }
    }
}

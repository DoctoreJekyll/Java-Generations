package generics.extra;

import java.util.ArrayList;
import java.util.List;

public class CopiadorDePerros {

    public static void main(String[] args) {
        List<Dog> perros = List.of(new Dog(), new Dog(), new Dog());
        List<Poodie> poodies = List.of(new Poodie(), new Poodie(), new Poodie());

        List<Animal> animales = new ArrayList<>();
        copiarPerro(perros, animales);
        System.out.println("Animales despues de copiar perros: " + animales);
    }

    public static void copiarPerro(List<? extends Dog> source, List<? super Dog> destiny)
    {
        for (Dog perro : source){
            destiny.add(perro);
        }
    }


}

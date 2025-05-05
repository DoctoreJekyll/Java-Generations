package Patrones.order.example;

import java.util.Comparator;

public class AgeComparator implements Comparator<Mascota> {
    @Override
    public int compare(Mascota o1, Mascota o2) {
        return o1.getAge() - o2.getAge();
    }
}

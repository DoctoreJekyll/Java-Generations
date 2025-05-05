package Patrones.order.example;

import java.util.Comparator;

public class NameComparator implements Comparator<Mascota> {
    @Override
    public int compare(Mascota o1, Mascota o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

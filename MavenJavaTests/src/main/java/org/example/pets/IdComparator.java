package org.example.pets;

import java.util.Comparator;

public class IdComparator implements Comparator<Mascota> {
    @Override
    public int compare(Mascota o1, Mascota o2) {
        return o1.getId() - o2.getId();
    }
}

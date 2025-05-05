package org.example.pets;

import java.util.Comparator;

public class BreedComparator implements Comparator<Mascota> {
    @Override
    public int compare(Mascota o1, Mascota o2) {
        return o1.getBreed().compareTo(o2.getBreed());
    }
}

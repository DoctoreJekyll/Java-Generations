package org.example.optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Nota> notas = new ArrayList<>();
        notas.add(new Nota("Asignatura 1", 8));
        notas.add(new Nota("Asignatura 2", 7));
        notas.add(new Nota("Asignatura 3", 9));
        notas.add(new Nota("Asignatura 4", 10));


        Optional<Nota> optNota = getSobresaliente(notas);

        optNota.ifPresent(System.out::println);
    }

    public static Optional<Nota> getSobresaliente(List<Nota> notas){
        Nota nota = null;

        for (Nota n : notas){
            if(n.getNota() >= 9){
                nota = n;
            }
        }

        return Optional.ofNullable(nota);
    }

}

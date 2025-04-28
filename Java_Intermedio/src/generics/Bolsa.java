package generics;

import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa <T> implements Iterable<T>{

    private ArrayList<T> lista = new ArrayList<>();
    private int tope;

    public Bolsa(int tope) {
        this.tope = tope;
    }

    public void add(T item){
        if(lista.size() < tope){
            lista.add(item);
        }else {
            throw new RuntimeException("La bolsa esta llena");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

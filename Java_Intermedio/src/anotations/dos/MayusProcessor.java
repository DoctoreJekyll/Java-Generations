package anotations.dos;

import anotations.Persona;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MayusProcessor {

    public static void main(String[] args) throws IllegalAccessException {
        List<Object> libros = new ArrayList<>();
        libros.add(new Libro("Trenza", "Sanderson"));
        libros.add(new Libro("El problema de los tres cuerpos", "Garcia"));
        libros.add(new Libro("El problema de los cien cuerpos", "Garcia 2"));

        process(libros);
    }


    public static void process(List<Object> lista) throws IllegalAccessException {
        for (Object o : lista){
            Field[] declarations = o.getClass().getDeclaredFields();
            for (Field field : declarations){
                Mayus annotation = field.getAnnotation(Mayus.class);
                if (annotation != null){
                    if (annotation.mayusculas()){
                        System.out.println(field.get(o).toString().toUpperCase());
                    }else {
                        System.out.println(field.get(o).toString().toLowerCase());
                    }
                }
            }
        }
    }


}

package org.example.exercise2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainAlumn {


    public static void main(String[] args) {

        //alumnosEj();

        //Pensamos en esto como una forma más declarativa o practica de trabajar con colecciones, es decir, cuando tenemos arrays, listas, etc y necesitamos hacer cosas
        // esto se puede hacer sin necesidad de programación funcional pero es una forma más rápida y practica una vez lo entiendes.
        //Por lo general cuando vas a trabajar con stream piensa en que va a ser coleccion.stream().metododestream.imprimir, algunas veces estos metodos intermedios requieren mas
        //Entendiendo esto como cualquier programador tira de internet, nadie se sabe todos los metodos stream de memoria.

        method1();

        method2();

        method3();

        method4();

        method5();

        method6();

        method7();

        method8();

    }

    private static void method8() {
        System.out.println("todos los titulos de los cursos.");
        cursoList()
                .stream()
                .map(Curso::getTitulo)
                .forEach(System.out::println);
    }

    private static void method7() {
        System.out.println("Obtener el curso con mayor duración.");
        cursoList()
                .stream()
                .max(Comparator.comparing(Curso::getDuracion))//max es una operacion propia de stream(), stream tiene un cristo de operaciones. Esta lo que hace es buscar el maximo elemento segun un criterio, en esste caso creo un comparador para la duracion y cojo el maximo.
                .ifPresent(System.out::println);//El metodo max devuelve un optional, si no hay nada, el optional sera vacio, si hay algo, el optional contendra el elemento. En este caso el metodo ifPresent, es un metodo que solo ejecuta el metodo si el optional no esta vacio.
    }

    private static void method6() {
        System.out.println("Cursos con alumnos inscritos menor a 500:");
        cursoList()
                .stream()
                .filter(curso -> curso.getAlumnos() < 500)
                .map(Curso::getTitulo)
                .forEach(System.out::println);
    }

    private static void method5() {
        System.out.println("Duracion Total de todos los cursos: ");
        Double total = cursoList().stream().mapToDouble(Curso::getDuracion).sum();//Esto es igual que el method 4, utilizo maptodoubble para convmertir, es como usar un (double) delante de algo para convertirlo y luego sum() que ese metodo suma todo
        System.out.println(total);
    }

    private static void method4() {
        System.out.println("Títulos de 3 cursos con mayor duración:");
        cursoList().stream()//Aquí volvemos a usar stream, en todos los ejercicios usamos stream para poder trabajar con cada elemento de la lista.
                .sorted((c1, c2) -> Float.compare(c2.getDuracion(), c1.getDuracion()))//Aqui usamos sorted, sorted inicialmente se usa para ordenar y ya pero uso un compare para comparar valores y ordenadr de mayor a menor
                .limit(3)//Luego con esto lo que hago es coger los 3 primeros, si no hiciese el limit me devolveria la lista entera ordenado de mayor a menor
                .map(Curso::getTitulo)//Aquí mapeamos o convertimos, hasta ahora hemos ordenado elementos "curso", aqui lo convertimos o accedemos a lo que necesitemos, en este caso necesitamos el titulo de los 3 cursos, si por ejemplo pusiera get horas, me devolverian las horas
                .forEach(System.out::println);
    }

    private static void method3() {
        System.out.println("Titulos de cursos con cantidad de videos mayor a 50: ");
        cursoList()
                .stream()
                .filter(c -> c.getVideos() > 50)
                .map(Curso::getTitulo).forEach(System.out::println);
    }

    private static void method2() {
        System.out.println("Cursos con duracion menor a 2 horas: ");
        cursoList()
                .stream()
                .filter(c -> c.getDuracion() < 2)
                .forEach(System.out::println);
    }

    private static void method1() {
        System.out.println("Cursos con duracion mayor a 5 horas: ");
        cursoList()
                .stream()//Piensa en un "stream" como una cinta por la que van pasando los objetos uno a uno y tú decides qué hacer con ellos mientras van pasando.
                .filter(c -> c.getDuracion() > 5)//Filter se usa mucho ya que es como su nombre indica, un filtro donde metemos una condición, como si fuese un if
                .forEach(System.out::println);//el foreach es como un for, consume la lista ya "procesada" y lo imprimimos.
    }

    public static void alumnosEj()
    {
        System.out.println("Ej A");
        alumnoList().stream().filter(a -> a.getNombres().contains("L") || a.getNombres().contains("G")).forEach(System.out::println);

        System.out.println("Ej B");
        long totalAlumnos = alumnoList().stream().count();
        System.out.println(totalAlumnos);

        System.out.println("Ej C");
        alumnoList().stream().filter(alumno -> alumno.getNota() > 9 && alumno.getNombreCurso().equals("PHP")).forEach(System.out::println);

        System.out.println("Ej D");
        alumnoList().stream().limit(2).forEach(System.out::println);

        System.out.println("Ej E");
        alumnoList().stream().min(Comparator.comparing(Alumno::getEdad)).ifPresent(System.out::println);

        System.out.println("Ej F");
        alumnoList().stream().max(Comparator.comparing(Alumno::getEdad)).ifPresent(System.out::println);

        System.out.println("Ej G");
        System.out.println(alumnoList().stream().findFirst());

        System.out.println("Ej H");
        alumnoList().stream().filter(alumno -> alumno.getNombreCurso().endsWith("t")).forEach(System.out::println);

        System.out.println("Ej I");
        alumnoList().stream().filter(alumno -> alumno.getNombreCurso().contains("t")).forEach(System.out::println);

        System.out.println("Ej J");
        alumnoList().stream().filter(alumno -> alumno.getNombres().length() > 10).forEach(System.out::println);

        System.out.println("Ej K");
        alumnoList().stream()
                .filter(alumno -> {
                    String primerNombre = alumno.getNombres().split(" ")[0];
                    return primerNombre.length() <= 6 && primerNombre.startsWith("G");
                })
                .forEach(System.out::println);

    }

    //A) imprimir todos aquellos alumnos cuyo nombre empieza con el caracter ‘L’ o ‘G’.

    private static void methodA() {
        System.out.println("Alumnos que empiezan por `L` o `G`: ");
        alumnoList()
                .stream()
                .filter(a -> a.getNombres().startsWith("L") || a.getNombres().startsWith("G"))
                .forEach(System.out::println);
    }

    //B) el metodo count() que vendría siendo una operación terminal (mencionada anteriormente) y con la que devolvemos la longitud de la lista
    private static void methodB() {
        System.out.println("Número de alumnos en total");
        long totalAlumnos = alumnoList().stream().count();
        System.out.println(totalAlumnos);
    }
    //C) Obtener los alumnos con notas mayores a 9 y que el curso sea PHP
    private static void methodC() {
        System.out.println("Alumnos con notas mayores a 9 en el curso de PHP: ");
        alumnoList()
                .stream()
                .filter(a -> a.getNota() > 9 && a.getNombreCurso().equals("PHP"))
                .forEach(System.out::println);
    }
    //D) Imprimir los 2 alumnos de la lista con el metodo limit(numero_elementos)
    private static void methodD() {
        alumnoList()
                .stream()
                .limit(2).
                forEach(System.out::println);
    }
    //E) Obtener el alumno que tiene la menor edad.
    private static void methodE() {
        alumnoList()
                .stream()
                .min(Comparator.comparing(Alumno::getEdad))
                .ifPresent(System.out::println);
    }
    //F) Obtener el alumno que tiene la mayor edad
    private static void methodF() {
        alumnoList()
                .stream()
                .max(Comparator.comparing(Alumno::getEdad))
                .ifPresent(System.out::println);
    }
    //G) Obtener el primer alumno de la lista con el metodo findFirst()
    private static void methodG() {
        alumnoList()
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
    }
    //H) Obtener los alumnos cuyos nombres de curso termine con el caracter ‘t’:
    private static void methodH() {
        alumnoList()
                .stream()
                .filter(a -> a.getNombreCurso().toUpperCase().endsWith("T")) //para que veas como convertirlo a mayusculas antes
                .forEach(System.out::println);
    }
    //I) Obtener los alumnos cuyos nombres de curso contengan el caracter ‘a’
    private static void methodI() {
        alumnoList()
                .stream()
                .filter(a -> a.getNombreCurso().toLowerCase().contains("a")) //para que veas como convertirlo a minusculas antes
                .forEach(System.out::println);
    }
    //J) Obtener los alumnos cuya longitud de nombres sea mayor a 10
    private static void methodJ() {
        alumnoList()
                .stream()
                .filter(a -> a.getNombres().length() > 10)
                .forEach(System.out::println);
    }
    //K) Obtener los alumnos, cuyo nombre empiece con el caracter ‘P’ y la longitud de su nombre sea <= a 6//
    private static void methodK() {
        System.out.println("Ej K");
        alumnoList().stream()
                .filter(alumno -> {
                    String primerNombre = alumno.getNombres().split(" ")[0]; //split para separar nombre y apellido: separar por cada espacio.
                    return primerNombre.length() <= 6 && primerNombre.startsWith("G");
                })
                .forEach(System.out::println);

    }


    public static List<Alumno> alumnoList()
    {
        //------------------------------------------------------------------------------------------------------------------------
        List<Alumno> listaAlumnos = new ArrayList<>();

        listaAlumnos.add(new Alumno(1, "1717213183", "Javier Ignacio", "Molina Cano", "Java 8", 7, 28));
        listaAlumnos.add(new Alumno(2, "1717456218", "Lillian Eugenia", "Gómez Álvarez", "Java 8", 10, 33));
        listaAlumnos.add(new Alumno(3, "1717328901", "Sixto Naranjoe", "Marín", "Java 8", 8.6, 15));
        listaAlumnos.add(new Alumno(4, "1717567128", "Gerardo Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        listaAlumnos.add(new Alumno(5, "1717902145", "Jhony Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        listaAlumnos.add(new Alumno(6, "1717678456", "Germán Antonio", "Lotero Upegui", "Java 8", 8, 34));
        listaAlumnos.add(new Alumno(7, "1102156732", "Oscar Darío", "Murillo González", "Java 8", 8, 32));
        listaAlumnos.add(new Alumno(8, "1103421907", "Augusto Osorno", "Palacio Martínez", "PHP", 9.5, 17));
        listaAlumnos.add(new Alumno(9, "1717297015", "César Oswaldo", "Alzate Agudelo", "Java 8", 8, 26));
        listaAlumnos.add(new Alumno(10, "1717912056", "Gloria Amparo", "González Castaño", "PHP", 10, 28));
        listaAlumnos.add(new Alumno(11, "1717912058", "Jorge León", "Ruiz Ruiz", "Python", 8, 22));
        listaAlumnos.add(new Alumno(12, "1717912985", "John Jairo", "Duque García", "Java Script", 9.4, 32));
        listaAlumnos.add(new Alumno(13, "1717913851", "Julio Cesar", "González Castaño", "C Sharp", 10, 22));
        listaAlumnos.add(new Alumno(14, "1717986531", "Gloria Amparo", "Rodas Monsalve", "Ruby", 7, 18));
        listaAlumnos.add(new Alumno(15, "1717975232", "Gabriel Jaime", "Jiménez Gómez", "Java Script", 10, 18));

        return listaAlumnos;
    }

    public static List<Curso> cursoList()
    {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        return cursos;
    }

    /*
    Resolver los siguientes problemas.
Obtener la cantidad de cursos con una duración mayor a 5 horas.
Obtener la cantidad de cursos con una duración menor a 2 horas.
Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
Mostrar en consola el título de los 3 cursos con mayor duración.
Mostrar en consola la duración total de todos los cursos.
Mostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere.
Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
Obtener el curso con mayor duración.
Crear una lista de Strings con todos los titulos de los cursos.
    */

}

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static void Chains() {
        String dni = "12345678A";
        int longitud = dni.length();
        System.out.println("La longitud del DNI es: " + longitud);
        String mensaje = "Hola Mundo";
        System.out.println("Mayúsculas: " + mensaje.toUpperCase());
        System.out.println("Minúsculas: " + mensaje.toLowerCase());
        String cadena1 = "Hola";
        String cadena2 = "hola";
        boolean iguales = cadena1.equals(cadena2);
        System.out.println("¿Las cadenas son iguales? " + iguales);
        boolean igualesIgnoreCase = cadena1.equalsIgnoreCase(cadena2);
        System.out.println("¿Las cadenas son iguales (ignorando mayúsculas)? " + igualesIgnoreCase);
    }

    public static void DNIExample() {
        String nombre = "Laura";
        String dni = "87654321B";
        int edad = 35;
        boolean esActivo = true;
        String informe = "Nombre: " + nombre + "\nDNI: " + dni + "\nEdad: " + edad + "\nEstado: " + (esActivo ? "Activo" : "Inactivo");
        System.out.println(informe);
        String numerosDNI = dni.substring(0, 8);
        String letraDNI = dni.substring(8);
        String test = dni.substring(1, 8);
        System.out.println("Dígitos DNI: " + numerosDNI);
        System.out.println("Letra DNI: " + letraDNI);
        System.out.println("Test: " + test);
    }

    public static void ScannerExample() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce tu nombre completo: ");
        String nombre = sc.nextLine();
        System.out.println("Edad: " + edad + ", Nombre: " + nombre);
        sc.close();
    }

    public static void ReadANumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        int a = sc.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int b = sc.nextInt();
        sc.nextLine();
        if (a > b) {
            System.out.println("Numero a es mayor " + a);
        } else {
            System.out.println("Numero b es mayor " + b);
        }

    }

    public static void Calc() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        int a = sc.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int b = sc.nextInt();
        sc.nextLine();
        System.out.println("Suma: " + (a + b));
        System.out.println("Resta: " + (a - b));
        System.out.println("Multiplicacion: " + a * b);
        if (b != 0) {
            System.out.println("Division: " + a / b);
        }

        System.out.println("El segundo valor no puede ser 0");
    }

    public static void ChainsTwo(@NotNull Scanner scanner) {
        System.out.println("Escribe texto1");
        String text1 = scanner.nextLine();
        System.out.println("Escribe texto2");
        String text2 = scanner.nextLine();
        if (text1.length() == text2.length()) {
            System.out.println("Los dos texts son iguales");
        } else {
            String minorText;
            if (text1.length() < text2.length()) {
                minorText = text1;
            } else {
                minorText = text2;
            }

            System.out.println("Minor: " + minorText.toLowerCase());
        }
    }

    public static void Flor() {
        String amarillo = "\u001b[33m";
        String verde = "\u001b[32m";
        String reset = "\u001b[0m";
        System.out.println("           " + amarillo + "       @@@@@@@       " + reset);
        System.out.println("           " + amarillo + "     @@@@@@@@@@@     " + reset);
        System.out.println("           " + amarillo + "   @@@@@@@@@@@@@@@   " + reset);
        System.out.println("           " + amarillo + "  @@@@@@     @@@@@@  " + reset);
        System.out.println("           " + amarillo + " @@@@@       @@@@@@ " + reset);
        System.out.println("     " + amarillo + "   @@@@@@    @@     @@@@@@   " + reset);
        System.out.println("     " + amarillo + "  @@@@@@    @@@@    @@@@@@  " + reset);
        System.out.println("     " + amarillo + "  @@@@@      @@@     @@@@@  " + reset);
        System.out.println("     " + amarillo + "   @@@               @@@   " + reset);
        System.out.println("           " + amarillo + "  @@@@       @@@   " + reset);
        System.out.println("           " + amarillo + "    @@@@@@@@    " + reset);
        System.out.println("           " + amarillo + "      @@@@      " + reset);
        System.out.println("           " + verde + "        |        " + reset);
        System.out.println("           " + verde + "        |        " + reset);
        System.out.println("           " + verde + "        |        " + reset);
        System.out.println("           " + verde + "        |        " + reset);
        System.out.println("          " + verde + "       |||       " + reset);
        System.out.println("         " + verde + "      |||||      " + reset);
        System.out.println("        " + verde + "      |||||||     " + reset);
        System.out.println("       " + verde + "     |||||||||    " + reset);
        System.out.println("      " + verde + "     |||||||||||   " + reset);
        System.out.println("     " + verde + "     |||||||||||||  " + reset);
    }

    public static void ShopList(@org.jetbrains.annotations.NotNull Scanner sc) {
        List<String> list = new ArrayList<>();
        boolean duplicated = false;

        String item;
        do {
            duplicated = false;
            System.out.println("Introduce un alimento para la lista");
            item = sc.nextLine().toLowerCase();

            for(String s : list) {
                if (s.equals(item)) {
                    System.out.println("Alimento duplicado, pon algo nuevo!");
                    duplicated = true;
                }
            }

            if (!duplicated) {
                list.add(item);
            }
        } while(!item.equals("fin"));

        list.removeLast();

        for(String s : list) {
            System.out.println(s);
        }

    }

    public static void RandomNumberGame(Scanner sc) {
        Random rand = new Random();
        int secretNumber = rand.nextInt(100) + 1;
        int trys = 0;
        int maxTrys = 3;
        boolean finish = false;

        while(!finish) {
            System.out.println("Introduzca su numero a ver si acierta! Pista, el rango sera entre 0 y 100");
            int askedNumber = sc.nextInt();
            sc.nextLine();
            System.out.println("Comprobando su numero bip bop bip bip bop...");
            if (askedNumber == secretNumber) {
                System.out.println("HAS GANADO!");
                finish = true;
            } else if (askedNumber > secretNumber) {
                System.out.println("El numero secreto es menor!");
            } else {
                System.out.println("El numero secreto es mayor!");
            }

            ++trys;
            if (trys > maxTrys) {
                System.out.println("Te quedaste sin intentos!");
                finish = true;
            }
        }

    }

    public static void TestGit() {
        System.out.println("Testing Git");
    }

    public static void TestBranch() {
        System.out.println("Testing Branch");
    }

}


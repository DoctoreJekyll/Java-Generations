import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PassGenerator
{

    public void Menu()
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to the Pass Generator");

        System.out.println("Pulse cuantos digitos quiere que tenga su contraseña");
        choice = sc.nextInt();
        sc.nextLine();

        System.out.println(GenerateThree(choice));
        sc.close();
    }

    public List<Character> lowKeys(){

        List<Character> l = new ArrayList<Character>();

        for (char c = 'a'; c <= 'z'; c++){
            l.add(c);
        }

        return l;
    }
    public List<Character> highKeys(){
        List<Character> l = new ArrayList<Character>();

        for (char c = 'A'; c <= 'Z'; c++){
            l.add(c);
        }

        return l;
    }
    public List<Character> specialChars(){

        List<Character> specialChars = new ArrayList<>();
        char[] chars = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+',
                '[', ']', '{', '}', ';', ':', '\'', '"', ',', '.', '/', '<', '>', '?'};

        for (char c : chars) {
            specialChars.add(c);
        }

        return specialChars;
    }


    private String GenerateOne(int digits){
        Random r = new Random();

        List<Character> l = lowKeys();
        StringBuilder pass = new StringBuilder();

        for(int i = 0; i<digits; i++){
            pass.append(l.get(r.nextInt(l.size())));
        }

        return pass.toString();
    }

    private String GenerateTwo(int digits){

        Random r = new Random();
        List<Character> l = lowKeys();
        List<Character> h = highKeys();

        StringBuilder pass = new StringBuilder();

        while (pass.length() < digits){
            pass.append(l.get(r.nextInt(l.size())));
            pass.append(h.get(r.nextInt(h.size())));
        }

        return pass.toString();
    }

    private String GenerateThree(int digits){
        Random r = new Random();
        List<Character> l = lowKeys();
        List<Character> h = highKeys();
        List<Character> specialChars = specialChars();

        StringBuilder pass = new StringBuilder();

        while (pass.length() < digits){
            pass.append(l.get(r.nextInt(l.size())));
            pass.append(h.get(r.nextInt(h.size())));
            pass.append(specialChars.get(r.nextInt(specialChars.size())));
        }

        return pass.toString();
    }
}

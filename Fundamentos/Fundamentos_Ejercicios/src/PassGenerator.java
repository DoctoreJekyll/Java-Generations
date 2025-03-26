import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassGenerator
{
    public int digitsUsed()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos digitos quiere usar");

        return sc.nextInt();
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


    private void GenerateOne(){
        List<Character> l = lowKeys();
        List<Character> pass = new ArrayList<>();

        for(int i = 0; i<digitsUsed(); i++){

        }

    }

    private void GenerateTwo(){

    }

    private void GenerateThree(){

    }
}

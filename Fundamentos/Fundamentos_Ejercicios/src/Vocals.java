
//Return the number (count) of vowels in the given string.
//
//We will consider a, e, i, o, u as vowels for this Kata (but not y).
//
//The input string will only consist of lower case letters and/or spaces.

public class Vocals
{
    public void countVocals(String s)
    {
        int value = 0;

        for (char c : s.toCharArray())
        {
            switch (c){
                case 'a', 'e', 'i', 'o', 'u':
                    value++;
                    break;
            }
        }

        System.out.println("Total vocals: " + value);
    }

}

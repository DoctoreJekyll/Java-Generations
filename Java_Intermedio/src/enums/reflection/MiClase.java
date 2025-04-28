package enums.reflection;

public class MiClase {

    public String randomVariable = "Random cosa";
    public int randomNumber = 10;

    public String concatenarVariableString(String string){
        return randomVariable + string;
    }

    public int concatenarVariableInt(int number){
        return randomNumber + number;
    }
}

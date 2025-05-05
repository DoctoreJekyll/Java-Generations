package Patrones.builder;

public class Main {
    public static void main(String[] args) {
        BankAccount user = new BankAccount.Builder(1234124214).withOwner("Jarma").build();

        BankAccount build = new BankAccount.Builder(213213124).atBranch("Cosas banco").withOwner("Juan").openingBalance(1000).atInterestRate(1.5).build();

        System.out.println(build);
        System.out.println(user);
    }
}

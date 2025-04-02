package com.abstracts.examples.ej2;

public class SavingAccount extends BankAccount{

    private double balance;

    public SavingAccount() {

    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;

        System.out.println(balance + "test");
    }

    @Override
    public void retreat(double amount) {
        balance -= amount;
    }
}

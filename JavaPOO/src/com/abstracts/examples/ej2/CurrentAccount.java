package com.abstracts.examples.ej2;

public class CurrentAccount extends BankAccount{

    private double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {

        if (amount > balance) {
            System.out.println("Deposit failed");
            return;
        }

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.deposit(amount);

        System.out.println(savingAccount.getBalance());
    }

    @Override
    public void retreat(double amount) {
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.retreat(amount);
        balance = balance + amount;
    }
}

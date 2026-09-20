package core_java;

import java.util.Scanner;

class Account {
    int accountNumber;
    String accountHolder;
    double balance;

    Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount deposited successfully.");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void display() {
        System.out.println("\nAccount Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate = 5.0;

    SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest : " + interest);
    }
}

class CurrentAccount extends Account {
    double overdraftLimit = 5000;

    CurrentAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}

public class BankAccountManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SavingsAccount savings =
            new SavingsAccount(101, "Rukmini", 10000);

        CurrentAccount current =
            new CurrentAccount(102, "Anil", 15000);

        System.out.println("===== BANK ACCOUNT MANAGEMENT SYSTEM =====");

        System.out.println("\n--- Savings Account ---");
        savings.display();

        savings.deposit(5000);
        savings.withdraw(2000);
        savings.calculateInterest();

        savings.display();

        System.out.println("\n--- Current Account ---");
        current.display();

        current.deposit(3000);
        current.withdraw(4000);

        current.display();

        sc.close();
    }
}

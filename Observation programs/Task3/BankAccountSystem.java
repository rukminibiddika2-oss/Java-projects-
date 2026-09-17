// BankAccountSystem.java

// Base class
class Account {

    // Attributes
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected String accountType;

    // Constructor
    Account(String accountNumber, String accountHolderName,
            double balance, String accountType) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Method to deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: Rs. " + amount);
        }
    }

    // Method to withdraw money
    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: Rs. " + amount);
            return true;
        }

        System.out.println("Insufficient balance.");
        return false;
    }

    // Method to transfer money
    boolean transfer(Account to, double amount) {

        if (withdraw(amount)) {
            to.deposit(amount);
            System.out.println("Transfer successful.");
            return true;
        }

        return false;
    }

    // Method to display account details
    void displayAccountDetails() {

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : Rs. " + balance);
    }

    // Method to get balance
    double getBalance() {
        return balance;
    }
}


// SavingsAccount inherits Account
class SavingsAccount extends Account {

    // Additional attribute
    private double interestRate;

    // Constructor
    SavingsAccount(String number, String name,
                   double balance, double interestRate) {

        super(number, name, balance, "Savings");
        this.interestRate = interestRate;
    }

    // Calculate interest
    double calculateInterest() {

        double interest = balance * interestRate / 100;

        balance = balance + interest;

        System.out.println("Interest: Rs. " + interest);

        return interest;
    }
}


// CurrentAccount inherits Account
class CurrentAccount extends Account {

    // Additional attribute
    private double overdraftLimit;

    // Constructor
    CurrentAccount(String number, String name,
                   double balance, double overdraftLimit) {

        super(number, name, balance, "Current");
        this.overdraftLimit = overdraftLimit;
    }

    // Method overriding
    @Override
    boolean withdraw(double amount) {

        // Withdrawal allowed up to overdraft limit
        if (amount > 0 && amount <= balance + overdraftLimit) {

            balance = balance - amount;

            System.out.println(
                "Withdrawn from Current Account: Rs. " + amount
            );

            return true;
        }

        System.out.println("Overdraft limit exceeded.");
        return false;
    }
}


// Main class
public class BankAccountSystem {

    public static void main(String[] args) {

        // Creating SavingsAccount object
        SavingsAccount savings =
            new SavingsAccount(
                "SA101",
                "Biddika",
                10000,
                1.0
            );

        // Creating CurrentAccount object
        CurrentAccount current =
            new CurrentAccount(
                "CA201",
                "Rukmini",
                5000,
                5000
            );


        // Display details before transactions
        System.out.println("===== BEFORE TRANSACTIONS =====");

        System.out.println("\nSavings Account");
        savings.displayAccountDetails();

        System.out.println("\nCurrent Account");
        current.displayAccountDetails();


        // Deposit money
        System.out.println("\n===== TRANSACTIONS =====");

        savings.deposit(2000);


        // Withdraw money
        savings.withdraw(1500);


        // Calculate interest
        savings.calculateInterest();


        // Transfer money
        savings.transfer(current, 2500);


        // Current account withdrawal
        current.withdraw(6000);


        // Display final balances
        System.out.println("\n===== FINAL BALANCES =====");

        System.out.println(
            "Savings Account Balance : Rs. "
            + savings.getBalance()
        );

        System.out.println(
            "Current Account Balance : Rs. "
            + current.getBalance()
        );
    }
}

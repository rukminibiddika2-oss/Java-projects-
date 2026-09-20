import java.util.ArrayList;

class Customer {
    int customerId;
    String name;
    String city;
    double balance;

    Customer(int customerId, String name, String city, double balance) {
        this.customerId = customerId;
        this.name = name;
        this.city = city;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void display() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------");
    }
}

public class CustomerDemo {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();

        Customer c1 = new Customer(101, "Ravi", "Vizag", 5000);
        Customer c2 = new Customer(102, "Biddika", "Vizianagaram", 7000);

        customers.add(c1);
        customers.add(c2);

        for (Customer c : customers) {
            c.display();
        }

        c1.deposit(2000);
        c2.withdraw(1000);

        System.out.println("After Transactions:");
        System.out.println("----------------------");

        for (Customer c : customers) {
            c.display();
        }
    }
}

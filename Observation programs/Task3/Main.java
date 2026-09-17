/**
 * Title: Digital Wallet and UPI Payment System
 * Concepts Demonstrated: Interfaces, Encapsulation, Custom Exception Handling
 */

// ==========================================
// 1. CUSTOM EXCEPTION CLASSES
// ==========================================

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidUPIException extends Exception {
    public InvalidUPIException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// ==========================================
// 2. PAYMENT SERVICE INTERFACE
// ==========================================

interface PaymentService {
    void pay(String receiverUpi, double amount) 
        throws InvalidUPIException, InvalidAmountException, InsufficientBalanceException;
    double checkBalance();
}

// ==========================================
// 3. WALLET CLASS (Encapsulation)
// ==========================================

class Wallet {
    // Private data members to enforce encapsulation
    private String userName;
    private String mobileNumber;
    private String upiId;
    private double balance;

    // Constructor
    public Wallet(String userName, String mobileNumber, String upiId) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.upiId = upiId;
        this.balance = 0.0;
    }

    // Add money method
    public void addMoney(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero.");
        }
        this.balance += amount;
        System.out.println(" SUCCESS: ₹" + amount + " added to wallet successfully.");
    }

    // Withdraw money method
    public void withdrawMoney(double amount) {
        this.balance -= amount;
    }

    // Getters
    public double getBalance() {
        return this.balance;
    }

    public String getUpiId() {
        return this.upiId;
    }

    // Display wallet summary
    public void displayWalletDetails() {
        System.out.println("\n-------------------------------------------");
        System.out.println("             CURRENT WALLET STATUS         ");
        System.out.println("-------------------------------------------");
        System.out.println(" Account Holder : " + userName);
        System.out.println(" Mobile Number  : " + mobileNumber);
        System.out.println(" UPI ID         : " + upiId);
        System.out.println(" Current Balance: ₹" + String.format("%.2f", balance));
        System.out.println("-------------------------------------------\n");
    }
}

// ==========================================
// 4. UPI PAYMENT CLASS (Polymorphism & Validation)
// ==========================================

class UPIPayment implements PaymentService {
    private Wallet wallet;

    public UPIPayment(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void pay(String receiverUpi, double amount) 
            throws InvalidUPIException, InvalidAmountException, InsufficientBalanceException {
        
        System.out.println("\n--> Initiating Payment of ₹" + amount + " to [" + receiverUpi + "]...");

        // Validate receiver UPI ID format
        if (receiverUpi == null || !receiverUpi.contains("@") || receiverUpi.trim().length() < 5) {
            throw new InvalidUPIException("Transaction Failed: Invalid UPI ID format (" + receiverUpi + ").");
        }

        // Validate payment amount
        if (amount <= 0) {
            throw new InvalidAmountException("Transaction Failed: Transfer amount must be positive.");
        }

        // Validate available balance
        if (wallet.getBalance() < amount) {
            throw new InsufficientBalanceException("Transaction Failed: Insufficient balance. Available: ₹" 
                     + wallet.getBalance() + ", Required: ₹" + amount);
        }

        // Process deduction upon successful validation
        wallet.withdrawMoney(amount);
        System.out.println(" SUCCESS: Payment of ₹" + amount + " sent to " + receiverUpi + "!");
    }

    @Override
    public double checkBalance() {
        return wallet.getBalance();
    }
}

// ==========================================
// 5. MAIN DRIVER CLASS
// ==========================================

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("       WELCOME TO DIGITAL UPI PAYMENT SYSTEM       ");
        System.out.println("====================================================");

        // Instantiate Wallet and UPI Payment Service
        Wallet myWallet = new Wallet("Alex Morgan", "9876543210", "alex@upi");
        PaymentService paymentApp = new UPIPayment(myWallet);

        myWallet.displayWalletDetails();

        try {
            // Add Money
            System.out.println("[ACTION]: Adding ₹5000 to Wallet...");
            myWallet.addMoney(5000.00);

            // Successful Payment
            paymentApp.pay("merchant@okaxis", 1250.50);

            // Test Case: Invalid UPI Handle Exception
            try {
                paymentApp.pay("invalid_upi_handle", 200.00);
            } catch (Exception e) {
                System.out.println(" EXCEPTION CAUGHT: " + e.getMessage());
            }

            // Test Case: Negative/Zero Amount Exception
            try {
                paymentApp.pay("friend@okicici", -50.00);
            } catch (Exception e) {
                System.out.println(" EXCEPTION CAUGHT: " + e.getMessage());
            }

            // Test Case: Insufficient Balance Exception
            try {
                paymentApp.pay("store@ybl", 10000.00);
            } catch (Exception e) {
                System.out.println(" EXCEPTION CAUGHT: " + e.getMessage());
            }

        } catch (InvalidAmountException e) {
            System.out.println(" ERROR: " + e.getMessage());
        } finally {
            // Display final wallet details
            System.out.println("\n[SYSTEM]: Closing session and rendering report...");
            myWallet.displayWalletDetails();
        }
    }
}

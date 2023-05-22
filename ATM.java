package com.taskthree.atm;
import java.util.Scanner;

public class ATM {
	// Instance variables
    private Bank bank; // The bank that the ATM belongs to
    private Scanner scanner; // The scanner object to read user input

    // Constructor
    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    // A method to run the ATM interface
    public void run() {
        System.out.println("Welcome to the ATM machine");
        boolean exit = false;
        while (!exit) {
            System.out.println("Please enter your account id and pin");
            int id = scanner.nextInt();
            int pin = scanner.nextInt();
            Account account = bank.findAccount(id, pin);
            if (account == null) {
                System.out.println("Invalid id or pin. Try again.");
            } else {
                System.out.println("Login successful.");
                boolean logout = false;
                while (!logout) {
                    System.out.println("Please choose an option:");
                    System.out.println("1. Transactions history");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");
                    int option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            showTransactions(account);
                            break;
                        case 2:
                            withdraw(account);
                            break;
                        case 3:
                            deposit(account);
                            break;
                        case 4:
                            transfer(account);
                            break;
                        case 5:
                            logout = true;
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                }
                System.out.println("Logout successful.");
            }
            System.out.println("Do you want to exit? (y/n)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("y")) {
                exit = true;
                System.out.println("Thank you for using the ATM machine.");
            }
        }
        
        scanner.close();
        
     }
     
     // A method to show the transactions history of an account
     public void showTransactions(Account account) {
         account.display();
     }
     
     // A method to withdraw money from an account
     public void withdraw(Account account) {
         System.out.println("How much do you want to withdraw?");
         double amount = scanner.nextDouble();
 if (amount > 0 && amount <= account.getBalance()) {
             // The amount is valid and the account has enough balance
             // Update the account balance and add a transaction
             account.setBalance(account.getBalance() - amount);
             account.addTransaction("Withdraw: $" + amount);
             System.out.println("Withdraw successful. Your new balance is $" + account.getBalance());
         } else {
             // The amount is invalid or the account has insufficient balance
             System.out.println("Withdraw failed. Please enter a valid amount and check your balance.");
         }
     }

     // A method to deposit money to an account
     public void deposit(Account account) {
         System.out.println("How much do you want to deposit?");
         double amount = scanner.nextDouble();
         if (amount > 0) {
             // The amount is valid
             // Update the account balance and add a transaction
             account.setBalance(account.getBalance() + amount);
             account.addTransaction("Deposit: $" + amount);
             System.out.println("Deposit successful. Your new balance is $" + account.getBalance());
         } else {
             // The amount is invalid
             System.out.println("Deposit failed. Please enter a positive amount.");
         }
     }

     // A method to transfer money from one account to another
     public void transfer(Account account) {
         System.out.println("Please enter the id and pin of the recipient account");
         int id = scanner.nextInt();
         int pin = scanner.nextInt();
         Account recipient = bank.findAccount(id, pin);
         if (recipient == null) {
             // The recipient account does not exist or the pin is incorrect
             System.out.println("Transfer failed. Invalid id or pin of the recipient account.");
         } else {
             // The recipient account exists and the pin is correct
             System.out.println("How much do you want to transfer?");
             double amount = scanner.nextDouble();
             if (amount > 0 && amount <= account.getBalance()) {
                 // The amount is valid and the sender account has enough balance
                 // Update both accounts' balances and add transactions
                 account.setBalance(account.getBalance() - amount);
                 recipient.setBalance(recipient.getBalance() + amount);
                 account.addTransaction("Transfer: $" + amount + " to " + recipient.getId());
                 recipient.addTransaction("Transfer: $" + amount + " from " + account.getId());
                 System.out.println("Transfer successful. Your new balance is $" + account.getBalance());
             } else {
                 // The amount is invalid or the sender account has insufficient balance
                 System.out.println("Transfer failed. Please enter a valid amount and check your balance.");
             }
         }
     }

     // The main method to create a bank and an ATM object and run the ATM interface
     public static void main(String[] args) {
         Bank bank = new Bank(); // Create a bank object
         ATM atm = new ATM(bank); // Create an ATM object with the bank as an argument
         atm.run(); // Run the ATM interface
     }

}

package com.taskthree.atm;


import java.util.ArrayList;

public class Account {

    // Instance variables
    private int id; // The account id
    private int pin; // The account pin
    private double balance; // The account balance
    private ArrayList<String> transactions; // The list of transactions

    // Constructor
    public Account(int id, int pin, double balance) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    

	// Getters and setters
    public int getId() {
        return id;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    // A method to add a transaction to the list
    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    // A method to display the account details
    public void display() {
        System.out.println("Account id: " + id);
        System.out.println("Account balance: $" + balance);
        System.out.println("Transactions: ");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

}

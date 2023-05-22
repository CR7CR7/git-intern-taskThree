package com.taskthree.atm;

import java.util.ArrayList;

public class Bank {
	 // Instance variables
    private ArrayList<Account> accounts; // The list of accounts

    // Constructor
    public Bank() {
        accounts = new ArrayList<>();
        // Add some dummy accounts for testing
        accounts.add(new Account(1001, 1234, 5000.00));
        accounts.add(new Account(1002, 4321, 3000.00));
        accounts.add(new Account(1003, 1111, 10000.00));
    }

    // A method to find an account by id and pin
    public Account findAccount(int id, int pin) {
        for (Account account : accounts) {
            if (account.getId() == id && account.getPin() == pin) {
                return account;
            }
        }
        return null;
    }

}

package controller;

import model.*;
import java.util.*;

public class AccountController {
    private AccountManager manager;

    public AccountController(AccountManager manager) {
        this.manager = manager;
    }

    public void createAccount(String type, String number, String holder, double balance, double limit) {
        Account acc = type.equals("credit") ?
                new CreditAccount(number, holder, balance, limit) :
                new DebitAccount(number, holder, balance, limit);
        manager.addAccount(acc);
    }

    public void deposit(String number, double amount) {
        Account acc = manager.getAccount(number);
        if (acc != null) {
            acc.deposit(amount);
            manager.updateAccount(acc);
        } else {
            throw new IllegalArgumentException("Not found");
        }
    }

    public void withdraw(String number, double amount) {
        Account acc = manager.getAccount(number);
        if (acc != null) {
            acc.withdraw(amount);
            manager.updateAccount(acc);
        } else {
            throw new IllegalArgumentException("Not found");
        }
    }

    public void deleteAccount(String number) {
        manager.deleteAccount(number);
    }

    public Account getAccount(String number) {
        return manager.getAccount(number);
    }

    public List<Account> getAllAccounts() {
        return manager.getAllAccounts();
    }
}
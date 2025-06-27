package model;

import persistence.CsvStorage;
import java.util.*;

public class AccountManager {
    private List<Account> accounts;
    private CsvStorage storage;

    public AccountManager(CsvStorage storage) {
        this.storage = storage;
        this.accounts = storage.loadAccounts();
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    public Account getAccount(String number) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(number)) return acc;
        }
        return null;
    }

    public void addAccount(Account account) {
        if (getAccount(account.getAccountNumber()) != null)
            throw new IllegalArgumentException("Account exists");
        accounts.add(account);
        save();
    }

    public void updateAccount(Account account) {
        deleteAccount(account.getAccountNumber());
        addAccount(account);
    }

    public void deleteAccount(String number) {
        Account acc = getAccount(number);
        if (acc == null) throw new IllegalArgumentException("Not found");
        accounts.remove(acc);
        save();
    }

    public void save() {
        storage.saveAccounts(accounts);
    }
}
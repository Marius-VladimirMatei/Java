package model;

public abstract class Account {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    protected AccountType type;

    public Account(String number, String holder, double balance, AccountType type) {
        this.accountNumber = number;
        this.accountHolder = holder;
        this.balance = balance;
        this.type = type;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit must be positive");
        }
    }

    public abstract void withdraw(double amount);
    public abstract String toCsv();

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
    public AccountType getType() { return type; }
}



package model;

public class CreditAccount extends Account {
    private double creditLimit;

    public CreditAccount(String number, String holder, double balance, double limit) {
        super(number, holder, balance, AccountType.CREDIT);
        this.creditLimit = limit;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (balance - amount < -creditLimit)
            throw new IllegalArgumentException("Over credit limit");
        balance -= amount;
    }

    public double getCreditLimit() {
        return creditLimit;
    }



    public String toCsv() {
        return String.format("credit,%s,%s,%.2f,%.2f", accountNumber, accountHolder, balance, creditLimit);
    }
}
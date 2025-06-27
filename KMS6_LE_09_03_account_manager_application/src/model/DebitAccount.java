package model;

public class DebitAccount extends Account {
    private double withdrawLimit;

    public DebitAccount(String number, String holder, double balance, double limit) {
        super(number, holder, balance, AccountType.DEBIT);
        this.withdrawLimit = limit;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > withdrawLimit || amount > balance)
            throw new IllegalArgumentException("Exceeds limit or balance");
        balance -= amount;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public String toCsv() {
        return String.format("debit,%s,%s,%.2f,%.2f", accountNumber, accountHolder, balance, withdrawLimit);
    }
}
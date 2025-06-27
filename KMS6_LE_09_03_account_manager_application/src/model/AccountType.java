package model;

public enum AccountType {
    CREDIT("credit"),
    DEBIT("debit");

    private final String value;
    AccountType(String value) { this.value = value; }
    public String toString() { return value; }
}
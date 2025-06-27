package view;

import model.*;
import java.util.List;

public class OutputHandler {
    public void displayMainMenu() {
        System.out.println("\n==== Account Manager ====");
        System.out.println("1. Create Account");
        System.out.println("2. Delete Account");
        System.out.println("3. Show Account Balance");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Deposit Money");
        System.out.println("6. Show Account Details");
        System.out.println("7. Show All Accounts");
        System.out.println("8. Exit");
    }

    public void displayAccount(Account acc) {
        System.out.println("Account: " + acc.getAccountNumber());
        System.out.println("Holder: " + acc.getAccountHolder());
        System.out.println("Type: " + acc.getType());
        System.out.printf("Balance: %.2f\n", acc.getBalance());
        if (acc instanceof CreditAccount) {
            System.out.printf("Credit Limit: %.2f\n", ((CreditAccount) acc).getCreditLimit());
        } else if (acc instanceof DebitAccount) {
            System.out.printf("Withdraw Limit: %.2f\n", ((DebitAccount) acc).getWithdrawLimit());
        }
    }

    public void displayAllAccounts(List<Account> list) {
        if (list.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            for (Account acc : list) {
                displayAccount(acc);
                System.out.println("------------------");
            }
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showError(String msg) {
        System.out.println("Error: " + msg);
    }

    public void showAccountBalance(String number, double balance) {
        System.out.printf("Balance for %s: %.2f\n", number, balance);
    }
}
package view;

import model.Account;
import controller.AccountController;

/**
 * Manages menu display and handling user selections
 */
public class Menu {
    private AccountController controller;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private boolean running;

    public Menu(AccountController controller) {
        this.controller = controller;
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
        this.running = true;
    }

    public void show() {
        while (running) {
            outputHandler.displayMainMenu();
            int choice = inputHandler.readInt("Select an option: ");
            processMenuChoice(choice);
        }

        inputHandler.close();
    }

    private void processMenuChoice(int choice) {
        switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                deleteAccount();
                break;
            case 3:
                showAccountBalance();
                break;
            case 4:
                withdrawMoney();
                break;
            case 5:
                depositMoney();
                break;
            case 6:
                showAccountDetails();
                break;
            case 7:
                showAllAccounts();
                break;
            case 8:
                outputHandler.showMessage("Goodbye!");
                running = false;
                break;
            default:
                outputHandler.showMessage("Invalid option, please try again.");
        }
    }

    private void createAccount() {
        try {
            String type = inputHandler.readAccountType();
            String number = inputHandler.readString("Enter account number: ");
            String holder = inputHandler.readString("Enter account holder name: ");
            double balance = inputHandler.readDouble("Enter initial balance: ");
            double limit = inputHandler
                    .readDouble("Enter " + (type.equals("credit") ? "credit" : "withdrawal") + " limit: ");

            controller.createAccount(type, number, holder, balance, limit);
            outputHandler.showMessage("Account created successfully!");
        } catch (Exception e) {
            outputHandler.showError(e.getMessage());
        }
    }

    private void deleteAccount() {
        try {
            String number = inputHandler.readString("Enter account number to delete: ");
            controller.deleteAccount(number);
            outputHandler.showMessage("Account deleted successfully!");
        } catch (Exception e) {
            outputHandler.showError(e.getMessage());
        }
    }

    private void showAccountBalance() {
        try {
            String number = inputHandler.readString("Enter account number: ");
            Account account = controller.getAccount(number);
            if (account != null) {
                outputHandler.showAccountBalance(number, account.getBalance());
            } else {
                outputHandler.showMessage("Account not found.");
            }
        } catch (Exception e) {
            outputHandler.showError(e.getMessage());
        }
    }

    private void withdrawMoney() {
        try {
            String number = inputHandler.readString("Enter account number: ");
            double amount = inputHandler.readDouble("Enter amount to withdraw: ");
            controller.withdraw(number, amount);
            outputHandler.showMessage("Withdrawal successful!");
        } catch (Exception e) {
            outputHandler.showError(e.getMessage());
        }
    }

    private void depositMoney() {
        try {
            String number = inputHandler.readString("Enter account number: ");
            double amount = inputHandler.readDouble("Enter amount to deposit: ");
            controller.deposit(number, amount);
            outputHandler.showMessage("Deposit successful!");
        } catch (Exception e) {
            outputHandler.showError(e.getMessage());
        }
    }

    private void showAccountDetails() {
        try {
            String number = inputHandler.readString("Enter account number: ");
            Account account = controller.getAccount(number);
            if (account != null) {
                outputHandler.displayAccount(account);
            } else {
                outputHandler.showMessage("Account not found.");
            }
        } catch (Exception e) {
            outputHandler.showError(e.getMessage());
        }
    }

    private void showAllAccounts() {
        outputHandler.displayAllAccounts(controller.getAllAccounts());
    }
}
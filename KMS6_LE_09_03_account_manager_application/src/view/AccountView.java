package view;

import controller.AccountController;

public class AccountView {
    private Menu menu;

    public AccountView(AccountController controller) {
        this.menu = new Menu(controller);
    }

    public void showMenu() {
        menu.show();
    }
}
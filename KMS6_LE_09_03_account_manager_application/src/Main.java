import persistence.CsvStorage;
import controller.AccountController;
import view.AccountView;
import model.AccountManager;

public class Main {
    public static void main(String[] args) {
        CsvStorage storage = new CsvStorage("accounts.csv");
        AccountManager manager = new AccountManager(storage);
        AccountController controller = new AccountController(manager);
        AccountView view = new AccountView(controller);
        view.showMenu();
    }
}
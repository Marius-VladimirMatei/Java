package persistence;

import model.*;
import java.io.*;
import java.util.*;

public class CsvStorage {
    private String filePath;

    public CsvStorage(String path) {
        this.filePath = path;
    }

    public List<Account> loadAccounts() {
        List<Account> list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) continue;
                String type = parts[0];
                String num = parts[1];
                String holder = parts[2];
                double bal = Double.parseDouble(parts[3]);
                double limit = Double.parseDouble(parts[4]);

                Account acc = type.equals("credit") ?
                        new CreditAccount(num, holder, bal, limit) :
                        new DebitAccount(num, holder, bal, limit);
                list.add(acc);
            }
        } catch (Exception e) {
            System.out.println("Failed to load accounts");
        }

        return list;
    }

    public void saveAccounts(List<Account> accounts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Account acc : accounts) {
                bw.write(acc.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving");
        }
    }
}
// Class designed to set the date-time pattern ad read date-time input from the user

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeInput {
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public LocalDateTime readDateTime(String prompt) {
        System.out.print(prompt + " (dd-MM-yyyy HH:mm): ");
        String input = scanner.nextLine();
        return LocalDateTime.parse(input, formatter);
    }
}

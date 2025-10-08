package se.iths.armin.project2.view;


import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UI {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String prompt(String message, String type) {
        System.out.print(message + " ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        return input;
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public String menu(String title, List<String> options) {
        System.out.println("\n" + title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.print("Choose option (1-" + options.size() + "): ");
        String input = scanner.nextLine();
        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= options.size()) {
                return options.get(choice - 1);
            }
        } catch (NumberFormatException ignored) {
        }
        return null;
    }

    public void scrollableList(String message) {
        System.out.println("\n--- Product List ---");
        System.out.println(message);
        System.out.println("--------------------\n");
    }
}



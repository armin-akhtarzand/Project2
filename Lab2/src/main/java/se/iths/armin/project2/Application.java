package se.iths.armin.project2;

import se.iths.armin.project2.controller.Service;
import se.iths.armin.project2.controller.Storage;
import se.iths.armin.project2.model.Product;
import se.iths.armin.project2.view.DialogUI;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        Storage storage = new Storage();
        List<Product> products = storage.load();
        DialogUI ui = new DialogUI();
        Service service = new Service(ui, products);

        boolean exit = false;


        while (!exit) {
            String choice = service.mainMenu("Main Menu", List.of("Add new product", "List all products", "Show product info", "Exit program"));
            if (choice == null) {
                return;
            }
            switch (choice) {
                case "Add new product" -> {
                    service.addProduct();
                    storage.save(service.getProducts());
                }
                case "List all products" -> service.listProducts();
                case "Show product info" -> service.findProduct();
                case "Exit program" -> exit = true;


            }
        }
    }
}

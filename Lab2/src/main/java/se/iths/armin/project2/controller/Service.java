package se.iths.armin.project2.controller;


import se.iths.armin.project2.model.Belts;
import se.iths.armin.project2.model.Hats;
import se.iths.armin.project2.model.Product;
import se.iths.armin.project2.model.Shoes;
import se.iths.armin.project2.view.UI;

import java.util.Comparator;
import java.util.List;


public class Service {

    private List<Product> products;
    private UI ui;


    public Service(UI ui, List<Product> products) {
        this.ui = ui;
        this.products = products;
    }


    public void addProduct() {
        
        while (true) {
            String type = ui.menu("Choose product type to add", List.of("Belts", "Hats", "Shoes", "Back to main menu"));
            if (type == null) {
                return;
            }
            switch (type) {
                case "Belts" -> addBelts();
                case "Hats" -> addHats();
                case "Shoes" -> addShoes();
                case "Back to main menu" -> {
                    return;
                }
                default -> ui.info("Invalid choice, try again");
            }


        }

    }

    public void addBelts() {
        String category = "Belts";
        boolean keepGoing = true;
        while (keepGoing) {
            int articleNumber = askForArticleNumber(category);
            if (articleNumber == -1) return;

            String title = askForTitle(category);
            if (title == null) return;

            String description = askForDescription(category);
            if (description == null) return;

            double price = askForPrice(category);
            if (price == -1) return;

            products.add(new Belts(articleNumber, title, price, description));
            ui.info("Article number " + articleNumber + " has been added!");

            keepGoing = false;
        }


    }

    public void addShoes() {
        String category = "Shoes";
        boolean keepGoing = true;
        while (keepGoing) {
            int articleNumber = askForArticleNumber(category);
            if (articleNumber == -1) return;

            String title = askForTitle(category);
            if (title == null) return;

            String description = askForDescription(category);
            if (description == null) return;

            double price = askForPrice(category);
            if (price == -1) return;

            products.add(new Shoes(articleNumber, title, price, description));
            ui.info("Article number " + articleNumber + " has been added!");

            keepGoing = false;
        }

    }

    public void addHats() {
        String category = "Hats";
        boolean keepGoing = true;
        while (keepGoing) {
            int articleNumber = askForArticleNumber(category);
            if (articleNumber == -1) return;

            String title = askForTitle(category);
            if (title == null) return;

            String description = askForDescription(category);
            if (description == null) return;

            double price = askForPrice(category);
            if (price == -1) return;

            products.add(new Hats(articleNumber, title, price, description));
            ui.info("Article number " + articleNumber + " has been added!");
            keepGoing = false;
        }

    }

    public void listProducts() {
        StringBuilder productsBuilder = new StringBuilder();
        if (products.isEmpty()) {
            ui.info("No products to list");
            return;
        }
        products.sort(Comparator.comparing(Product::category));
        for (Product product : products) {
            productsBuilder.append("Article number: ").append(product.getArticleNumber()).append("\n");
            productsBuilder.append("Title: ").append(product.getTitle()).append("\n");
            productsBuilder.append("Category: ").append(product.category()).append("\n\n");
        }
        ui.scrollableList(productsBuilder.toString());

    }

    public void findProduct() {
        int id = 0;
        boolean accepted = false;
        while (true) {

            String input = ui.prompt("Enter article number: ", "Find product");
            if (input == null) {
                return;
            }
            try {
                id = Integer.parseInt(input);
                accepted = true;
                break;
            } catch (NumberFormatException e) {
                ui.info("Invalid article number, use numbers!");
                return;
            }
        }

        if (accepted) {
            boolean found = false;
            for (Product product : products) {
                if (id == product.getArticleNumber()) {
                    ui.info("Article number: " + product.getArticleNumber()
                            + "\nTitle: " + product.getTitle()
                            + "\nDescription: " + product.getDescription()
                            + "\nPrice: " + product.getPrice() + " kr"
                            + "\nCategory: " + product.category() + "\n");
                    found = true;
                    break;
                }

            }
            if (!found) {
                ui.info("Can't find product with article number: " + id);
            }


        }

    }

    public String mainMenu(String title, List<String> choices) {
        return ui.menu(title, choices);
    }

    public List<Product> getProducts() {
        return products;
    }

    public int askForArticleNumber(String type) {
        int articleNumber = 0;
        outer:
        while (true) {
            String input = ui.prompt("Enter article number: ", type);
            if (input == null) {
                return -1;

            }
            try {
                articleNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                ui.info("Invalid article number, use numbers!");
                continue outer;
            }
            for (Product product : products) {
                if (product.getArticleNumber() == articleNumber) {
                    ui.info("Article number " + articleNumber + " already exists!");
                    continue outer;
                }
            }
            break;
        }
        return articleNumber;
    }

    public String askForTitle(String category) {
        String title;
        outer:
        while (true) {
            title = ui.prompt("Enter title: ", category);
            if (title == null) {
                return null;
            }
            if (title.isEmpty()) {
                ui.info("Invalid title, cant be empty!");
                continue outer;
            }
            break;
        }
        return title;

    }

    public String askForDescription(String category) {
        String description;
        outer:
        while (true) {
            description = ui.prompt("Enter description: ", category);
            if (description == null) {
                return null;
            }
            if (description.isEmpty()) {
                ui.info("Invalid description, cant be empty!");
                continue outer;
            }
            break;
        }
        return description;
    }

    public double askForPrice(String category) {
        double price;
        outer:

        while (true) {
            String input = ui.prompt("Enter price: ", category);
            if (input == null) return -1;
            try {
                price = Double.parseDouble(input.replaceAll(",", "."));
                break;
            } catch (NumberFormatException e) {
                ui.info("Invalid price, use numbers!");
                continue outer;
            }
        }
        return price;
    }

}

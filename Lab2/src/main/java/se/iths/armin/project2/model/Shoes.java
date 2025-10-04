package se.iths.armin.project2.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Shoes")
public class Shoes extends Product {

    public Shoes(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    public Shoes() {
    }

    @Override
    public String category() {
        return "Shoes";
    }
}

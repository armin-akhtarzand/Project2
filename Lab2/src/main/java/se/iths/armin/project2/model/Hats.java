package se.iths.armin.project2.model;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Hats")
public class Hats extends Product {

    public Hats(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    public Hats() {
    }

    @Override
    public String category() {
        return "Hats";
    }
}

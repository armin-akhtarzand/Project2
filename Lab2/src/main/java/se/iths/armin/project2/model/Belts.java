package se.iths.armin.project2.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Belts")
public class Belts extends Product {

    public Belts(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    public Belts() {
    }


    @Override
    public String category() {
        return "Belts";
    }

}

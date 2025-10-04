package se.iths.armin.project2.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "category"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Belts.class, name = "Belts"),
        @JsonSubTypes.Type(value = Hats.class, name = "Hats"),
        @JsonSubTypes.Type(value = Shoes.class, name = "Shoes")
})

public abstract class Product {
    private int articleNumber;
    private String title;
    private String description;
    private double price;


    public Product(int articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.description = description;
        this.price = price;

    }

    public Product() {

    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String category();

}




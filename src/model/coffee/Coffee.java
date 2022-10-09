package model.coffee;

public abstract class Coffee {
    String description = "";
    double price = 0;

    public String getDescription(){
        return description;
    }

    public double getPrice(){ return price; }
}

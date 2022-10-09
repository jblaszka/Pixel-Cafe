package model.condiment;

import model.coffee.Coffee;

public class Honey extends CondimentDecorator{
    Coffee coffee;

    public Honey(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with honey";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 0.25;
    }
}

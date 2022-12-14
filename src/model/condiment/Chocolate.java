package model.condiment;

import model.coffee.Coffee;

public class Chocolate extends CondimentDecorator{
    Coffee coffee;

    public Chocolate(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with Chocolate";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}

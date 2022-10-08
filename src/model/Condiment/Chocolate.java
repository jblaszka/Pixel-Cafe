package model.Condiment;

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
}

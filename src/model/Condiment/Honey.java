package model.Condiment;

import model.coffee.Coffee;

public class Honey extends CondimentDecorator{
    Coffee coffee;

    public Honey(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return null;
    }
}

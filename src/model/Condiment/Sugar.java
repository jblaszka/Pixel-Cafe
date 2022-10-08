package model.Condiment;

import model.coffee.Coffee;

public class Sugar extends CondimentDecorator{
    Coffee coffee;

    public Sugar(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with sugar";
    }
}

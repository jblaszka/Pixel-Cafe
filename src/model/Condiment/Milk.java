package model.Condiment;

import model.coffee.Coffee;

public class Milk extends CondimentDecorator{
    Coffee coffee;

    public Milk(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with Milk";
    }
}

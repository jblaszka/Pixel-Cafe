package model.condiment;

import model.coffee.Coffee;

public abstract class CondimentDecorator extends Coffee {

    public abstract String getDescription();

    public abstract double getPrice();
}

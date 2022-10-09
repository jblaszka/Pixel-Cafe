package model;

import model.condiment.Honey;
import model.condiment.Milk;
import model.condiment.Sugar;
import model.coffee.*;
import view.BaristaObserver;

import java.util.ArrayList;

public class CafeModel implements CafeModelInterface{
    private ArrayList baristaObservers = new ArrayList();
    private int orderStatus = 0;
    private int sceneNumber = 0;
    private double price = 0;
    private int coffeeNumber;
    private int additiveNumber;
    private Coffee coffee;

    @Override
    public void setCoffeeNumber(int coffeeNumber){
        this.coffeeNumber = coffeeNumber;
        sceneNumber = 1;
        setCoffee();
        notifyObserversAboutOrder();
    }

    @Override
    public void setCoffeeAdditiveNumber(int additiveNumber){
        this.additiveNumber = additiveNumber;
        sceneNumber = 2;
        setAdditive();
        notifyObserversAboutOrder();
        notifyObserversAboutPrice();
    }

    @Override
    public void completeTheOrder(){
        matchSceneToOrder();
        notifyObserversAboutOrder();
    }

    @Override
    public void setCoffee(){
        switch (coffeeNumber){
            case 1 -> coffee = new Latte();
            case 2 -> coffee = new Americano();
            case 3 -> coffee = new Cappuccino();
            case 4 -> coffee = new Espresso();
        }
    }

    public void setAdditive(){
        switch (additiveNumber){
            case 1 -> {
                coffee = new Milk(coffee);
                price = coffee.getPrice();
            }
            case 2 -> {
                coffee = new Sugar(coffee);
                price = coffee.getPrice();
            }
            case 3 -> {
                coffee = new Honey(coffee);
                price = coffee.getPrice();
            }
            case 4 -> {
                price = coffee.getPrice();
            }
        }
    }

    public void matchSceneToOrder(){
        switch (coffeeNumber){
            case 1 -> sceneNumber = 3;
            case 2, 3 -> sceneNumber = 4;
            case 4 -> sceneNumber = 5;
        }
    }

    @Override
    public void addBaristaObserver(BaristaObserver baristaObserver) {
        baristaObservers.add(baristaObserver);
    }

    @Override
    public void removeBaristaObserver(BaristaObserver baristaObserver) {
        int i = baristaObservers.indexOf(baristaObserver);
        if(i >= 0){
            baristaObservers.remove(i);
        }
    }

    public void notifyObserversAboutOrder(){
        for (Object baristaObserver : baristaObservers) {
            BaristaObserver observer = (BaristaObserver) baristaObserver;
            observer.updateSelectedCoffee();
        }
    }

    public void notifyObserversAboutPrice(){
        for (Object baristaObserver : baristaObservers) {
            BaristaObserver observer = (BaristaObserver) baristaObserver;
            observer.updateBill();
        }
    }

    public int getNewScene(){
        return sceneNumber;
    }

    public double getPrice() {
        return price;
    }
}

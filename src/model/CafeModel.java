package model;

import model.Condiment.Honey;
import model.Condiment.Milk;
import model.Condiment.Sugar;
import model.coffee.*;
import view.BaristaObserver;

import java.util.ArrayList;

public class CafeModel implements CafeModelInterface{
    private ArrayList baristaObservers = new ArrayList();
    private int orderStatus = 0;
    private int sceneNumber = 0;
    private int coffeeNumber;
    private int additiveNumber;
    private Coffee coffee;

    public void setCoffeeNumber(int coffeeNumber){
        this.coffeeNumber = coffeeNumber;
        sceneNumber = 1;
        setCoffee();
        notifyObservers();
    }

    public void setCoffeeAdditiveNumber(int additiveNumber){
        this.additiveNumber = additiveNumber;
        setAdditive();
        matchSceneToOrder();
        notifyObservers();
    }

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
            case 1 -> coffee = new Milk(coffee);
            case 2 -> coffee = new Sugar(coffee);
            case 3 -> coffee = new Honey(coffee);
        }
        print();
    }

    public void matchSceneToOrder(){
        switch (coffeeNumber){
            case 1 -> sceneNumber = 2;
            case 2, 3 -> sceneNumber = 3;
            case 4 -> sceneNumber = 4;
        }
    }

    public void print(){
        System.out.println(coffee.getDescription());
    }

    @Override
    public void starTakingTheOrder() {
    }

    @Override
    public void takeListOfCondiments() {

    }

    @Override
    public void getFinishedOrder() {

    }

    @Override
    public void setOrderStatus(int orderStatus) {
      this.orderStatus = orderStatus;
    }

    @Override
    public int getOrderStatus() {
        return orderStatus;
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

    public void notifyObservers(){
        for (Object baristaObserver : baristaObservers) {
            BaristaObserver observer = (BaristaObserver) baristaObserver;
            observer.updateSelectedCoffee();
        }
    }

    public int getNewScene(){
        return sceneNumber;
    }

}

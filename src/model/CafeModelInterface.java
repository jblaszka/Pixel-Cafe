package model;

import view.BaristaObserver;

public interface CafeModelInterface {
    void setCoffee();
    void completeTheOrder();
    void setCoffeeNumber(int coffeeNumber);
    void setCoffeeAdditiveNumber(int additiveNumber);
    void setAdditive();
    void addBaristaObserver(BaristaObserver baristaObserver);
    void removeBaristaObserver(BaristaObserver baristaObserver);
}

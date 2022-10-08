package model;

import view.BaristaObserver;

public interface CafeModelInterface {
    void starTakingTheOrder();
    void takeListOfCondiments();
    void getFinishedOrder();
    void setOrderStatus(int orderStatus);
    int getOrderStatus();
    void addBaristaObserver(BaristaObserver baristaObserver);
    void removeBaristaObserver(BaristaObserver baristaObserver);
}

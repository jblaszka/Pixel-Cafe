package model;

import view.BaristaObserver;

import java.util.ArrayList;

public class CafeModel implements CafeModelInterface{
    private ArrayList baristaObservers = new ArrayList();
    private int orderStatus = 0;
    private int sceneNumber = 0;

    public void testowa(int liczba){
        System.out.println(liczba);
        sceneNumber++;
        notifyObservers();
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
        for(int i = 0; i < baristaObservers.size(); i++){
            BaristaObserver observer = (BaristaObserver) baristaObservers.get(i);
            observer.updateOrderStatus();
        }
    }

    public int getNewScene(){
        return sceneNumber;
    }

}

package controller;

import model.CafeModel;
import view.CafeView;

public class CafeController implements CafeControllerInterface{
    CafeModel cafeModel;
    CafeView cafeView;

    public CafeController(CafeModel cafeModel){
        this.cafeModel = cafeModel;
        cafeView = new CafeView(this, cafeModel);

    }

    @Override
    public void setOrderStatus() {

    }

    @Override
    public void setCoffee(int coffee) {
        cafeModel.testowa(coffee);
    }

    @Override
    public void setAdditions() {

    }
}

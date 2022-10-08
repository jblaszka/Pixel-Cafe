package main;

import controller.CafeController;
import model.CafeModel;
import model.coffee.Coffee;
import model.Condiment.Milk;
import model.coffee.Espresso;
import view.CafeView;

public class Main {
    public static void main(String[] args){
        CafeModel cafeModel = new CafeModel();
        CafeController cafeController = new CafeController(cafeModel);

    }
}

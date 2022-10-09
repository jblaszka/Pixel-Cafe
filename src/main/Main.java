package main;

import controller.CafeController;
import model.CafeModel;

public class Main {
    public static void main(String[] args){
        CafeModel cafeModel = new CafeModel();
        CafeController cafeController = new CafeController(cafeModel);

    }
}

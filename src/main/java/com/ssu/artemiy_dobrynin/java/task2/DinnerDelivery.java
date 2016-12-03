package com.ssu.artemiy_dobrynin.java.task2;

import com.ssu.artemiy_dobrynin.java.task2.controller.DinnerIO;
import com.ssu.artemiy_dobrynin.java.task2.model.EmployeeOrderGenerator;
import com.ssu.artemiy_dobrynin.java.task2.model.KitchenOrderGenerator;
import com.ssu.artemiy_dobrynin.java.task2.model.Menu;

/**
 * Created by DobryninAM on 28.09.2016.
 */
public class DinnerDelivery { //Task 2 by Artemiy Dobrynin

    public static Menu MENU = new DinnerIO().menuRead();

    public static void main(String[] args) {
        DinnerDelivery app = new DinnerDelivery();
        app.startApplication();
    }

    public void startApplication() {
        DinnerIO io = new DinnerIO();
        EmployeeOrderGenerator generator = io.orderRead();
        io.employeeOrderWrite(generator);
        KitchenOrderGenerator kitchenOrderGenerator = new KitchenOrderGenerator();
        kitchenOrderGenerator.generateKitchenOrderFromEmployeeOrder(generator, MENU);
        io.kitchenOrderWrite(kitchenOrderGenerator);
    }
}

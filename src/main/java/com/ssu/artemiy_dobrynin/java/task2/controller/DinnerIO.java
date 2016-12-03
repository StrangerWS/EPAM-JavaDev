package com.ssu.artemiy_dobrynin.java.task2.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssu.artemiy_dobrynin.java.task2.DinnerDelivery;
import com.ssu.artemiy_dobrynin.java.task2.gson.DishDeserializer;
import com.ssu.artemiy_dobrynin.java.task2.gson.EmployeeOrderDeserializer;
import com.ssu.artemiy_dobrynin.java.task2.gson.EmployeeOrderSerializer;
import com.ssu.artemiy_dobrynin.java.task2.gson.KitchenOrderSerializer;
import com.ssu.artemiy_dobrynin.java.task2.model.EmployeeOrderGenerator;
import com.ssu.artemiy_dobrynin.java.task2.model.KitchenOrderGenerator;
import com.ssu.artemiy_dobrynin.java.task2.model.Menu;
import com.ssu.artemiy_dobrynin.java.task2.model.element.Dish;
import com.ssu.artemiy_dobrynin.java.task2.model.element.EmployeeOrder;
import com.ssu.artemiy_dobrynin.java.task2.model.element.KitchenOrder;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Created by DobryninAM on 19.10.2016.
 */
public class DinnerIO {

    private static Gson GSON_MENU = new GsonBuilder()
            .registerTypeAdapter(Dish.class, new DishDeserializer())
            .create();
    private static String FILE_MENU = DinnerDelivery.class.getResource("/import/menu.json").getFile();

    private static Gson GSON_EMPORDER_DESERIALIZE = new GsonBuilder()
            .registerTypeAdapter(EmployeeOrder.class, new EmployeeOrderDeserializer())
            .create();
    private static String FILE_EMPORDER = DinnerDelivery.class.getResource("/import/emporder.json").getFile();

    private static Gson GSON_EMPORDER_SERIALIZE = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(EmployeeOrder.class, new EmployeeOrderSerializer())
            .create();

    private static Gson GSON_KITORDER_SERIALIZE = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(KitchenOrder.class, new KitchenOrderSerializer())
            .create();

    public Menu menuRead() {
        Menu tmp = null;
        try {
            tmp = new Menu(new TreeSet<Dish>(Arrays.asList(GSON_MENU.fromJson(new FileReader(FILE_MENU), Dish[].class))));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

    public EmployeeOrderGenerator orderRead() {
        EmployeeOrderGenerator tmp = null;
        try {
            tmp = new EmployeeOrderGenerator(Arrays.asList(GSON_EMPORDER_DESERIALIZE.fromJson(new FileReader(FILE_EMPORDER), EmployeeOrder[].class)));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

    public void kitchenOrderWrite(KitchenOrderGenerator kitchenOrderGenerator) {
        try {
            FileWriter fw = new FileWriter(new File("src\\main\\resources\\export\\ordersum.json"));
            fw.write(GSON_KITORDER_SERIALIZE.toJson(kitchenOrderGenerator.getOrders()));
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void employeeOrderWrite(EmployeeOrderGenerator employeeOrderGenerator) {
        try {
            FileWriter fw = new FileWriter(new File("src\\main\\resources\\export\\empprice.json"));
            Collections.sort(employeeOrderGenerator.getOrders());
            fw.write(GSON_EMPORDER_SERIALIZE.toJson(employeeOrderGenerator.getOrders()));
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

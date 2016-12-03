package com.ssu.artemiy_dobrynin.java.task2.model.element;

/**
 * Created by DobryninAM on 12.10.2016.
 */
public class Dish implements Comparable<Dish> {

    protected String name;
    protected int weight;
    protected int price;

    public Dish(String name, int weight, int price) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Dish o) {
        return name.compareTo(o.name);
    }
}
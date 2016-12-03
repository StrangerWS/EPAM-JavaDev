package com.ssu.artemiy_dobrynin.java.task2.model.element;

import com.ssu.artemiy_dobrynin.java.task2.model.Menu;

/**
 * Created by DobryninAM on 12.10.2016.
 */
public class KitchenOrder implements Comparable<KitchenOrder> {

    protected String name;
    protected int count = 1;
    protected double price;

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public KitchenOrder(String name, Menu menu) {
        this.name = name;
        price = menu.findDish(name).price;
    }

    public int compareTo(KitchenOrder o) {
        return name.compareTo(o.name);
    }
}

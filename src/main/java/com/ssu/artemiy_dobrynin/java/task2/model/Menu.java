package com.ssu.artemiy_dobrynin.java.task2.model;

import com.ssu.artemiy_dobrynin.java.task2.model.element.Dish;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by DobryninAM on 12.10.2016.
 */
public class Menu {

    private Set<Dish> menu;

    public Menu() {
        menu = new TreeSet<Dish>();
    }

    public Menu(TreeSet<Dish> menu) {
        this.menu = menu;
    }

    public void addDish(Dish dish) {
        menu.add(dish);
    }

    public Dish findDish(String name) {
        for (Dish dish : menu) {
            if (dish.getName().equals(name)) {
                return dish;
            }
        }
        return null;
    }
}

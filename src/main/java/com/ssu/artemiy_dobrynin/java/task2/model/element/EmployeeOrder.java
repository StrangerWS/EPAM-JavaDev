package com.ssu.artemiy_dobrynin.java.task2.model.element;

import com.ssu.artemiy_dobrynin.java.task2.exception.DishNotExistException;
import com.ssu.artemiy_dobrynin.java.task2.model.Menu;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by DobryninAM on 12.10.2016.
 */
public class EmployeeOrder implements Comparable<EmployeeOrder> {

    private String name;
    private Set<Dish> order;
    private double price = 0;

    public String getName() {
        return name;
    }

    public Set<Dish> getOrder() {
        return order;
    }

    public EmployeeOrder(String name, TreeSet<Dish> order) {
        this.name = name;
        this.order = order;
    }

    public EmployeeOrder(String name) {
        this.name = name;
        order = new TreeSet<Dish>();
    }

    public void addDish(String dishName, Menu menu) {
        Dish dish = menu.findDish(dishName);
        if (dish != null) {
            order.add(dish);
        } else throw new DishNotExistException();
    }

    public double getPrice() {
        for (Dish dish : order) {
            price += dish.price;
        }
        return price;
    }


    public int compareTo(EmployeeOrder o) {
        return name.compareTo(o.name);
    }
}

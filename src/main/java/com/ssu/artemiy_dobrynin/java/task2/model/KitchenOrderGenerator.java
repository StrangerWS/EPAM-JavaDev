package com.ssu.artemiy_dobrynin.java.task2.model;

import com.ssu.artemiy_dobrynin.java.task2.model.element.Dish;
import com.ssu.artemiy_dobrynin.java.task2.model.element.EmployeeOrder;
import com.ssu.artemiy_dobrynin.java.task2.model.element.KitchenOrder;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by DobryninAM on 12.10.2016.
 */
public class KitchenOrderGenerator {

    private Set<KitchenOrder> orders;
    private double summary = 0;

    public Set<KitchenOrder> getOrders() {
        return orders;
    }

    public double getSummary() {
        for (KitchenOrder entry : orders) {
            summary += entry.getPrice() * entry.getCount();
        }
        return summary;
    }

    public KitchenOrderGenerator() {
        orders = new TreeSet<KitchenOrder>();
    }

    public void addOrder(String order, Menu menu) {
        KitchenOrder tmp = findKitchenOrder(order);
        if (tmp == null) {
            orders.add(new KitchenOrder(order, menu));
        } else {
            tmp.setCount(tmp.getCount() + 1);
        }
    }

    public void generateKitchenOrderFromEmployeeOrder(EmployeeOrderGenerator generator, Menu menu) {
        for (EmployeeOrder order : generator.getOrders()) {
            for (Dish dish : order.getOrder()) {
                addOrder(dish.getName(), menu);
            }
        }
    }

    private KitchenOrder findKitchenOrder(String name) {
        for (KitchenOrder order : orders) {
            if (order.getName().equals(name)) {
                return order;
            }
        }
        return null;
    }


}


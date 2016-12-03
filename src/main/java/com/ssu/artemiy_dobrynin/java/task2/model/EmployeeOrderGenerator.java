package com.ssu.artemiy_dobrynin.java.task2.model;

import com.ssu.artemiy_dobrynin.java.task2.model.element.EmployeeOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DobryninAM on 19.10.2016.
 */
public class EmployeeOrderGenerator {

    private List<EmployeeOrder> orders;

    public List<EmployeeOrder> getOrders() {
        return orders;
    }

    public EmployeeOrderGenerator() {
        orders = new ArrayList<EmployeeOrder>();
    }

    public EmployeeOrderGenerator(List<EmployeeOrder> orders) {
        this.orders = orders;
    }

    public void addOrder(EmployeeOrder order) {
        orders.add(order);
    }
}

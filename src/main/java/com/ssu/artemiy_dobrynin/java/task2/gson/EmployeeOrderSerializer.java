package com.ssu.artemiy_dobrynin.java.task2.gson;

import com.google.gson.*;
import com.ssu.artemiy_dobrynin.java.task2.model.element.Dish;
import com.ssu.artemiy_dobrynin.java.task2.model.element.EmployeeOrder;

import java.lang.reflect.Type;

/**
 * Created by User on 03.12.2016.
 */
public class EmployeeOrderSerializer implements JsonSerializer<EmployeeOrder> {

    public JsonElement serialize(EmployeeOrder employeeOrder, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();

        result.addProperty("name", employeeOrder.getName());
        JsonArray order = new JsonArray();
        result.add("order", order);
        for (Dish dish : employeeOrder.getOrder()) {
            order.add(new JsonPrimitive(dish.getName()));
        }
        result.addProperty("price", employeeOrder.getPrice());

        return result;
    }
}

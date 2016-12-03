package com.ssu.artemiy_dobrynin.java.task2.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ssu.artemiy_dobrynin.java.task2.model.element.KitchenOrder;

import java.lang.reflect.Type;

/**
 * Created by User on 03.12.2016.
 */
public class KitchenOrderSerializer implements JsonSerializer<KitchenOrder> {

    public JsonElement serialize(KitchenOrder kitchenOrder, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();

        result.addProperty("name", kitchenOrder.getName());
        result.addProperty("count", kitchenOrder.getCount());
        result.addProperty("price", kitchenOrder.getPrice() * kitchenOrder.getCount());

        return result;
    }
}

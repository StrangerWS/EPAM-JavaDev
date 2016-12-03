package com.ssu.artemiy_dobrynin.java.task2.gson;

import com.google.gson.*;
import com.ssu.artemiy_dobrynin.java.task2.DinnerDelivery;
import com.ssu.artemiy_dobrynin.java.task2.model.element.EmployeeOrder;

import java.lang.reflect.Type;

/**
 * Created by User on 01.12.2016.
 */
public class EmployeeOrderDeserializer implements JsonDeserializer<EmployeeOrder> {

    public EmployeeOrder deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();

        EmployeeOrder deserializedOrder = new EmployeeOrder(name);

        JsonArray order = jsonObject.getAsJsonArray("order");
        for (JsonElement value : order) {
            deserializedOrder.addDish(value.getAsString(), DinnerDelivery.MENU);
        }
        return deserializedOrder;
    }
}


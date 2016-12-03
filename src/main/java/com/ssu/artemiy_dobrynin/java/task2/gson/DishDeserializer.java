package com.ssu.artemiy_dobrynin.java.task2.gson;

import com.google.gson.*;
import com.ssu.artemiy_dobrynin.java.task2.model.element.Dish;

import java.lang.reflect.Type;

/**
 * Created by DobryninAM on 30.11.2016.
 */
public class DishDeserializer implements JsonDeserializer<Dish> {

    public Dish deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        int weight = jsonObject.get("weight").getAsInt();
        int price = jsonObject.get("price").getAsInt();

        return new Dish(name, weight, price);
    }
}

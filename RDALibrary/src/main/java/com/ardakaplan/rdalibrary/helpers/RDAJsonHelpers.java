package com.ardakaplan.rdalibrary.helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("unused")
public final class RDAJsonHelpers {

    private RDAJsonHelpers() {

    }

    public static String listToJson(ArrayList<?> list) {

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        return gson.toJsonTree(list).getAsJsonArray().toString();
    }

    /**
     * Type collectionType = new TypeToken<List<Player>>() { }.getType();
     * <p/>
     * seklinde type verilerek kullanilir
     */
    public static ArrayList<?> jsonToList(String json, Type collectionType) {

        Gson googleJson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        JsonReader reader = new JsonReader(new StringReader(json));

        reader.setLenient(true);

        return googleJson.fromJson(reader, collectionType);
    }

    public static String objectToJson(Object object) {
        return new Gson().toJson(object);
    }

    @SuppressWarnings("unchecked")
    public static <W> W jsonToObject(String json, Class<?> klass) throws JsonSyntaxException {

        Gson gson = new Gson();

        return (W) gson.fromJson(json, klass);
    }
}

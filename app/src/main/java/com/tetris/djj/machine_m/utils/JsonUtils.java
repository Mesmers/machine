package com.tetris.djj.machine_m.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Adu on 2015/10/30.
 */
public class JsonUtils {

    public static String getString(JSONObject object, String key){
        String value;
        try {
            value = object.getString(key);
            return value;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getInt(JSONObject object, String key){
        int value;
        try {
            value = object.getInt(key);
            return value;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static double getDouble(JSONObject object, String key){
        double value;
        try {
            value = object.getDouble(key);
            return value;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean getBoolean(JSONObject object, String key){
        boolean value;
        try {
            value = object.getBoolean(key);
            return value;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static long getLong(JSONObject object, String key){
        long value;
        try {
            value = object.getLong(key);
            return value;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static JSONArray getJSONArray(JSONObject object, String key){
        JSONArray array;
        try {
            array = object.getJSONArray(key);
            return array;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject getJSONObject(JSONObject object, String key){
        JSONObject object1;
        try {
            object1 = object.getJSONObject(key);
            return object1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject getJSONObject(String jsonString){
        JSONObject object;
        try {
            object = new JSONObject(jsonString);
            return object;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

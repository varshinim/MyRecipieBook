package com.eleven.group.myrecipiebook.model;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Nutrition {
    private String attribute;
    private Double value;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Nutrition(){}

    public Nutrition(JSONObject jsonObject){
        try {
            this.attribute = jsonObject.getString("attribute");
            this.value = jsonObject.getDouble("value");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

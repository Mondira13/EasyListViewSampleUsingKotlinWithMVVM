package com.example.easylistviewsampleusingkotlinwithmvvm.responses;

import com.example.easylistviewsampleusingkotlinwithmvvm.model.Item;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashboardResponse {


    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

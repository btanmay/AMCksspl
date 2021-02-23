package com.example.androidapp;

public class Ticket {

    String id,name,address,mobileno,asset,description;

    public Ticket(){}

    public Ticket(String id, String name, String address, String mobileno, String asset, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobileno = mobileno;
        this.asset = asset;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

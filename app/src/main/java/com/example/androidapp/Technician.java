package com.example.androidapp;

public class Technician {

    String id, Name1,Address1,Doj1;

    public Technician(){}

    public Technician(String id, String name1, String address1, String doj1) {
        this.id = id;
        Name1 = name1;
        Address1 = address1;
        Doj1 = doj1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getDoj1() {
        return Doj1;
    }

    public void setDoj1(String doj1) {
        Doj1 = doj1;
    }
}

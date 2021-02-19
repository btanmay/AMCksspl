package com.example.androidapp;

public class Ticket2 {

    String Fname1,Address1,Phno1,Des1;

    public Ticket2()
    {

    }

    public Ticket2(String fname1, String address1, String phno1, String des1)
    {
        Fname1 = fname1;
        Address1 = address1;
        Phno1 = phno1;
        Des1 = des1;
    }

    public String getFname1() {
        return Fname1;
    }

    public void setFname1(String fname1) {
        Fname1 = fname1;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getPhno1() {
        return Phno1;
    }

    public void setPhno1(String phno1) {
        Phno1 = phno1;
    }

    public String getDes1() {
        return Des1;
    }

    public void setDes1(String des1) {
        Des1 = des1;
    }
}

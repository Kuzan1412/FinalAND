package com.example.user.midterm_adv;

import java.io.Serializable;

public class Phone implements Serializable {
    private int id;
    private String proName;
    private String proDes;
    private int proPrice;
    private String proDucer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDes() {
        return proDes;
    }

    public void setProDes(String proDes) {
        this.proDes = proDes;
    }

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }

    public String getProDucer() {
        return proDucer;
    }

    public void setProDucer(String proDucer) {
        this.proDucer = proDucer;
    }
}

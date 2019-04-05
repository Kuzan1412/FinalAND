package com.example.user.endexam;

import java.io.Serializable;

public class Table implements Serializable {
    String TabStatus;
    String TabName;
    String TabQuatity;
    int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Table() {
    }

    int TabSum;

    public int getSum() {
        return TabSum;
    }

    public void setSum(int sum) {
        TabSum = sum;
    }

    public String getTabStatus() {
        return TabStatus;
    }

    public void setTabStatus(String tabStatus) {
        TabStatus = tabStatus;
    }

    public String getTabName() {
        return TabName;
    }

    public void setTabName(String tabName) {
        TabName = tabName;
    }

    public String getTabQuatity() {
        return TabQuatity;
    }

    public void setTabQuatity(String tabQuatity) {
        TabQuatity = tabQuatity;
    }

    public Table(String tabStatus, String tabName, String tabQuatity, int tabSum) {
        TabStatus = tabStatus;
        TabName = tabName;
        TabQuatity = tabQuatity;
        TabSum = tabSum;

    }
}

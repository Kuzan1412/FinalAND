package com.example.user.endexam;

public class Bill {
    int Bill_id;
    int Table_id;

    public Bill() {
    }

    int Product_id;

    public int getBill_id() {
        return Bill_id;
    }

    public void setBill_id(int bill_id) {
        Bill_id = bill_id;
    }

    public int getTable_id() {
        return Table_id;
    }

    public void setTable_id(int table_id) {
        Table_id = table_id;
    }

    public int getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(int product_id) {
        Product_id = product_id;
    }

    public Bill(int bill_id, int table_id, int product_id) {

        Bill_id = bill_id;
        Table_id = table_id;
        Product_id = product_id;
    }
}

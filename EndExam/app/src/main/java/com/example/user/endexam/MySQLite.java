package com.example.user.endexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MySQLite extends SQLiteOpenHelper {
    public static final String DBName = "Sqlite";
    public static final int VERSION = 1;
    //TABLE PRODUCT
    public static final String TABLE_PRODUCT = "PRODUCT";
    public static final String PRODUCT_ID = "ID";
    public static final String PRODUCT_CODE = "CODE";
    public static final String PRODUCT_COST = "COST";
    public static final String PRODUCT_NAME = "NAME";
    public static final String PRODUCT_UNIT = "UNIT";

    //TABLE TCOFFEE
    public static final String TABLE_TCOFFEE = "TCOFFEE";
    public static final String TCOFFEE_ID = "ID";
    public static final String TCOFFEE_NAME = "NAME";
    public static final String TCOFFEE_STATUS = "STATUS";
    public static final String TCOFFEE_QUANTITY = "QUANTITY";
    public static final String TCOFFEE_SUM = "SUM";
    //TABLE BILL
    public static final String TABLE_BILL = "BILL";
    public static final String BILL_ID = "ID";
    public static final String BILL_TCOFFEE_ID = "TCOFFEE_ID";
    public static final String BILL_PRODUCT_ID = "PRODUCT_ID";
    //TABLE BILL

    public SQLiteDatabase mDB;
    public MySQLite(Context context) {
        super(context, DBName, null, VERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String mTCoffeeQuery = String.format("CREATE TABLE %s( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT, %s  TEXT, %s TEXT, %s INTEGER)", TABLE_TCOFFEE, TCOFFEE_ID, TCOFFEE_NAME, TCOFFEE_STATUS, TCOFFEE_QUANTITY, TCOFFEE_SUM) ;
        String mProductQuery = String.format("CREATE TABLE %s( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_PRODUCT,PRODUCT_ID, PRODUCT_NAME, PRODUCT_CODE, PRODUCT_COST, PRODUCT_UNIT);
        String mBillQuery = String.format("CREATE TABLE %s( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s INTEGER, %s INTEGER)", TABLE_BILL, BILL_ID, BILL_PRODUCT_ID, BILL_TCOFFEE_ID );

        db.execSQL(mProductQuery);
        db.execSQL(mTCoffeeQuery);
        db.execSQL(mBillQuery);
    }

    public List<Table> getAllTableCoffee(){
        List<Table> models = new ArrayList<>();
        String mQuery = "SELECT * FROM " + TABLE_TCOFFEE;
        Cursor cursor = mDB.rawQuery(mQuery,null);
        if (cursor.moveToFirst()){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Table model = new Table();
                model.setId(cursor.getInt(0));
                model.setTabName(cursor.getString(1));
                model.setTabStatus(cursor.getString(2));
                model.setTabQuatity(cursor.getString(3));
                model.setSum(cursor.getInt(4));
                models.add(model);
            }
        }
        cursor.close();
        return models;
    }

    public List<String> getTcoffeeNames(){
        List<String> models = new ArrayList();
        String mQuery = "SELECT " +TCOFFEE_NAME+" FROM " + TABLE_TCOFFEE;
        Cursor cursor = mDB.rawQuery(mQuery,null);
        if (cursor.moveToFirst()){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                String m = cursor.getString(0);
                models.add(m);
            }
        }
        cursor.close();
        return models;
    }
    public int getTableId(String mName){
        String mQuery = "SELECT " +TCOFFEE_ID+" FROM " + TABLE_TCOFFEE + " WHERE " + TCOFFEE_NAME + " like " + "'" + mName + "'";
        Cursor cursor = mDB.rawQuery(mQuery,null);
        if (cursor.moveToFirst()){
            return cursor.getInt(0);
        }
        cursor.close();
        return 0;
    }

    public void addTable(String mName, int mSum, String mQuality, String mStatus){
        ContentValues values = new ContentValues();
        values.put(TCOFFEE_NAME,mName);
        values.put(TCOFFEE_SUM,mSum);
        values.put(TCOFFEE_QUANTITY,mQuality);
        values.put(TCOFFEE_STATUS, mStatus);
        mDB.insert(TABLE_TCOFFEE,null,values);
    }

    /////////////////////////////////////////////////////////////////////////
    public List<Product> getAllProduct(){
        List<Product> models = new ArrayList<>();
        String mQuery = "SELECT * FROM " + TABLE_PRODUCT;
        Cursor cursor = mDB.rawQuery(mQuery,null);
        if (cursor.moveToFirst()){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Product model = new Product();
                model.setId(cursor.getInt(0));
                model.setNamePro(cursor.getString(1));
                model.setCodePro(cursor.getString(2));
                model.setCostPro(cursor.getString(3));
                model.setUnitPro(cursor.getString(4));
                models.add(model);//origin 'models'
            }
        }
        cursor.close();
        return models;
    }
    public int updateItem(int id, String status){
//        String mQuery = String.format("UPDATE %s SET %s = %d WHERE %s = %d",TABLE_MH,MH_Status,status,MH_ID,id);
//        mDB.execSQL(mQuery);
        status = "Paid";
        String mClause = String.format("%s = %d",TCOFFEE_ID,id);
        ContentValues values = new ContentValues();
        values.put(TCOFFEE_STATUS,status);
        int isSuccess = mDB.update(TCOFFEE_STATUS,values,mClause,null);
        return isSuccess;
    }


    public Product getProductById(int Id){
        String mQuery = String.format("SELECT * FROM %s WHERE ID = %d", TABLE_PRODUCT,Id);
        Cursor cursor = mDB.rawQuery(mQuery,null);
        if (cursor.moveToNext()){
            Product model = new Product();
            model.setId(cursor.getInt(0));
            model.setNamePro(cursor.getString(1));
            model.setCostPro(cursor.getString(2));
            return model;
        }
        return null;
    }
    public long addProduct(String mName, String mCost, String mCode, String mUnit){
        ContentValues values = new ContentValues();
        values.put(PRODUCT_NAME,mName);
        values.put(PRODUCT_COST, mCost);
        values.put(PRODUCT_CODE, mCode);
        values.put(PRODUCT_UNIT, mUnit);
        long isSuccess = mDB.insert(TABLE_PRODUCT,null,values);
        return isSuccess;
    }
    ////////////////////////////////////////////////////////////////////////
    public List<Bill> getAllBill(){
        List<Bill> models = new ArrayList<>();
        String mQuery = "SELECT * FROM " + TABLE_BILL;
        Cursor cursor = mDB.rawQuery(mQuery,null);
        if (cursor.moveToFirst()){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Bill model = new Bill();
                model.setBill_id(cursor.getInt(0));
                model.setProduct_id(cursor.getInt(1));
                model.setTable_id(cursor.getInt(2));
                models.addAll(models);
            }
        }
        cursor.close();
        return models;
    }
    public long addBill(int SubjectId,int StudentId){
        ContentValues values = new ContentValues();
        values.put(BILL_PRODUCT_ID, PRODUCT_ID);
        values.put(BILL_TCOFFEE_ID, TCOFFEE_ID);
        long isSuccess = mDB.insert(TABLE_BILL,null,values);
        return isSuccess;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void OpenDB(){
        mDB = getWritableDatabase();
    }
    public void CloseDB(){
        if (mDB != null){
            mDB.close();
        }
    }
}

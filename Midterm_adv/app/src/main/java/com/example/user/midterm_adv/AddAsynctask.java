package com.example.user.midterm_adv;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.util.Map;

public class AddAsynctask extends AsyncTask<String, Boolean, JSONObject> {
    private Map<String,String> mMap;

    public AddAsynctask(Map<String, String> mMap) {
        this.mMap = mMap;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        return null;
    }
}

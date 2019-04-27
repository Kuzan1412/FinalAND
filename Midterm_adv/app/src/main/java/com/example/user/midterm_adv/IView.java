package com.example.user.midterm_adv;

import android.graphics.Bitmap;

import org.json.JSONArray;

public interface IView {
    void OnGetBitmapSuccess(Bitmap bitmap);
    void onGetDataSuccess(JSONArray jsonArray);
}

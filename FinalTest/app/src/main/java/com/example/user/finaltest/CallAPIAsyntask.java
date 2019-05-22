package com.example.user.finaltest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class CallAPIAsyntask  extends AsyncTask<String, Boolean, JSONObject> {
    private Map<String,String> mMap;

    private Context mContext;
    private ProgressDialog dialog;

    public CallAPIAsyntask(Map<String, String> mMap, Context mContext) {
        this.mMap = mMap;
        this.mContext = mContext;

    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        if(jsonObject != null)
        {
            try
            {
                int result = jsonObject.getInt("result");
                String message = jsonObject.getString("response_message");

                if(result > 0) {
                    JSONObject respondata = jsonObject.getJSONObject("response_data");
                    int userid = respondata.getInt("user_id");
                    // JSONArray parentArray = jsonObject.getJSONArray("response_data");
                    //int userid = parentArray.getJSONObject(0).getInt("user_id");
                }
                else
                {

                }
            }catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onProgressUpdate(Boolean... values) {
        super.onProgressUpdate(values);
        if(values[0] == true)
        {
            dialog.dismiss();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(mContext);
        dialog.setTitle("Loading....");
        dialog.show();
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        try {
            //set up to prepare call API
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("POST");
            //add request params
            JSONObject jsonObject = new JSONObject();
            Iterator iterator = mMap.keySet().iterator();
            while(iterator.hasNext())
            {
                String key = (String) iterator.next();
                String value = mMap.get(key);
                jsonObject.put(key,value);
            }
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            bufferedWriter.write(String.valueOf(jsonObject));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            //Connect INTERNET
            connection.connect();
            //----------------------
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String result;
            while((result = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(result);
            }
            result = stringBuffer.toString();
            JSONObject jsonObject1 = new JSONObject(result);
            publishProgress(true);
            return jsonObject1;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}


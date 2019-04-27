package com.example.user.midterm_adv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btnLog;
    String mUser = "", mPass = "";
    EditText edtUser, edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getId();
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onValidateForm())
                {
                    final Map<String, String> mMap = new HashMap<>();
                    mMap.put("user_name", mUser);
                    mMap.put("password", mPass);
                    new LoginAsynctask(mMap, new LoginView() {
                        @Override
                        public void onLoginSuccess(String m, int id) {

                            Toast.makeText(MainActivity.this,m , Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, PhoneActivity.class);
                            intent.putExtra("user_id", id);
                            startActivity(intent);
                        }

                        @Override
                        public void onLoginFail(String m) {
                            Toast.makeText(MainActivity.this,m,Toast.LENGTH_SHORT).show();
                        }
                    }, MainActivity.this).execute("http://www.vidophp.tk/api/account/signin");

                }
            }
        });
    }

    private void getId() {
        btnLog = findViewById(R.id.id_btnLog);
        edtPass =  findViewById(R.id.id_edt_pass);
        edtUser = findViewById(R.id.id_edt_user);
    }
    private boolean onValidateForm(){
        mUser = edtUser.getText().toString();
        if (mUser.length() < 1){
            edtUser.setError("Username field cannot be blank");
            return false;
        }

        mPass = edtPass.getText().toString();
        if (mPass.length() < 1){
            edtPass.setError("Password field cannot be blank");
            return  false;
        }
        return true;
    }
}

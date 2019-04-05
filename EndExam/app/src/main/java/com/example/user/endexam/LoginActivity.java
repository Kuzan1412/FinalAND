package com.example.user.endexam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btnLog, btnRemember, btnClear;
    EditText edtUser, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        run();
        runPreference();
        if(IsLogOut())
        {

        }
        else
        {
            Intent intent = new Intent(LoginActivity.this, MainTabLayout.class);
            startActivity(intent);
        }
        String savedUser = sharedPreferences.getString("User", "");
        String savedPass = sharedPreferences.getString("Pass", "");
        edtUser.setText(savedUser);
        edtPass.setText(savedPass);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onValidate())
                {
                    if (edtUser.getText().toString().equals("19") && edtPass.getText().toString().equals("12345"))
                    {
                        Toast.makeText(LoginActivity.this, "Successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MainTabLayout.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(LoginActivity.this, "Error! User : 1706020029", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(v == btnRemember)
               {
                   String dataUser = edtUser.getText().toString();
                   String dataPass = edtPass.getText().toString();
                   editor.putString("User", dataUser);
                   editor.putString("Pass", dataPass);
                   editor.commit();
               }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnClear)
                {
                    edtPass.setText("");
                    edtUser.setText("");
                    editor.clear();
                    editor.commit();
                }
            }
        });
    }


    private boolean IsLogOut()
    {
        boolean EmptyUser = sharedPreferences.getString("User", "").isEmpty();
        boolean EmptyPass = sharedPreferences.getString("Pass", "").isEmpty();
        return EmptyPass || EmptyUser;

    }
    private boolean onValidate() {
        if (edtUser.getText().toString().length() < 1 )
        {
            edtUser.setError("Please, you must fill username");
            return false;
        }
        if(edtPass.getText().toString().length() < 1)
        {
            edtPass.setError("Please, you must fill password");
            return false;
        }

        return true;
    }

    private  void runPreference()
    {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }
    private void run() {
        edtUser = findViewById(R.id.id_edt_user);
        edtPass = findViewById(R.id.id_edt_pass);
        btnLog = findViewById(R.id.id_btnLog);
        btnClear = findViewById(R.id.id_btn_Clear);
        btnRemember = findViewById(R.id.id_btn_Remember);
    }
}

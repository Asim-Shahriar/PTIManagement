package com.example.ptimanagement;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etName.getText().toString();
                String password = etPassword.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String savedPassword = preferences.getString(password, "");
                String savedUserName = preferences.getString(user, "");

                /*String userDetails = preferences.getString(user + password + "data","No information on that user.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",userDetails);
                editor.commit();*/
                if((user.equals(savedUserName)) && (password.equals(savedPassword))){
                    Intent displayScreen = new Intent(MainActivity.this, NavigationDrawerActivity.class);
                    startActivity(displayScreen);
                }else{
                    Toast.makeText(MainActivity.this,"Wrong Info",Toast.LENGTH_SHORT).show();
                }

            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(registerScreen);
            }
        });
    }
}

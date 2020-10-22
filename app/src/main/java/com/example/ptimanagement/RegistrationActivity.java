package com.example.ptimanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText userName = (EditText) findViewById(R.id.etNewName);
        final EditText password = (EditText) findViewById(R.id.etNewPassword);
        final EditText email = (EditText) findViewById(R.id.etNewEmail);
        Button btnRegister = (Button) findViewById(R.id.btnNewRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String newUser  = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                //stores 3 new instances of sharedprefs. Both the user and password's keys are the same as the input.
                //Must be done this way because sharedprefs is stupid and inefficient. You cannot store Arrays easily
                //so I use strings instead.
                editor.putString("user",newUser);
                editor.commit();
                editor.putString("password", newPassword);
                editor.commit();
                editor.putString("email", newEmail);
                editor.commit();
                Toast.makeText(RegistrationActivity.this,"Registration Completed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
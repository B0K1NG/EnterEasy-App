package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {

    EditText email, pw, name, surname;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.editTextTextEmailAddress2);
        pw = findViewById(R.id.editTextTextPassword2);
        name =  findViewById(R.id.editTextTextMultiLine2);
        surname = findViewById(R.id.editTextTextMultiLine);
        dbHelper = new DBHelper(this);

        Button button = findViewById(R.id.button3);  // Correct the button ID
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail, pass, fname, lname;
                mail = email.getText().toString();
                pass = pw.getText().toString();
                fname = name.getText().toString();
                lname = surname.getText().toString();

                if (mail.equals("") || pass.equals("") || fname.equals("") || lname.equals("")){
                    Toast.makeText(SignUp.this, "Please fill all the fields.", Toast.LENGTH_LONG).show();
                } else {
                    if (dbHelper.checkMail(mail)) {
                        Toast.makeText(SignUp.this, "Email already in use.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    boolean registeredSuccess = dbHelper.insertData(mail, pass);
                    if (registeredSuccess) {
                        Toast.makeText(SignUp.this, "User registered successfully.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUp.this, SignIn.class);  // Ensure correct context and class
                        startActivity(intent);
                    }else {
                        Toast.makeText(SignUp.this, "User registration failed.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
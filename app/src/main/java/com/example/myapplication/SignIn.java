package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignIn extends AppCompatActivity {

    EditText un, pw;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        un = findViewById(R.id.editTextTextEmailAddress);
        pw = findViewById(R.id.editTextTextPassword);
        dbHelper = new DBHelper(this);

        // Set up the sign-up text to be clickable
        TextView signUpText = findViewById(R.id.textView4);  // Make sure the ID matches your XML
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start an activity for signing up
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });
        Button button = findViewById(R.id.button2);  // Correct the button ID
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isLoggedId = dbHelper.checkUser(un.getText().toString(), pw.getText().toString());
                if (isLoggedId) {
                    Intent intent = new Intent(SignIn.this, HomePage.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignIn.this, "Login failed.", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(SignIn.this, HomePage.class);  // Ensure correct context and class
                startActivity(intent);
            }
        });
    }
}
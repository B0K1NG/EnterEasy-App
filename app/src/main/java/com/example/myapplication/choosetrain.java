package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class choosetrain extends AppCompatActivity {

    Button button_a_930;
    Button button_a_1130;
    Button button_b_1015;
    Button button_b_1245;
    Button button_c_830;
    Button button_c_1100;
    Button gobackbutton;
    ImageButton home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.choose_a_train);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.choose_a_train), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button_a_930=(Button)findViewById(R.id.button_a_930);
        button_a_1130=(Button)findViewById(R.id.button_a_1130);
        button_b_1015=(Button)findViewById(R.id.button_b_1015);
        button_b_1245=(Button)findViewById(R.id.button_b_1245);
        button_c_830=(Button)findViewById(R.id.button_c_830);
        button_c_1100=(Button)findViewById(R.id.button_c_1100);
        gobackbutton=(Button)findViewById(R.id.gobackbutton);
        home=(ImageButton)findViewById(R.id.homebutton);

        button_a_930.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(choosetrain.this, traina930.class);
                startActivity(intent);
            }
        });

        button_a_1130.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(choosetrain.this, traina1130.class);
                startActivity(intent);
            }
        });

        button_b_1015.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(choosetrain.this, trainb1015.class);
                startActivity(intent);
            }
        });

        button_b_1245.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(choosetrain.this, trainb1245.class);
                startActivity(intent);
            }
        });

        button_c_830.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(choosetrain.this, trainc830.class);
                startActivity(intent);
            }
        });

        button_c_1100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(choosetrain.this, trainc1100.class);
                startActivity(intent);
            }
        });

        gobackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(choosetrain.this, HomePage.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(choosetrain.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}
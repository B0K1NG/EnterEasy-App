package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chat extends AppCompatActivity {

    private EditText editTextMessage;
    private LinearLayout llConversation;
    Button gobackbutton;
    ImageButton home;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextMessage = findViewById(R.id.editTextMessage);
        Button buttonSend = findViewById(R.id.buttonSend);
        llConversation = findViewById(R.id.llConversation);
        gobackbutton=(Button)findViewById(R.id.gobackbutton);
        home=(ImageButton)findViewById(R.id.homebutton);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString().trim();
                if (!message.isEmpty()) {
                    sendMessage(message);
                    editTextMessage.setText("");
                }
            }
        });

        gobackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(Chat.this, HomePage.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(Chat.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    private void sendMessage(String message) {
      
        TextView textViewMessage = createTextView(message);
        textViewMessage.setBackgroundResource(R.drawable.sent_message_bg);
        LinearLayout.LayoutParams paramsSentMessage = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        paramsSentMessage.gravity = Gravity.END;
        textViewMessage.setLayoutParams(paramsSentMessage);

        
        llConversation.addView(textViewMessage);

        
        String response = getResponse(message);

        
        TextView textViewResponse = createTextView(response);
        textViewResponse.setBackgroundResource(R.drawable.received_message_bg);
        LinearLayout.LayoutParams paramsReceivedMessage = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        paramsReceivedMessage.gravity = Gravity.START;
        textViewResponse.setLayoutParams(paramsReceivedMessage);

        // Add the received response TextView to the conversation layout
        llConversation.addView(textViewResponse);
    }



    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
       
        layoutParams.setMargins(32, 16, 32, 16); 
        textView.setLayoutParams(layoutParams);
        return textView;
    }


    private String getResponse(String message) {

        if (message.equalsIgnoreCase("hello")) {
            return "Hi there!";
        } else if (message.equalsIgnoreCase("platform c")) {
            return "Platform C is accessible. There's an elevator nearby, and the ramp system is available for easy access.";
        } else if (message.equalsIgnoreCase("platform b")) {
            return "The second elevator is not working but the ramp system is available.";
        } else if (message.equalsIgnoreCase("platform a")) {
            return "Unfortunately, there is a ramp malfunction at platform A.";
        } else if (message.equalsIgnoreCase("how are you?")) {
            return "I'm doing well, thanks for asking!";
        } else if (message.equalsIgnoreCase("help")) {
            return " If you need assistance, the station guards can help you navigate through the station";
        } else {
            return "Sorry, I didn't understand that.";
        }
    }
}

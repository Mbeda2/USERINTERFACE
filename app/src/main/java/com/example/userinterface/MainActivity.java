package com.example.userinterface;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button myButton;
    EditText nameEditText;
    private android.R.attr R;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@SuppressLint("ResourceType") Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout); // Make sure your layout file is activity_main.xml
        nameEditText = findViewById(R.id);
        myButton = findViewById(R.id);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input text
                String name = nameEditText.getText().toString().trim();

                if (!name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Hello, " + name + "!", Toast.LENGTH_SHORT).show();





















































































































               } else {
                    Toast.makeText(MainActivity.this, "Please enter your name.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
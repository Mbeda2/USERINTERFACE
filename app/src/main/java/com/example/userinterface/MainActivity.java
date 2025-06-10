package com.example.userinterface;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare your UI elements
    EditText nameEditText;
    RadioGroup genderRadioGroup;
    RadioButton maleRadioButton, femaleRadioButton, otherRadioButton;
    CheckBox readingCheckBox, sportsCheckBox, codingCheckBox;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content view to your layout file (assuming it's named activity_main.xml)
        setContentView(R.layout.activity_main);

        // Initialize your UI elements by finding them by their IDs
        nameEditText = findViewById(R.id.editTextName);
        genderRadioGroup = findViewById(R.id.radioGroupGender);
        maleRadioButton = findViewById(R.id.radioButtonMale);
        femaleRadioButton = findViewById(R.id.radioButtonFemale);
        otherRadioButton = findViewById(R.id.radioButtonOther);
        readingCheckBox = findViewById(R.id.checkBoxReading);
        sportsCheckBox = findViewById(R.id.checkBoxSports);
        codingCheckBox = findViewById(R.id.checkBoxCoding);
        submitButton = findViewById(R.id.buttonSubmit);

        // Set an OnClickListener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input name
                String name = nameEditText.getText().toString().trim();

                // Get the selected gender
                String gender = "";
                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                if (selectedGenderId != -1) { // Check if any radio button is selected
                    RadioButton selectedRadioButton = findViewById(selectedGenderId);
                    gender = selectedRadioButton.getText().toString();
                }

                // Get selected hobbies
                StringBuilder hobbies = new StringBuilder();
                if (readingCheckBox.isChecked()) {
                    hobbies.append("Reading ");
                }
                if (sportsCheckBox.isChecked()) {
                    hobbies.append("Sports ");
                }
                if (codingCheckBox.isChecked()) {
                    hobbies.append("Coding ");
                }
                String hobbiesString = hobbies.toString().trim();

                // Build the toast message
                if (!name.isEmpty()) {
                    String message = "Hello, " + name + "!";
                    if (!gender.isEmpty()) {
                        message += " You are " + gender + ".";
                    }
                    if (!hobbiesString.isEmpty()) {
                        message += " Your hobbies are: " + hobbiesString + ".";
                    }
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter your name.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
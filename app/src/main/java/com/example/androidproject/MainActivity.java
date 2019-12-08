package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    //Name all widgets
    EditText enterName, enterAge, enterWeight;
    RadioGroup radioGroup;
    RadioButton male, female;
    Button letsStart;
    String age, name, weight, checked, maleValue, femaleValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find widgets and set them to name
        enterName = findViewById(R.id.EnterName);
        enterAge = findViewById(R.id.EnterAge);
        enterWeight = findViewById(R.id.EnterWeight);
        letsStart = findViewById(R.id.LetsStart);
        radioGroup = findViewById(R.id.radioGroup);
        male = findViewById(R.id.btnMale);
        female = findViewById(R.id.btnFemale);
        //clears text on create
        enterName.getText().clear();
        enterWeight.getText().clear();
        enterAge.getText().clear();

        //sets listener to button letsStart
        letsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creates new intent to move to another activity
                Intent i = new Intent(MainActivity.this,InformationScreen.class);
                //bundles all info to be used in next intent
                age = enterAge.getText().toString();
                name = enterName.getText().toString();
                weight = enterWeight.getText().toString();
                maleValue = male.getText().toString();
                femaleValue = female.getText().toString();
                //gathers the checked button
                checked = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
                //adds an id to the info names
                i.putExtra("Male", maleValue);
                i.putExtra("Checked", checked);
                i.putExtra("NameValue", name);
                i.putExtra("AgeValue",age);
                i.putExtra("WeightValue", weight);
                i.putExtra("Male", maleValue);
                i.putExtra("Female", femaleValue);
                //Starts i hope???
                startActivity(i);
            }
        });
    }

}

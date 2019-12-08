package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

import static com.example.androidproject.R.*;
import static com.example.androidproject.R.id.AddExercises;
import static com.example.androidproject.R.id.CalorieValue;
import static com.example.androidproject.R.id.btnFemale;
import static com.example.androidproject.R.id.btnMale;
import static com.example.androidproject.R.id.radioGroup;

public class InformationScreen extends AppCompatActivity {
    TextView nameValue, ageValue, weightValue, genderValue, calorieValue;
    String name, age, weight, checked, maleValue, femaleValue;

    int femaleCalorie = 2000;
    int maleCalorie = 2500;
    Button Continue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_information_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameValue = findViewById(R.id.NameValue);
        ageValue = findViewById(R.id.AgeValue);
        weightValue = findViewById(R.id.WeightValue);
        genderValue = findViewById(R.id.GenderValue);
        calorieValue = findViewById(CalorieValue);
        Continue = findViewById(id.Continue);
        //gets info from previous activity by id and sets a new value
        name = getIntent().getExtras().getString("NameValue");
        nameValue.setText(name);
        age = getIntent().getExtras().getString("AgeValue");
        ageValue.setText(age);
        weight = getIntent().getExtras().getString("WeightValue");
        weightValue.setText(weight);
        checked = getIntent().getExtras().getString("Checked");
        genderValue.setText(checked);
        maleValue = getIntent().getExtras().getString("Male");
        femaleValue = getIntent().getExtras().getString("Female");
        //if statement to set male or female daily calories
        if(checked.equals(maleValue)){
            calorieValue.setText(String.valueOf(maleCalorie));
        } else if (checked.equals(femaleValue)){
            calorieValue.setText(String.valueOf(femaleCalorie));
        }
        //button to go to next activity
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(InformationScreen.this, CalorieMenu.class);
                a.putExtra("NameValue",name);
                startActivity(a);
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

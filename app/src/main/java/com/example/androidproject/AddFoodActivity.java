package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFoodActivity extends AppCompatActivity {
    EditText enterFood;
    EditText enterCalorie;
    Button delInfo, saveInfo;
    // create a value to later increment values in sharedpreferences
    private static int FoodAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //names all the widgets and finds them
        enterFood = findViewById(R.id.EnterFoodName);
        enterCalorie = findViewById(R.id.EnterCalories);
        delInfo = findViewById(R.id.deleteInformation);
        saveInfo = findViewById(R.id.saveInformation);
        //clears text in widget
        enterFood.getText().clear();
        enterCalorie.getText().clear();
        //button to save info into sharedpreferences and go back to infoscreen
        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to go back to infoscreen
                Intent a = new Intent(AddFoodActivity.this, InformationScreen.class);
                //sharedprefs name
                SharedPreferences myPrefs = getSharedPreferences("ProjectPrefs", MODE_PRIVATE);
                //sharedprefs editor
                SharedPreferences.Editor myPrefEditor = myPrefs.edit();
                //names value at the widget
                String foodsNumber = enterFood.getText().toString();
                int foodsCalorie = Integer.valueOf(enterCalorie.getText().toString());
                //puts values into editors with id
                myPrefEditor.putString("Food #" + FoodAmount, foodsNumber);
                myPrefEditor.putInt("Food's Calorie #" + FoodAmount, foodsCalorie);
                //updates prefeditor Apply>commit :D
                myPrefEditor.apply();
                //once button is clicked, text is shown to user
                Toast toast = Toast.makeText(AddFoodActivity.this, "Information Saved!", Toast.LENGTH_SHORT);
                toast.show();
                //increments foodamount to create a new food item
                FoodAmount++;
                //sets id to return info back to calorieMenu
                setResult(RESULT_OK, a);
                finish();
            }
        });
        delInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button to delete all food information from sharedpreferences
                SharedPreferences myPrefs = getSharedPreferences("ProjectPrefs", MODE_PRIVATE);
                SharedPreferences.Editor myPrefEditor = myPrefs.edit();
                myPrefEditor.remove("Food #" + 0);
                myPrefEditor.remove("Food #" + 1);
                myPrefEditor.remove("Food #" + 2);
                myPrefEditor.remove("Food #" + 3);
                myPrefEditor.remove("Food #" + 4);
                myPrefEditor.remove("Food's Calorie #" + 0);
                myPrefEditor.remove("Food's Calorie #" + 1);
                myPrefEditor.remove("Food's Calorie #" + 2);
                myPrefEditor.remove("Food's Calorie #" + 3);
                myPrefEditor.remove("Food's Calorie #" + 4);
                myPrefEditor.apply();
                //shows text that the info was deleted
                Toast delete = Toast.makeText(AddFoodActivity.this, "Information Deleted!", Toast.LENGTH_SHORT);
                delete.show();

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;

    }
}


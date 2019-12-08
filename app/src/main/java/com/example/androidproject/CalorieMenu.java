package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalorieMenu extends AppCompatActivity {
    //Naming all the widgets
    Button addFoods, addExercises, result;
    TextView nameMenu, calorieConsumed, calorieLost, todayCalorie, foodName, exerciseName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_menu);
        //creates back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //sets the widgets to the name values
        addFoods = findViewById(R.id.AddFoods);
        addExercises = findViewById(R.id.AddExercises);
        nameMenu = findViewById(R.id.NameValue2);
        foodName = findViewById(R.id.FoodName2Value);
        exerciseName = findViewById(R.id.ExerciseNameValue);
        result = findViewById(R.id.Result);
        calorieConsumed = findViewById(R.id.CalorieConsumedValue);
        calorieLost = findViewById(R.id.CaloriesLostValue);
        todayCalorie = findViewById(R.id.TotalCaloriesValue);
        //calling Name value from InfoScreen
        name = getIntent().getExtras().getString("NameValue");
        //sets Name
        nameMenu.setText(name);
        //adding a listener to button
        addFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this gets the request code from the addFoodActivity class to get values
                startActivityForResult(new Intent(CalorieMenu.this, AddFoodActivity.class), 999);
            }
        });
        addExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //same as addFoods
                startActivityForResult(new Intent(CalorieMenu.this, AddExercisesActivity.class), 111);
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //created 2 integer values and converted the text from the widget to an integer
                int num1 = Integer.valueOf(calorieConsumed.getText().toString());
                int num2 = Integer.valueOf(calorieLost.getText().toString());
                //added the two new integers to set it to a textview
                int sub = num1 - num2;
                todayCalorie.setText(Integer.toString(sub));
            }
        });
    }
//here I receive all the data from the AddFood and AddExercise activities with their different requestcodes
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999) {
            if (resultCode == RESULT_OK) {
                //calling sharedPreferences to get data
                SharedPreferences myPrefs = getSharedPreferences("ProjectPrefs", MODE_PRIVATE);
                //Adding values from sharedPrefs to strings
                String foodsNumber1 = myPrefs.getString("Food #" + 0, "");
                String foodsNumber2 = myPrefs.getString("Food #" + 1, "");
                String foodsNumber3 = myPrefs.getString("Food #" + 2, "");
                String foodsNumber4 = myPrefs.getString("Food #" + 3, "");
                String foodsNumber5 = myPrefs.getString("Food #" + 4, "");
                //here I combine all foodnumber strings to one
                String s = foodsNumber1 + "  " + foodsNumber2 + "  " + foodsNumber3 + " " + foodsNumber4 + " " + foodsNumber5;
                //naming three different integers from sharedprefs
                int calorieNumber1 = myPrefs.getInt("Food's Calorie #" + 0, 0);
                int calorieNumber2 = myPrefs.getInt("Food's Calorie #" + 1, 0);
                int calorieNumber3 = myPrefs.getInt("Food's Calorie #" + 2, 0);
                int calorieNumber4 = myPrefs.getInt("Food's Calorie #" + 3, 0);
                int calorieNumber5 = myPrefs.getInt("Food's Calorie #" + 4, 0);
                //adding all calories for textview
                int total = calorieNumber1 + calorieNumber2 + calorieNumber3 + calorieNumber4 + calorieNumber5;
                foodName.setText(s);
                calorieConsumed.setText(Integer.toString(total));
            }
        } else if (requestCode == 111) {
            if (resultCode == RESULT_OK) {
                SharedPreferences myPrefs = getSharedPreferences("ProjectPrefs", MODE_PRIVATE);
                String exerciseNumber1 = myPrefs.getString("Exercise #" + 0, "");
                String exerciseNumber2 = myPrefs.getString("Exercise #" + 1, "");
                String exerciseNumber3 = myPrefs.getString("Exercise #" + 2, "");
                String exerciseNumber4 = myPrefs.getString("Exercise #" + 3, "");
                String exerciseNumber5 = myPrefs.getString("Exercise #" + 4, "");
                String b = exerciseNumber1 + "  " + exerciseNumber2 + "  " + exerciseNumber3 + " " + exerciseNumber4 + " " + exerciseNumber5;

                int calorieLost1 = myPrefs.getInt("Exercise's Calorie #" + 0, 0);
                int calorieLost2 = myPrefs.getInt("Exercise's Calorie #" + 1, 0);
                int calorieLost3 = myPrefs.getInt("Exercise's Calorie #" + 2, 0);
                int calorieLost4 = myPrefs.getInt("Exercise's Calorie #" + 3, 0);
                int calorieLost5 = myPrefs.getInt("Exercise's Calorie #" + 4, 0);

                int lost = calorieLost1 + calorieLost2 + calorieLost3 + calorieLost4 + calorieLost5;
                exerciseName.setText(b);
                calorieLost.setText(Integer.toString(lost));
            }
        }
    }
//method for back button
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}



package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddExercisesActivity extends AppCompatActivity {
    EditText enterExercise, enterLost;
    Button saveInformation, deleteInformation;
    private static int ExerciseAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercises);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        enterExercise = findViewById(R.id.EnterExerciseName);
        enterLost = findViewById(R.id.EnterCaloriesLost);
        saveInformation = findViewById(R.id.saveInformation2);
        deleteInformation= findViewById(R.id.deleteInformation2);

        enterExercise.getText().clear();
        enterLost.getText().clear();

        saveInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AddExercisesActivity.this, InformationScreen.class);
                SharedPreferences myPrefs = getSharedPreferences("ProjectPrefs", MODE_PRIVATE);
                SharedPreferences.Editor myPrefEditor = myPrefs.edit();

                String exercisesNumber = enterExercise.getText().toString();
                int exercisesCalorie = Integer.valueOf(enterLost.getText().toString());
                myPrefEditor.putString("Exercise #" + ExerciseAmount, exercisesNumber);
                myPrefEditor.putInt("Exercise's Calorie #" + ExerciseAmount, exercisesCalorie);
                myPrefEditor.apply();

                Toast toast = Toast.makeText(AddExercisesActivity.this, "Information Saved!", Toast.LENGTH_SHORT);
                toast.show();
                ExerciseAmount++;
                setResult(RESULT_OK, a);
                finish();
            }
        });
        deleteInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myPrefs = getSharedPreferences("ProjectPrefs", MODE_PRIVATE);
                SharedPreferences.Editor myPrefEditor = myPrefs.edit();
                //button that deletes all exercise information
                myPrefEditor.remove("Exercise #" + 0);
                myPrefEditor.remove("Exercise #" + 1);
                myPrefEditor.remove("Exercise #" + 2);
                myPrefEditor.remove("Exercise #" + 3);
                myPrefEditor.remove("Exercise #" + 4);
                myPrefEditor.remove("Exercise's Calorie #" + 0);
                myPrefEditor.remove("Exercise's Calorie #" + 1);
                myPrefEditor.remove("Exercise's Calorie #" + 2);
                myPrefEditor.remove("Exercise's Calorie #" + 3);
                myPrefEditor.remove("Exercise's Calorie #" + 4);
                myPrefEditor.apply();
                //text that shows that the info was deleted
                Toast delete = Toast.makeText(AddExercisesActivity.this, "Information Deleted!", Toast.LENGTH_LONG);
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

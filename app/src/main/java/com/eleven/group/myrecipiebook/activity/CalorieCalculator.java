package com.eleven.group.myrecipiebook.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.eleven.group.myrecipiebook.R;
import com.eleven.group.myrecipiebook.model.User;

import static android.R.attr.y;
import static com.eleven.group.myrecipiebook.R.id.toolbar;

public class CalorieCalculator extends AppCompatActivity {

    Toolbar toolbar;
    double menBMR;
    double womenBMR;
    int age;

    RadioGroup radioGroup;
    RadioButton radioGenderButton;
    NumberPicker ageNumber;
    TextView weight;
    TextView height;
    TextView calories;
    Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupView();
    }

    public void setupView(){
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        ageNumber = (NumberPicker) findViewById(R.id.npAge);
        weight = (TextView) findViewById(R.id.tvWeight);
        height = (TextView) findViewById(R.id.tvHeight);
        calories = (TextView) findViewById(R.id.tvCalories);
        btnCal = (Button) findViewById(R.id.btnCalculate);

        ageNumber.setMinValue(18);
        ageNumber.setMaxValue(60);
        ageNumber.setWrapSelectorWheel(true);

        ageNumber.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                age = newVal;  //Display the newly selected number from picker
            }
        });

        weight.setText(""+ 60);
        height.setText(""+ 164);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("btn clicked", "calorie");
                int selectedId = radioGroup.getCheckedRadioButtonId(); // get selected radio button
                radioGenderButton = (RadioButton) findViewById(selectedId); // find radiobutton
                Log.d("radioGenderButton: ", radioGenderButton.getText().toString());

                if(radioGenderButton.getText().toString().equals("Male")){
                    menBMR = (10*Integer.parseInt("60")) + (6.25*Integer.parseInt("164")) - (5*age) + 5;
                    calories.setText(Double.toString(menBMR));
                }
                else if(radioGenderButton.getText().toString().equals("Female")){
                    womenBMR = (10*Integer.parseInt("60")) + (6.25*Integer.parseInt("164")) - (5*age) - 161;
                    calories.setText(Double.toString(womenBMR));
                }
            }
        });
    }

}
package com.example.android.quizapptvseries;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public CustomDialog alert;
    public CollapsingToolbarLayout collapsingToolbar;
    public Toolbar toolbar;
    public ImageView first_ImageView;

    public String name;
    public int count;
    public RadioGroup rgq1, rgq3, rgq4, rgq6, rgq7, rgq10;
    public RadioButton r1q1, r2q1, r3q1, r4q1, r1q3, r2q3, r3q3, r4q3, r1q4, r2q4, r3q4, r4q4, r1q6, r2q6, r3q6, r4q6, r1q7, r2q7, r3q7, r4q7, r1q10, r2q10, r3q10, r4q10;
    public EditText editTextQ2, editTextQ9;
    public CheckBox checkBox1Q5, checkBox2Q5, checkBox3Q5, checkBox4Q5, checkBox1Q8, checkBox2Q8, checkBox3Q8, checkBox4Q8;
    public boolean q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;

    public ArrayList <String> answerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alert = new CustomDialog();
        alert.showDialog(MainActivity.this);
        name = alert.getName();
        setActionOnScrollUp();

        instantiateObject();

        first_ImageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this)
                .load(R.drawable.dexter)
                .fit()
                .centerCrop()
                .into(first_ImageView);
    }

    //initialize all needed obj
    public void instantiateObject(){
        count = 0;
        answerList = new ArrayList<>();
        q1 = q2 = q3 = q4 = q5 = q6 = q7 = q8 = q9 = q10 = false;
        rgq1 = (RadioGroup) findViewById(R.id.radio_groupQ1);
        r1q1 = (RadioButton) findViewById(R.id.radio1Q1);
        r2q1 = (RadioButton) findViewById(R.id.radio2Q1);
        r3q1 = (RadioButton) findViewById(R.id.radio3Q1);
        r4q1 = (RadioButton) findViewById(R.id.radio4Q1);
        editTextQ2 = (EditText) findViewById(R.id.editTextQ2);
        rgq3 = (RadioGroup) findViewById(R.id.radio_groupQ3);
        r1q3 = (RadioButton) findViewById(R.id.radio1Q3);
        r2q3 = (RadioButton) findViewById(R.id.radio2Q3);
        r3q3 = (RadioButton) findViewById(R.id.radio3Q3);
        r4q3 = (RadioButton) findViewById(R.id.radio4Q3);
        rgq4 = (RadioGroup) findViewById(R.id.radio_groupQ4);
        r1q4 = (RadioButton) findViewById(R.id.radio1Q4);
        r2q4 = (RadioButton) findViewById(R.id.radio2Q4);
        r3q4 = (RadioButton) findViewById(R.id.radio3Q4);
        r4q4 = (RadioButton) findViewById(R.id.radio4Q4);
        checkBox1Q5 = (CheckBox) findViewById(R.id.checkbox1Q5);
        checkBox2Q5 = (CheckBox) findViewById(R.id.checkbox2Q5);
        checkBox3Q5 = (CheckBox) findViewById(R.id.checkbox3Q5);
        checkBox4Q5 = (CheckBox) findViewById(R.id.checkbox4Q5);
        rgq6 = (RadioGroup) findViewById(R.id.radio_groupQ6);
        r1q6 = (RadioButton) findViewById(R.id.radio1Q6);
        r2q6 = (RadioButton) findViewById(R.id.radio2Q6);
        r3q6 = (RadioButton) findViewById(R.id.radio3Q6);
        r4q6 = (RadioButton) findViewById(R.id.radio4Q6);
        rgq7 = (RadioGroup) findViewById(R.id.radio_groupQ7);
        r1q7 = (RadioButton) findViewById(R.id.radio1Q7);
        r2q7 = (RadioButton) findViewById(R.id.radio2Q7);
        r3q7 = (RadioButton) findViewById(R.id.radio3Q7);
        r4q7 = (RadioButton) findViewById(R.id.radio4Q7);
        checkBox1Q8 = (CheckBox) findViewById(R.id.checkbox1Q8);
        checkBox2Q8 = (CheckBox) findViewById(R.id.checkbox2Q8);
        checkBox3Q8 = (CheckBox) findViewById(R.id.checkbox3Q8);
        checkBox4Q8 = (CheckBox) findViewById(R.id.checkbox4Q8);
        editTextQ9 = (EditText) findViewById(R.id.editTextQ9);
        rgq10 = (RadioGroup) findViewById(R.id.radio_groupQ10);
        r1q10 = (RadioButton) findViewById(R.id.radio1Q10);
        r2q10 = (RadioButton) findViewById(R.id.radio2Q10);
        r3q10 = (RadioButton) findViewById(R.id.radio3Q10);
        r4q10 = (RadioButton) findViewById(R.id.radio4Q10);
    }

    //Set text on actionBar when scrolling up.
    public void setActionOnScrollUp() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbar.setTitle("TV Series - Quiz");
        collapsingToolbar.setExpandedTitleColor(ResourcesCompat.getColor(getResources(), android.R.color.transparent, null));
    }

    //check answer from question 1
    public void checkQ1(){
        switch (rgq1.getCheckedRadioButtonId()){
            case R.id.radio1Q1:
                q1 = false;
                answerList.set(1,r1q1.getText().toString());
                break;
            case R.id.radio2Q1:
                q1 = false;
                answerList.set(1,r2q1.getText().toString());
                break;
            case R.id.radio3Q1:
                q1 = false;
                answerList.set(1,r3q1.getText().toString());
                break;
            case R.id.radio4Q1:
                q1 = true;
                answerList.set(1,r4q1.getText().toString());
                count++;
                break;
        }
    }

    //check answer from question 2
    public void checkQ2(){
        String value;
        value = editTextQ2.getText().toString().toUpperCase();
        if(value.equals("DAREDEVIL")) {
            q2 = true;
            count++;
        }else q2 = false;
        answerList.set(2,value);
    }

    //check answer from question 3
    public void checkQ3(){
        switch (rgq3.getCheckedRadioButtonId()){
            case R.id.radio1Q3:
                q3 = false;
                answerList.set(3, r1q3.getText().toString());
                break;
            case R.id.radio2Q3:
                q3 = false;
                answerList.set(3, r2q3.getText().toString());
                break;
            case R.id.radio3Q3:
                q3 = false;
                answerList.set(3, r3q3.getText().toString());
                break;
            case R.id.radio4Q3:
                q3 = true;
                answerList.set(3, r4q3.getText().toString());
                count++;
                break;
        }
    }

    //check answer from question 4
    public void checkQ4(){
        switch (rgq4.getCheckedRadioButtonId()){
            case R.id.radio1Q4:
                q4 = false;
                answerList.set(4, r1q4.getText().toString());
                break;
            case R.id.radio2Q4:
                q4 = true;
                answerList.set(4, r2q4.getText().toString());
                count++;
                break;
            case R.id.radio3Q4:
                q4 = false;
                answerList.set(4, r3q4.getText().toString());
                break;
            case R.id.radio4Q4:
                q4 = false;
                answerList.set(4, r4q4.getText().toString());
                break;
        }
    }

    //check answer from question 5
    public void checkQ5() {
        String value = " ";
        if(checkBox1Q5.isChecked()){
            value += checkBox1Q5.getText().toString();
        }
        if(checkBox2Q5.isChecked()){
            value += checkBox2Q5.getText().toString();
        }
        if(checkBox1Q5.isChecked()){
            value += checkBox3Q5.getText().toString();
        }
        if(checkBox1Q5.isChecked()){
            value += checkBox4Q5.getText().toString();
        }
        if (checkBox2Q5.isChecked() && checkBox3Q5.isChecked()) {
            q5 = true;
            value = checkBox2Q5.getText().toString().concat(" " + checkBox3Q5.getText().toString());
            count++;
        }
        answerList.set(5, value);
    }

    //check answer from question 6
    public void checkQ6(){
        switch (rgq6.getCheckedRadioButtonId()){
            case R.id.radio1Q6:
                q6 = false;
                answerList.set(6, r1q6.getText().toString());
                break;
            case R.id.radio2Q6:
                q6 = false;
                answerList.set(6, r2q6.getText().toString());
                break;
            case R.id.radio3Q6:
                q6 = false;
                answerList.set(6, r3q6.getText().toString());
                break;
            case R.id.radio4Q6:
                q6 = true;
                answerList.set(6, r4q6.getText().toString());
                count++;
                break;
        }
    }

    //check answer from question 7
    public void checkQ7(){
        switch (rgq7.getCheckedRadioButtonId()){
            case R.id.radio1Q7:
                q7 = false;
                answerList.set(7, r1q7.getText().toString());
                break;
            case R.id.radio2Q7:
                q7 = true;
                answerList.set(7, r2q7.getText().toString());
                count++;
                break;
            case R.id.radio3Q7:
                q7 = false;
                answerList.set(7, r3q7.getText().toString());
                break;
            case R.id.radio4Q7:
                q7 = false;
                answerList.set(7, r4q7.getText().toString());
                break;
        }
    }

    //check answer from question 8
    public void checkQ8() {
        String value = " ";
        if(checkBox1Q8.isChecked()){
            value += checkBox1Q8.getText().toString();
        }
        if(checkBox2Q8.isChecked()){
            value += checkBox2Q8.getText().toString();
        }
        if(checkBox1Q8.isChecked()){
            value += checkBox3Q8.getText().toString();
        }
        if(checkBox1Q8.isChecked()){
            value += checkBox4Q8.getText().toString();
        }
        if (checkBox1Q8.isChecked() && checkBox1Q8.isChecked()) {
            q8 = true;
            value = checkBox1Q8.getText().toString().concat(" " + checkBox2Q8.getText().toString());
            count++;
        }
        answerList.set(8, value);
    }

    //check answer from question 9
    public void checkQ9(){
        String value;
        value = editTextQ9.getText().toString().toUpperCase();
        if(value.equals("3") || value.equals("THREE") || value.equals("TRE")) {
            q9 = true;
            count++;
        }else q9 = false;
        answerList.set(9,value);
    }

    //check answer from question 10
    public void checkQ10(){
        switch (rgq10.getCheckedRadioButtonId()){
            case R.id.radio1Q10:
                q10 = false;
                answerList.set(10, r1q10.getText().toString());
                break;
            case R.id.radio2Q10:
                q10 = true;
                answerList.set(10, r2q10.getText().toString());
                break;
            case R.id.radio3Q10:
                q10 = false;
                count++;
                answerList.set(10, r3q10.getText().toString());
                break;
            case R.id.radio4Q10:
                q10 = false;
                answerList.set(10, r4q10.getText().toString());
                break;
        }
    }

    //submit end question
    public void submit(View view){
        Intent resultIntent = new Intent(MainActivity.this, Result.class);
        startActivity(resultIntent);
    }
}

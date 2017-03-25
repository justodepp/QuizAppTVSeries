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

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public CustomDialog alert;
    public CollapsingToolbarLayout collapsingToolbar;
    public Toolbar toolbar;
    public ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6,
                     imageView7, imageView8, imageView9, imageView10;

    public String name;
    public int count;
    public RadioGroup rgq1, rgq3, rgq4, rgq6, rgq7, rgq10;
    public RadioButton r1q1, r2q1, r3q1, r4q1, r1q3, r2q3, r3q3, r4q3, r1q4, r2q4, r3q4, r4q4, r1q6,
                       r2q6, r3q6, r4q6, r1q7, r2q7, r3q7, r4q7, r1q10, r2q10, r3q10, r4q10;
    public EditText editTextQ2, editTextQ9;
    public CheckBox checkBox1Q5, checkBox2Q5, checkBox3Q5, checkBox4Q5, checkBox1Q8, checkBox2Q8,
                    checkBox3Q8, checkBox4Q8;
    public boolean q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;

    public ArrayList <String> answerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            answerList = savedInstanceState.getStringArrayList("answerList");
            name = savedInstanceState.getString("name");
            q1 = savedInstanceState.getBoolean("q1");
            q2 = savedInstanceState.getBoolean("q2");
            q3 = savedInstanceState.getBoolean("q3");
            q4 = savedInstanceState.getBoolean("q4");
            q5 = savedInstanceState.getBoolean("q5");
            q6 = savedInstanceState.getBoolean("q6");
            q7 = savedInstanceState.getBoolean("q7");
            q8 = savedInstanceState.getBoolean("q8");
            q9 = savedInstanceState.getBoolean("q9");
            q10 = savedInstanceState.getBoolean("q10");
        } else instantiateObject();
    }

    // This callback is called only when there is a saved instance previously saved using
    // onSaveInstanceState(). We restore some state in onCreate() while we can optionally restore
    // other state here, possibly usable after onStart() has completed.
    // The savedInstanceState Bundle is same as the one used in onCreate().
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("answerList",answerList);
        outState.putString("name", name);
        outState.putBoolean("q1",q1);
        outState.putBoolean("q2",q2);
        outState.putBoolean("q3",q3);
        outState.putBoolean("q4",q4);
        outState.putBoolean("q5",q5);
        outState.putBoolean("q6",q6);
        outState.putBoolean("q7",q7);
        outState.putBoolean("q8",q8);
        outState.putBoolean("q9",q9);
        outState.putBoolean("q10",q10);
    }

    //initialize all needed obj
    public void instantiateObject(){
        count = 0;
        answerList = new ArrayList<>();
        answerList.add(0,"");

        alert = new CustomDialog();
        alert.showDialog(MainActivity.this);

        loadingImage();

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

        setActionOnScrollUp();
    }

    //load all image using Glide
    public void loadingImage(){
        imageView1 = (ImageView) findViewById(R.id.imageViewDexter);
        Glide.with(this)
                .load(R.drawable.dexter)
                .into(imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageViewDaredevil);
        Glide.with(this)
                .load(R.drawable.daredevil)
                .into(imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageViewArrow);
        Glide.with(this)
                .load(R.drawable.arrow)
                .into(imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageViewSense8);
        Glide.with(this)
                .load(R.drawable.sense8)
                .into(imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageViewBcs);
        Glide.with(this)
                .load(R.drawable.better_call_saul)
                .into(imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageViewStrangerT);
        Glide.with(this)
                .load(R.drawable.stranger_things)
                .into(imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageViewBB);
        Glide.with(this)
                .load(R.drawable.breaking_bad)
                .into(imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageViewLukeC);
        Glide.with(this)
                .load(R.drawable.luke_cage)
                .into(imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageViewSherlock);
        Glide.with(this)
                .load(R.drawable.sherlock)
                .into(imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageViewTwd);
        Glide.with(this)
                .load(R.drawable.the_walking_dead)
                .into(imageView10);
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
    public void checkQ1(View view){
        answerList.add(1,"");
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
    public void checkQ2(View view){
        String value;
        answerList.add(2,"");
        value = editTextQ2.getText().toString().toUpperCase();
        if(value.equals("DAREDEVIL")) {
            q2 = true;
            count++;
        }else q2 = false;
        answerList.set(2,value);
    }

    //check answer from question 3
    public void checkQ3(View view){
        answerList.add(3,"");
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
    public void checkQ4(View view){
        answerList.add(4,"");
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
    public void checkQ5(View view) {
        answerList.add(5,"");
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
    public void checkQ6(View view){
        answerList.add(6,"");
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
    public void checkQ7(View view){
        answerList.add(7,"");
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
    public void checkQ8(View view) {
        String value = " ";
        answerList.add(8,"");
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
    public void checkQ9(View view){
        String value;
        answerList.add(9,"");
        value = editTextQ9.getText().toString().toUpperCase();
        if(value.equals("3") || value.equals("THREE") || value.equals("TRE")) {
            q9 = true;
            count++;
        }else q9 = false;
        answerList.set(9,value);
    }

    //check answer from question 10
    public void checkQ10(View view){
        answerList.add(10,"");
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
        checkQ1(view);
        checkQ2(view);
        checkQ3(view);
        checkQ4(view);
        checkQ5(view);
        checkQ6(view);
        checkQ7(view);
        checkQ8(view);
        checkQ9(view);
        checkQ10(view);

        Intent resultIntent = new Intent(MainActivity.this, Result.class);
        Bundle resultBundle = new Bundle();

        resultBundle.putString("name", name);
        resultBundle.putInt("count", getCount());
        resultBundle.putStringArrayList("arrayList", answerList);

        resultIntent.putExtra("resultBundle",resultBundle);
        startActivity(resultIntent);
    }

    public int getCount(){
        return count;
    }

}

package com.example.android.quizapptvseries;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;


public class ReviewAnswer extends Activity{

    public ArrayList <String> arrayList;
    public Bundle reviewBundle;
    public Intent reviewIntent;
    public String name;

    public TextView nameAnswer, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9,
                    answer10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.check_answer);

        init();

        setResult();
    }

    public void init(){
        reviewIntent = getIntent();
        reviewBundle = reviewIntent.getBundleExtra("resultBundle");

        nameAnswer = (TextView) findViewById(R.id.nameAnswer);
        name = reviewBundle.getString("name");

        nameAnswer.setText(name+""+R.string.text_result);

        answer1 = (TextView) findViewById(R.id.answer1);
        answer2 = (TextView) findViewById(R.id.answer2);
        answer3 = (TextView) findViewById(R.id.answer3);
        answer4 = (TextView) findViewById(R.id.answer4);
        answer5 = (TextView) findViewById(R.id.answer5);
        answer6 = (TextView) findViewById(R.id.answer6);
        answer7 = (TextView) findViewById(R.id.answer7);
        answer8 = (TextView) findViewById(R.id.answer8);
        answer9 = (TextView) findViewById(R.id.answer9);
        answer10 = (TextView) findViewById(R.id.answer10);

        reviewIntent = getIntent();
        reviewBundle = reviewIntent.getBundleExtra("resultBundle");
    }

    public void setResult(){
        arrayList = reviewBundle.getStringArrayList("arrayList");

        answer1.setText(arrayList.get(1));
        answer2.setText(arrayList.get(2));
        answer3.setText(arrayList.get(3));
        answer4.setText(arrayList.get(4));
        answer5.setText(arrayList.get(5));
        answer6.setText(arrayList.get(6));
        answer7.setText(arrayList.get(7));
        answer8.setText(arrayList.get(8));
        answer9.setText(arrayList.get(9));
        answer10.setText(arrayList.get(10));
    }

    @Override
    public void onBackPressed(){
            Intent intent = new Intent(ReviewAnswer.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
    }
}

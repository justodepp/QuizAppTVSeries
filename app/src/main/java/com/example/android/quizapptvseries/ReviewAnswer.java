package com.example.android.quizapptvseries;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;

/**
 * Created by gacavalli on 21/03/2017.
 */

public class ReviewAnswer extends Activity{

    public MainActivity mainActivity;
    public ArrayList <String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.check_answer);

        setResult();
    }

    public void setResult(){
        arrayList = mainActivity.getArrayList();

    }

    @Override
    public void onBackPressed(){
            Intent intent = new Intent(ReviewAnswer.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
    }
}

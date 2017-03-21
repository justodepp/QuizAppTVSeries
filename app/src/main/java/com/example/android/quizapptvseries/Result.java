package com.example.android.quizapptvseries;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by gacavalli on 20/03/2017.
 */

public class Result extends Activity {

    private String text;
    public MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.result);

        mainActivity = new MainActivity();
        int count = mainActivity.getCount();
        text = "Hey, your score is "+count+"/10";
    }

    public void calculateResult(){
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2500);
                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.CENTER, 0, 0);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(Result.this, ReviewAnswer.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

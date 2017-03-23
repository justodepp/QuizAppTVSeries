package com.example.android.quizapptvseries;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class Result extends Activity {

    private String text;
    public Bundle resultBundle;
    public Intent resultIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.result);

        resultIntent = getIntent();
        resultBundle = resultIntent.getBundleExtra("resultBundle");

        int count = resultBundle.getInt("count");
        text = "Hey, your score is "+count+"/10";
    }

    public void calculateResult(View view){

        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 0);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(Result.this,MainActivity.class);
                    startActivity(intent);
                    /*Intent intent = new Intent(Result.this, ReviewAnswer.class);
                    resultBundle.putStringArrayList("arrayList",resultIntent.getStringArrayListExtra("arrayList"));
                    resultIntent.putExtra("resultBundle",resultBundle);
                    startActivity(intent);*/
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

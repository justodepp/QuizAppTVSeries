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
    public Bundle reviewBundle;
    public Intent reviewIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.result);

        reviewIntent = getIntent();
        reviewBundle = reviewIntent.getBundleExtra("resultBundle");

        int count = reviewBundle.getInt("count");
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
                    Intent intent = new Intent(Result.this,ReviewAnswer.class);

                    reviewBundle.putStringArrayList("arrayList",reviewIntent.getStringArrayListExtra("arrayList"));
                    reviewIntent.putExtra("reviewBundle",reviewBundle);

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

package com.example.android.quizapptvseries;

/**
 * Created by gacavalli on 17/03/2017.
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class CustomDialog extends Activity{

    String name;

    public void showDialog(Activity activity){
        // Create custom dialog object
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog);

        // set values for custom dialog components - text, image and button
        final EditText yourName = (EditText) dialog.findViewById(R.id.editText_wantYou);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_submitName);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                name = yourName.getText().toString();
                dialog.dismiss();
            }
        });
        dialog.show();

        //Grab the window of the dialog, and change the width
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        //This makes the dialog take up the full width
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    public String getName() {
        return name;
    }
}

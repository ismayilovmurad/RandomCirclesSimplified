package com.martiandeveloper.randomcircles;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyView myView;

    private FrameLayout activityMainContainerFL;
    private EditText activityMainNumberET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainContainerFL = findViewById(R.id.activity_main_containerFL);
        activityMainNumberET = findViewById(R.id.activity_main_numberET);

        findViewById(R.id.activity_main_drawMBTN).setOnClickListener(v -> {

            if ((activityMainNumberET.getText() != null && !activityMainNumberET.getText().toString().equals(""))) {

                try {

                    if (Float.parseFloat(activityMainNumberET.getText().toString()) >= 1 && Float.parseFloat(activityMainNumberET.getText().toString()) <= 20) {

                        ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                        if (myView != null) activityMainContainerFL.removeView(myView);

                        myView = new MyView(MainActivity.this, activityMainContainerFL.getWidth(), activityMainContainerFL.getHeight(), Integer.parseInt(activityMainNumberET.getText().toString()));
                        activityMainContainerFL.addView(myView);

                    } else
                        Toast.makeText(MainActivity.this, "Please enter a number between 1 and 20", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Please enter a number between 1 and 20", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

}

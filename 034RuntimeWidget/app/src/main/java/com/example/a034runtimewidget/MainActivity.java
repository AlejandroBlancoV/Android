package com.example.a034runtimewidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
ConstraintLayout constraintLayout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout=findViewById(R.id.layau);

        DatePicker datePicker = new DatePicker(this);
        datePicker.setId(View.generateViewId());
        constraintLayout.addView(datePicker);

        //crear constraints para el picker
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.centerHorizontally(datePicker.getId(), ConstraintSet.PARENT_ID);
        constraintSet.centerVertically(datePicker.getId(), ConstraintSet.PARENT_ID);
        constraintSet.applyTo(constraintLayout);


    }
}
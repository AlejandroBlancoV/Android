package com.example.a012gettingresults;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
Button button;
    String text;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView= findViewById(R.id.llegado);
        text = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        textView.setText(text);
        button= findViewById(R.id.volver);
        button.setOnClickListener(view -> volver(view));
    }
    public void volver(View view){
        Intent returnIntent= new Intent();
        returnIntent.putExtra(MainActivity.REQUEST_RESULT,text.toUpperCase());
        setResult(RESULT_OK,returnIntent);
        finish();

    }
}
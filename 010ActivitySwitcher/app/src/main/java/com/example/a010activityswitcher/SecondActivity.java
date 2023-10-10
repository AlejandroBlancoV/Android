package com.example.a010activityswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void onClikClose(View view){
        finish();
    }
    public void onClickSwitchtoFirst(View view){
        Intent intent2= new Intent(this, MainActivity.class);
        startActivity(intent2);
    }

}
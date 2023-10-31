package com.example.a025toggleswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements ToggleButton.OnCheckedChangeListener {

    ToggleButton toggleButton;
    Switch nintendo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton=findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> onCheckedChanged(buttonView,isChecked));
        nintendo = findViewById(R.id.switch2);
        nintendo.setOnCheckedChangeListener((button, Checked) -> manolito((Switch) button,Checked));

    }

    public void manolito(Switch button, boolean checked){
        ImageView imageView= findViewById(R.id.imageView);
        if(checked)
            imageView.setImageResource(R.drawable.avatar_3);
        else
            imageView.setImageResource(R.drawable.avatar_4);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ImageView imageView= findViewById(R.id.imageView);

        if(isChecked)
            imageView.setImageResource(R.drawable.avatar_1);
        else
            imageView.setImageResource(R.drawable.avatar_2);
    }
}
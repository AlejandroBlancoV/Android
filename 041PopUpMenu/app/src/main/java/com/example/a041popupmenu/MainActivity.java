package com.example.a041popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> showPopUpMenu(v));
    }

    private PopupMenu.OnMenuItemClickListener onMenuItemClickListener=
            new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int num=item.getItemId();

                    if(num==R.id.menu_reply){
                        Toast.makeText(MainActivity.this,"Reply",Toast.LENGTH_LONG).show();
                        return true;
                    }
                    if(num==R.id.menu_reply_all){
                        Toast.makeText(MainActivity.this,"Reply All",Toast.LENGTH_LONG).show();
                        return true;
                    }
                    if(num==R.id.menu_forward){
                        Toast.makeText(MainActivity.this,"Forward",Toast.LENGTH_LONG).show();
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            };
    public void showPopUpMenu(View view){
        PopupMenu popupMenu= new PopupMenu(MainActivity.this,view);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(onMenuItemClickListener);
        popupMenu.show();
    }
}
package com.example.ejemploej2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    ImageView mImagen;
    EditText meditText;
    Button mButton;
    Button mButton2;

    Button limpiar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImagen= findViewById(R.id.imageView);
        mButton= findViewById(R.id.button);
        mButton.setOnClickListener(view -> openAsset(view));
        mButton2= findViewById(R.id.botonImagen);
        mButton2.setOnClickListener(view -> loadImagenFromAsset(view));
        limpiar = findViewById(R.id.limpiar);
        limpiar.setOnClickListener(view -> clean());


    }

    private void openAsset(View view) {
        meditText= findViewById(R.id.editTextText);
        try {
            meditText.setText(getText(this.getAssets().open("mi_texto.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getText(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String newLine = null;

                while ((newLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(newLine + "\n");
                }

                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public void loadImagenFromAsset(View view){

        try {
            InputStream ims = this.getAssets().open("Panathinaikos_BC.png");
            Drawable d = Drawable.createFromStream(ims, null);
            mImagen.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
    public void clean(){
        meditText.setText("");
        mImagen.setImageDrawable(null);
    }
}
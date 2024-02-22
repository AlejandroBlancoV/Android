package com.example.a068enviarsms;



import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SMSActivity extends AppCompatActivity implements ReceptorSMS.OnRecibeSMS{


    public final String tag = "DemoSMS";
    ReceptorSMS receptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creamos y registramos el receptor de SMS de manera dinámica
        //En vez de declararlo en el manifest
        receptor = new ReceptorSMS();
        registerReceiver(receptor, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        receptor.setOnRecibeSMSListener(this);
        Button button= findViewById(R.id.button);
        button.setOnClickListener(view -> EnviaSMS(view));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receptor); // para que no haya pérdidas de memoria
        receptor = null;
    }

    // Método callback para pulsar el botón public


    public void EnviaSMS(View v) {
        EditText txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        EditText txtMensaje = (EditText) findViewById(R.id.txtMensaje);

        Log.i("OJO", "Enviando SMS ....");

        String telefono = txtTelefono.getText().toString();
        String message = txtMensaje.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telefono, null, message, null, null);

            Toast.makeText(getApplicationContext(), "SMS enviado.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS no enviado, por favor, inténtalo otra vez.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }




    @Override
    public void onRecibeSMS(String origen, String mensaje) {
        EditText editText = findViewById(R.id.txtMensaje);
        editText.setText("Mensaje de " + origen);
        EditText editText2 = findViewById(R.id.txtTelefono);
        editText2.setText("Mensaje: "+mensaje);

    }
}

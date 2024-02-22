package com.example.a072gestionalarma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAlarma(11,20);
    }
    public void setAlarma(int hora, int minutos) {
        Context mContexto=this;
        AlarmManager alarmMgr;
        PendingIntent alarmIntent;

        // Configurar calendario
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, minutos);

        // Crear alarma
        Intent intent = new Intent(mContexto, Alarma.class);
        alarmIntent = PendingIntent.getBroadcast(mContexto, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        alarmMgr = (AlarmManager) mContexto.getSystemService(Context.ALARM_SERVICE);
        if(alarmMgr!=null){
            alarmMgr.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY,
                    alarmIntent
            );
        }

    }

}
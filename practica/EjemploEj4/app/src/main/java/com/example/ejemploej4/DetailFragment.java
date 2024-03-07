package com.example.ejemploej4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    public static String KEY_COUNTRY_NAME = "KEY_COUNTRY_NAME";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    //Como coloco la info sekeccionada en el master?


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //RECORREMOS
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(KEY_COUNTRY_NAME)) {
            showSelectedCountry(bundle.getString(KEY_COUNTRY_NAME));
        }
    }

    void showSelectedCountry(String countryName) {
        ((TextView)getView().findViewById(R.id.textViewCountryName)).setText(countryName);
        if(countryName.equals("Austria")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Austria\nCapital: Viena\nPoblación: 8,932,664 millones\nTamaño: 83,855 km2");
        }
        if(countryName.equals("Belgica")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Belgica\nCapital: Bruselas\nPoblación: 11,566,041 millones\nTamaño: 30,528 km2");
        }
        if(countryName.equals("Bulgaria")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Bulgaria\nCapital: Sofía\nPoblación: 6,916,548 millones\nTamaño: 110,994 km2");
        }
        if(countryName.equals("Croacia")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Croacia\nCapital: Zagreb\nPoblación: 4,036,355 millones\nTamaño: 56,594 km2");
        }
        if(countryName.equals("Chequia")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Chequia\nCapital: Praga\nPoblación: 10,701,777 millones\nTamaño: 78,866 km2");
        }
        if(countryName.equals("Dinamarca")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Dinamarca\nCapital: Copenhague\nPoblación: 5,840,045 millones\nTamaño: 42,916 km2");
        }
        if(countryName.equals("Estonia")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Estonia\nCapital: Tallin\nPoblación: 1,330,068 millones\nTamaño: 45,227 km2");
        }
        if(countryName.equals("Finlandia")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Finlandia\nCapital: Helsinki\nPoblación: 5,533,793 millones\nTamaño: 338,424 km2");
        }
        if(countryName.equals("Francia")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Francia\nCapital: París\nPoblación: 67,439,599 millones\nTamaño: 551,695 km2");
        }
        if(countryName.equals("Alemania")){
            ((TextView)getView().findViewById(R.id.textViewCountryName)).setText("Alemania\nCapital: Berlín\nPoblación: 83,155,031 millones\nTamaño: 357,022 km2");
        }



    }
}

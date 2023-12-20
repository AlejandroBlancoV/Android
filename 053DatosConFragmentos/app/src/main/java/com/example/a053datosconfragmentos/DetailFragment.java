package com.example.a053datosconfragmentos;

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

    }
}

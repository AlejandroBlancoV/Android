package com.example.ejercicio4.ui.ejercicio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EjercicioViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EjercicioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
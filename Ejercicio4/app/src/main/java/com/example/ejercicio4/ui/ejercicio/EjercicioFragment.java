package com.example.ejercicio4.ui.ejercicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ejercicio4.databinding.FragmentEjercicioBinding;
import com.example.ejercicio4.databinding.FragmentGalleryBinding;

public class EjercicioFragment extends Fragment {

    private FragmentEjercicioBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EjercicioViewModel ejercicioViewModel =
                new ViewModelProvider(this).get(EjercicioViewModel.class);

        binding = FragmentEjercicioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView;
        textView = binding.textEjercicio;
        ejercicioViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
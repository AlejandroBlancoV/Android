package com.example.a029spinnerexamen;


import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class Adaptador  extends ArrayAdapter {
    public Adaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public Adaptador(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public Adaptador(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
    }

    public Adaptador(@NonNull Context context, int resource, int textViewResourceId, @NonNull Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public Adaptador(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    public Adaptador(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
    }
}

package com.example.a021recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {

    private List<Datos> nameList;
    public MiAdaptador(List<Datos> list){
        nameList=list;
    }

    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.elemento, parent,false);
        MiViewHolder myViewHolder= new MiViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        final Datos cadenas= nameList.get(position);


    holder.texto.setText(cadenas.getNombre());
    holder.detalle.setText(cadenas.getDescripcion());

    }

    @Override
    public int getItemCount() {
        if(nameList.isEmpty()){
            return 0;

        }
        else {
            return nameList.size();
        }
    }


    //Clase interna

    public class MiViewHolder extends RecyclerView.ViewHolder{
        public TextView texto;
        public TextView detalle;

        public MiViewHolder(View itemView){
            super(itemView);
            texto= itemView.findViewById(R.id.Texto);
            detalle= itemView.findViewById(R.id.Detalle);

        }
    }

}

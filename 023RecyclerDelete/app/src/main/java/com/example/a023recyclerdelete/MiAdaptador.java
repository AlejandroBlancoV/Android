package com.example.a023recyclerdelete;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {

    private List<Datos> nameList;
    public MiAdaptador(List<Datos> list){
        nameList=list;
    }

    public void añadir(){
        Datos pegote= new Datos("Pais extra","descripcion extra",0);
        nameList.add(pegote);
        notifyDataSetChanged();

    }


    //Suprime elemento de la lista
    private void suprime(int posicion){
        nameList.remove(posicion);
        notifyDataSetChanged();

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
    public void onBindViewHolder(@NonNull MiViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Datos cadenas= nameList.get(position);


    holder.texto.setText(cadenas.getNombre());
    holder.detalle.setText(cadenas.getDescripcion());
    holder.imagen.setImageResource(cadenas.getImagen());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            suprime(position);
        }
    });
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
        public ImageView imagen;

        public MiViewHolder(View itemView){
            super(itemView);
            texto= itemView.findViewById(R.id.texto);
            detalle= itemView.findViewById(R.id.detalle);
            imagen= itemView.findViewById(R.id.imagen);

        }
    }

}

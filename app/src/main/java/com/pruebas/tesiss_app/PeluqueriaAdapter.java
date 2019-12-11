package com.pruebas.tesiss_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeluqueriaAdapter extends RecyclerView.Adapter<PeluqueriaAdapter.MyViewHolder> {

     Context context;
    List<class_pelequeria> pelequeriaList;
    MovieItemClick movieItemClick;
    public PeluqueriaAdapter(Context context, List<class_pelequeria> pelequeriaList,MovieItemClick listener) {
        this.context = context;
        this.pelequeriaList = pelequeriaList;
        movieItemClick =  listener ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.items_peluqueria,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.nombre.setText(pelequeriaList.get(position).getNombre());
            holder.precio.setText(pelequeriaList.get(position).getPrecio());
            holder.Imagen_Pel.setImageResource(pelequeriaList.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return pelequeriaList.size();
    }



    public class MyViewHolder extends  RecyclerView.ViewHolder {

    private TextView nombre,precio;
    private ImageView Imagen_Pel;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            nombre=itemView.findViewById(R.id.textView2);
            precio=itemView.findViewById(R.id.textView3);
            Imagen_Pel=itemView.findViewById(R.id.image_peluqueria_list);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieItemClick.onMovieclick(pelequeriaList.get(getAdapterPosition()),Imagen_Pel);
                }
            });
        }

    }
}

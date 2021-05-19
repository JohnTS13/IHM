package com.example.ihm;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdaptador extends RecyclerView.Adapter<RecyclerviewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, temperatura, humedad, familia, reino, estado;
        ImageView fotoEstado ;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.txt_nombre);
            temperatura = (TextView) itemView.findViewById(R.id.txt_temperatura);
            humedad = (TextView) itemView.findViewById(R.id.txt_humedad);
            familia = (TextView) itemView.findViewById(R.id.txt_familia);
            reino = (TextView) itemView.findViewById(R.id.txt_reino);
            estado = (TextView) itemView.findViewById(R.id.txt_estado);
            fotoEstado = (ImageView) itemView.findViewById(R.id.imgEstado);
        }
    }

    public List<flor_planta> florLista;

    public RecyclerviewAdaptador(List<flor_planta> florLista)    {
        this.florLista = florLista;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planta,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.nombre.setText(florLista.get(position).getNombre());
        holder.temperatura.setText(florLista.get(position).getTemperatura());
        holder.humedad.setText(florLista.get(position).getHumedad());
        holder.familia.setText(florLista.get(position).getFamilia());
        holder.reino.setText(florLista.get(position).getReino());
        holder.estado.setText(florLista.get(position).getEstado());
        holder.fotoEstado.setImageResource(florLista.get(position).getImgEstado());
    }

    @Override
    public int getItemCount() {
        return florLista.size();
    }
}

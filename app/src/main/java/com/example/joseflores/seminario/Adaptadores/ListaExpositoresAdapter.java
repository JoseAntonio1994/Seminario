package com.example.joseflores.seminario.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.joseflores.seminario.Entidades.Expositor;
import com.example.joseflores.seminario.R;

import java.util.ArrayList;

public class ListaExpositoresAdapter extends RecyclerView.Adapter<ListaExpositoresAdapter.ExpositoresViewHolder>{

    private ArrayList<Expositor> listExpositores;

    public ListaExpositoresAdapter(ArrayList<Expositor> listExpositores) {
        this.listExpositores = listExpositores;
    }

    @NonNull
    @Override
    public ExpositoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expositor_item, null, false);

        return new ExpositoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpositoresViewHolder holder, int position) {

        holder.nomExpositor.setText(listExpositores.get(position).getNomExpositor());

        holder.calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return listExpositores.size();
    }

    public class ExpositoresViewHolder extends RecyclerView.ViewHolder{

        TextView nomExpositor;
        ImageButton calificar, consultar;

        public ExpositoresViewHolder(View view) {
            super(view);

            nomExpositor = (TextView) view.findViewById(R.id.txt_nomexpositor);

            calificar = (ImageButton) view.findViewById(R.id.imgBtnCalificar);
            consultar = (ImageButton) view.findViewById(R.id.imgBtnConsultar);
        }
    }

}

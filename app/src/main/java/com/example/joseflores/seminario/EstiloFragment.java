package com.example.joseflores.seminario;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.joseflores.seminario.Modelos.Nodos;
import com.example.joseflores.seminario.Modelos.Presentacion;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class EstiloFragment extends Fragment {

    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mLayout;

    private DatabaseReference mReference;
    private FirebaseRecyclerAdapter<Presentacion, EstiloAdapter> adapter;
    private FirebaseRecyclerOptions<Presentacion> options;


    public EstiloFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_add, menu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_estilo, container, false);

        mReference = FirebaseDatabase.getInstance().getReference().child(Nodos.ESTILO);

        mRecycler = (RecyclerView) view.findViewById(R.id.recycler_estilo);
        mLayout = new LinearLayoutManager(getContext());
        mRecycler.setLayoutManager(mLayout);
        mRecycler.setHasFixedSize(true);

        query();

        return view;
    }

    private void query() {

        options = new FirebaseRecyclerOptions.Builder<Presentacion>()
                .setQuery(mReference, Presentacion.class)
                .build();

        setupAdapter();

        mRecycler.setAdapter(adapter);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_add:

                newItem();

                break;

            default:
                return super.onOptionsItemSelected(item);

        }

        return true;
    }

    private void newItem() {

        String key = mReference.push().getKey();

        Presentacion fondo = new Presentacion(key, "Gramatica", 0);

        mReference.child(key).setValue(fondo);

    }

    private void setupAdapter() {

        adapter = new FirebaseRecyclerAdapter<Presentacion, EstiloAdapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final EstiloAdapter holder, int position, @NonNull final Presentacion model) {

                holder.nomFondo.setText(model.getNombreFondo());

                holder.puntaje.setText(String.valueOf(model.getPuntaje()));

                holder.btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.setPuntaje(model.getIdFondo());
                    }
                });

            }

            @NonNull
            @Override
            public EstiloAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_fondo_item, parent, false);

                return new EstiloAdapter(view);
            }
        };

    }

    public static class EstiloAdapter extends RecyclerView.ViewHolder{

        TextView nomFondo;
        TextView puntaje;
        Button btnAdd;

        DatabaseReference mReferences;

        public EstiloAdapter(View view) {
            super(view);

            nomFondo = (TextView) view.findViewById(R.id.textDesc);
            puntaje = (TextView) view.findViewById(R.id.textPuntaje);

            btnAdd = (Button) view.findViewById(R.id.btnAdd);

            mReferences = FirebaseDatabase.getInstance().getReference().child(Nodos.ESTILO);
        }

        public void setPuntaje(String idFondo){

        }
    }

}

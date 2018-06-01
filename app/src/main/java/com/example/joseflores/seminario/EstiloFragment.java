package com.example.joseflores.seminario;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.joseflores.seminario.Modelos.Nodos;
import com.example.joseflores.seminario.Modelos.Presentacion;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;


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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setHasOptionsMenu(true);

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

                holder.setPuntaje(model.getPuntaje());

                holder.btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        asignarPuntaje(model.getIdFondo());
                    }
                });

            }

            @NonNull
            @Override
            public EstiloAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);

                return new EstiloAdapter(view);
            }
        };

    }

    private void asignarPuntaje(final String idEstilo) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());

        dialog.setTitle("Asignar puntos")
                .setSingleChoiceItems(R.array.puntaje_estilo, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int selected = ((AlertDialog)dialog).getListView().getCheckedItemPosition();

                        actualizarPuntaje(idEstilo, selected);
                    }
                })

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();

    }

    private void actualizarPuntaje(String idEstilo, final int selected) {

        mReference.child(idEstilo).child(Nodos.PUNTAJE)
                .runTransaction(new Transaction.Handler() {
                    @Override
                    public Transaction.Result doTransaction(MutableData mutableData) {

                        mutableData.setValue(selected);

                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {

                    }
                });

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

        public void setPuntaje(int puntajeAsignado){

            puntaje.setText(String.valueOf(puntajeAsignado));

        }
    }

}

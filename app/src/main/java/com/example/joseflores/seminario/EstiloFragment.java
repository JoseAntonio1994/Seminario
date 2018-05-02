package com.example.joseflores.seminario;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joseflores.seminario.Modelos.Presentacion;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;


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
        return inflater.inflate(R.layout.fragment_estilo, container, false);
    }

    public static class EstiloAdapter extends RecyclerView.ViewHolder{



        public EstiloAdapter(View view) {
            super(view);
        }
    }

}

package com.example.joseflores.seminario;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joseflores.seminario.Modelos.Nodos;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class FondoFragment extends Fragment {

    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager layoutManager;

    private DatabaseReference mReference;



    public FondoFragment() {}


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fondo, container, false);

        mReference = FirebaseDatabase.getInstance().getReference().child(Nodos.FONDO);



        return view;
    }


    public static class FondoAdapter extends RecyclerView.ViewHolder{

        public FondoAdapter(View view) {
            super(view);
        }
    }

}

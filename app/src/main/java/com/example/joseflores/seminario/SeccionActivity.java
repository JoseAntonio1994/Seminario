package com.example.joseflores.seminario;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SeccionActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Toolbar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragmentSelected = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:

                    toolbar.setTitle("Fondo de presentación");
                    fragmentSelected = new FondoFragment();

                    break;
                case R.id.navigation_dashboard:

                    toolbar.setTitle("Estilo de presentación");
                    fragmentSelected = new EstiloFragment();

                    break;
                case R.id.navigation_notifications:

                    toolbar.setTitle("Resultados obtenidos");
                    fragmentSelected = new ResultFragment();

                    break;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragmentSelected).commit();

            return true;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccion);

        toolbar = (Toolbar) findViewById(R.id.tooSeccion);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Fondo de presentación");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, new FondoFragment()).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_add: crearPonderacion().show();  break;

            case R.id.menu_eye: mostrarExpositor().show(); break;

            default: return super.onOptionsItemSelected(item);

        }

        return super.onOptionsItemSelected(item);
    }

    public AlertDialog crearPonderacion(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();

        View view = inflater.inflate(R.layout.new_item, null);

        builder.setView(view)

                .setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.show();

    }

    public AlertDialog mostrarExpositor(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();

        View view = inflater.inflate(R.layout.cuadro_dialogo, null);

        builder.setView(view)

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();

    }
}

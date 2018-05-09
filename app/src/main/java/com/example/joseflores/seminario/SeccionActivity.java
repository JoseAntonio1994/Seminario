package com.example.joseflores.seminario;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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


}

package com.example.joseflores.seminario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnRegistrarExp: startActivity(new Intent(MainActivity.this, NuevoExpositor.class));  break;

            case R.id.btnAnadirPon: startActivity(new Intent(MainActivity.this, NuevaPonderacion.class));  break;

            case R.id.btnConsultarPon: startActivity(new Intent(MainActivity.this, ConsultaPonderacion.class)); break;

        }

    }
}

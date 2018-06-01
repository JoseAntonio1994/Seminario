package com.example.joseflores.seminario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_fecha = (TextView) findViewById(R.id.txt_fecha);

        fechaActual();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnSiguiente:

                startActivity(new Intent(MainActivity.this, SeccionActivity.class));

                break;

        }
    }

    private void fechaActual(){

        SimpleDateFormat fechaActual = new SimpleDateFormat("dd-MM-yyyy");

        Calendar calendar = Calendar.getInstance();

        String fecha = fechaActual.format(calendar.getTime());

        txt_fecha.setText(fecha);
    }
}

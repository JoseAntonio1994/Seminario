package com.example.joseflores.seminario;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseflores.seminario.DDL.DDL;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NuevoExpositor extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_fecha;

    private EditText edi_codigo;
    private EditText edi_expositor;
    private EditText edi_evaluador;
    private EditText edi_asesor;

    private Spinner maestria;
    private Spinner doctorado;

    private String maestriaSeleccionada;
    private String doctoradoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_expositor);

        edi_codigo = (EditText) findViewById(R.id.edi_codigo);
        edi_expositor = (EditText) findViewById(R.id.editExpositor);
        edi_evaluador = (EditText) findViewById(R.id.editEvaluador);
        edi_asesor = (EditText) findViewById(R.id.editAsesor);

        maestria = (Spinner) findViewById(R.id.spiMaestria);
        doctorado = (Spinner) findViewById(R.id.spiDoctorado);


        txt_fecha = (TextView) findViewById(R.id.txt_fecha);

        fechaActual();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnGuardar:

                guardarExpositor();

                break;

        }
    }

    private void guardarExpositor() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "seminario", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        maestriaSeleccionada = maestria.getSelectedItem().toString();
        doctoradoSeleccionado = doctorado.getSelectedItem().toString();

        try {

            ContentValues values = new ContentValues();
            values.put(DDL.ID_EXPOSITOR, edi_codigo.getText().toString());
            values.put(DDL.NOMBRE_EXPOSITOR, edi_expositor.getText().toString());
            values.put(DDL.NOMBRE_EVALUADOR, edi_evaluador.getText().toString());
            values.put(DDL.NOMBRE_ASESOR, edi_asesor.getText().toString());
            values.put(DDL.MAESTRIA, maestriaSeleccionada);
            values.put(DDL.DOCTORADO, doctoradoSeleccionado);
            values.put(DDL.FECHA, txt_fecha.getText().toString());

            Long id =  db.insert(DDL.TABLA_EXPOSITOR, DDL.ID_EXPOSITOR, values);


            Toast.makeText(getApplicationContext(), "Expositor "+ id +" guardado", Toast.LENGTH_SHORT).show();

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error al guardar los datos", Toast.LENGTH_SHORT).show();

        }



    }

    private void fechaActual(){

        SimpleDateFormat fechaActual = new SimpleDateFormat("dd-MM-yyyy");

        Calendar calendar = Calendar.getInstance();

        String fecha = fechaActual.format(calendar.getTime());

        txt_fecha.setText(fecha);
    }
}

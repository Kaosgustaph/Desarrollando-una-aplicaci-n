package com.example.luis.tarea1_android;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarBoton();
        try{
            completarDatos(getIntent().getExtras());
        }
        catch (Exception e){

        }

    }


    public void agregarBoton(){
        Button miBoton=(Button) findViewById(R.id.btMiButton);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarGuardarDatos();
            }
        });
    }

    public void confirmarGuardarDatos(){
        new AlertDialog.Builder(this).
                setMessage("Seguro que desea guardar?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        guardarDatos();
                    }
                }).setNegativeButton(android.R.string.no, null).show();


    }

    public void completarDatos(Bundle extras){

        TextInputEditText tiNombre=(TextInputEditText) findViewById(R.id.tiNombre);
        TextInputEditText tiTelefono=(TextInputEditText) findViewById(R.id.tiTelefono);
        TextInputEditText tiCorreo=(TextInputEditText) findViewById(R.id.tiCorreo);
        TextInputEditText tiDescripcion=(TextInputEditText) findViewById(R.id.tiDescripcion);
        DatePicker dpFecha=(DatePicker)findViewById(R.id.dpFechaNacimiento);

        tiNombre.setText(extras.getString("sNombre"));
        tiTelefono.setText(extras.getString("sTelefono"));
        tiCorreo.setText(extras.getString("sCorreo"));
        tiDescripcion.setText(extras.getString("sDescripcion"));
        dpFecha.updateDate(extras.getInt("dFecha_year"),extras.getInt("dFecha_month"),extras.getInt("dFecha_day"));
    }

    public void guardarDatos(){
        Intent i=new Intent(MainActivity.this,VerDatos.class);
        TextInputEditText tiNombre=(TextInputEditText) findViewById(R.id.tiNombre);
        TextInputEditText tiTelefono=(TextInputEditText) findViewById(R.id.tiTelefono);
        TextInputEditText tiCorreo=(TextInputEditText) findViewById(R.id.tiCorreo);
        TextInputEditText tiDescripcion=(TextInputEditText) findViewById(R.id.tiDescripcion);
        DatePicker dpFecha=(DatePicker)findViewById(R.id.dpFechaNacimiento);

        i.putExtra("sNombre",tiNombre.getText().toString());
        i.putExtra("sTelefono",tiTelefono.getText().toString());
        i.putExtra("sCorreo",tiCorreo.getText().toString());
        i.putExtra("sDescripcion",tiDescripcion.getText().toString());
        i.putExtra("dFecha_year",dpFecha.getYear());
        i.putExtra("dFecha_month",dpFecha.getMonth());
        i.putExtra("dFecha_day",dpFecha.getDayOfMonth());
        startActivity(i);
        finish();
    }


}

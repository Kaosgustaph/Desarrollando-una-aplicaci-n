package com.example.luis.tarea1_android;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class VerDatos extends AppCompatActivity {

    Calendar cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);
        agregarBoton();
        cal=Calendar.getInstance();
        try{
            completarDatos(getIntent().getExtras());
        }
        catch(Exception e){

        }

    }

    public void completarDatos(Bundle extras){

        TextView tvNombre=(TextView) findViewById(R.id.tvNombre);
        TextView tvTelefono=(TextView) findViewById(R.id.tvTelefono);
        TextView tvCorreo=(TextView) findViewById(R.id.tvCorreo);
        TextView tvDescripcion=(TextView) findViewById(R.id.tvDescripcion);
        TextView tvFecha=(TextView) findViewById(R.id.tvFecha);

        tvNombre.setText(extras.getString("sNombre"));
        tvTelefono.setText(extras.getString("sTelefono"));
        tvCorreo.setText(extras.getString("sCorreo"));
        tvDescripcion.setText(extras.getString("sDescripcion"));
        cal.set(extras.getInt("dFecha_year"),extras.getInt("dFecha_month"),extras.getInt("dFecha_day"));
        tvFecha.setText(extras.getInt("dFecha_year")+"/"+extras.getInt("dFecha_month")+"/"+extras.getInt("dFecha_day"));
    }

    public void agregarBoton(){
        Button miBoton=(Button) findViewById(R.id.btMiButton2);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarDatos();
            }
        });
    }

    public void editarDatos(){
        Intent i=new Intent(VerDatos.this,MainActivity.class);

        TextView tvNombre=(TextView) findViewById(R.id.tvNombre);
        TextView tvTelefono=(TextView) findViewById(R.id.tvTelefono);
        TextView tvCorreo=(TextView) findViewById(R.id.tvCorreo);
        TextView tvDescripcion=(TextView) findViewById(R.id.tvDescripcion);

        i.putExtra("sNombre",tvNombre.getText().toString());
        i.putExtra("sTelefono",tvTelefono.getText().toString());
        i.putExtra("sCorreo",tvCorreo.getText().toString());
        i.putExtra("sDescripcion",tvDescripcion.getText().toString());
        i.putExtra("dFecha_year",cal.get(Calendar.YEAR));
        i.putExtra("dFecha_month",cal.get(Calendar.MONTH));
        i.putExtra("dFecha_day",cal.get(Calendar.DAY_OF_MONTH));

        startActivity(i);
        finish();
    }


}

package com.example.claudioivan.app3;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar barraRoja,barraVerde,barraAzul;
    CheckBox checkRojo,checkVerde,checkAzul;
    ConstraintLayout layout;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barraRoja=(SeekBar)findViewById(R.id.seekBar);
        barraVerde=(SeekBar)findViewById(R.id.seekBar2);
        barraAzul=(SeekBar)findViewById(R.id.seekBar3);

        checkRojo=(CheckBox)findViewById(R.id.checkbox);
        checkVerde=(CheckBox)findViewById(R.id.checkbox2);
        checkAzul=(CheckBox)findViewById(R.id.checkbox3);

        layout=(ConstraintLayout) findViewById(R.id.layout);

        SeekBar.OnSeekBarChangeListener listener=new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cambiaColor(seekBar);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        barraRoja.setOnSeekBarChangeListener(listener);

        barraVerde.setOnSeekBarChangeListener(listener);

        barraAzul.setOnSeekBarChangeListener(listener);

        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void cambiaColor(View view){
        int rojo= checkRojo.isChecked() ? barraRoja.getProgress():255;
        int verde= checkVerde.isChecked() ? barraVerde.getProgress():255;
        int azul= checkAzul.isChecked() ? barraAzul.getProgress():255;
        layout.setBackgroundColor(Color.argb(255,rojo,verde,azul));
    }


    public void leerStrings(View view){
        //String texto= getResources().getString(R.string.checkBox2);
        String texto[]=getResources().getStringArray(R.array.lista_uno);
        Toast mensaje=Toast.makeText(getApplicationContext(),texto[1],Toast.LENGTH_SHORT);
        mensaje.show();
    }

}

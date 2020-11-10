package com.example.autosmaterial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorAutomovil.OnAutomovilClickListener{
    private RecyclerView listadoAutomovil;
    private AdaptadorAutomovil adaptador;
    private LinearLayoutManager llm;
    private ArrayList<Automovil> automovil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listadoAutomovil =(RecyclerView) findViewById(R.id.lstAutomovil);

        automovil = Datos.obtener();
        automovil = new ArrayList<Automovil>();
        automovil.add(new Automovil(R.drawable.carro3, "ABC123", "MAZDA", "1998", "Blanco", "78383000" ));
        automovil.add(new Automovil(R.drawable.carro1, "SB653S", "KIA", "1972", "Rojo", "63878822" ));
        automovil.add(new Automovil(R.drawable.carro4, "S45123", "FORD", "2008", "blanco", "25626700" ));
        automovil.add(new Automovil(R.drawable.carro2, "TZU022", "DODGE", "1998", "rojo", "120000000" ));

        adaptador = new AdaptadorAutomovil(automovil, this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listadoAutomovil.setLayoutManager(llm);
        listadoAutomovil.setAdapter(adaptador);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public void onAutomovilClick(Automovil p) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putInt("foto",p.getFoto());
        bundle.putString("placa", p.getPlaca());
        bundle.putString("marca",p.getMarca());
        bundle.putString("modelo", p.getModelo());
        bundle.putString("color", p.getColor());
        bundle.putString("precio", p.getPrecio());

        intent = new Intent(MainActivity.this, DetalleAutomovil.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);


    }
}
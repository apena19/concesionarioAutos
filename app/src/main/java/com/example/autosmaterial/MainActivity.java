package com.example.autosmaterial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdaptadorAutomovil.OnAutomovilClickListener{
    private RecyclerView listadoAutomovil;
    private AdaptadorAutomovil adaptador;
    private LinearLayoutManager llm;
    private ArrayList<Automovil> automovil;
    private Context contexto;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listadoAutomovil =(RecyclerView) findViewById(R.id.lstAutomovil);

        automovil = Datos.obtener();
        automovil = new ArrayList<Automovil>();
        automovil.add(new Automovil(R.drawable.carro1, "S45123", "FORD", "1998", "rojo", "46993000" ));
        automovil.add(new Automovil(R.drawable.carro2, "ABC123", "MAZDA", "2998", "blanco", "20000000" ));
        automovil.add(new Automovil(R.drawable.carro3, "VBC346", "RENAULT", "3998", "negro", "98600000" ));

        adaptador = new AdaptadorAutomovil(automovil, this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listadoAutomovil.setLayoutManager(llm);
        listadoAutomovil.setAdapter(adaptador);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, CrearAuto.class);
                startActivity(intent);
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
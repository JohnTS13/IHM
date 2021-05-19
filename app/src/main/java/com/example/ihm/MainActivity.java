package com.example.ihm;

import android.os.Bundle;

import com.example.ihm.Controlador.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1, tab2, tab3;
    private PagerController pagerAdapter;

    //prueba de despliegue
    private RecyclerView recyclerViewFlor;
    private RecyclerviewAdaptador adaptadorFlor;

    //hola
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tab1 = findViewById(R.id.tabGeneral);
        tab2 = findViewById(R.id.tabPlantas);
        tab3 = findViewById(R.id.tabConfiguraciones);



        /*muestra plantas
        /*recyclerViewFlor = (RecyclerView)findViewById(R.id.recyclerPlantas);
        recyclerViewFlor.setLayoutManager(new LinearLayoutManager(this));*/
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        adaptadorFlor = new RecyclerviewAdaptador(db.mostrarFlor());
        recyclerViewFlor.setAdapter(adaptadorFlor);

        //variables de los campos para la base de datos
        /*id_flor = findViewById(R.id.id_flor);
        estado = findViewById(R.id.estado);
        habilitador = findViewById(R.id.habilitador);
        id_general = findViewById(R.id.id_general);
        temperatura = findViewById(R.id.temperatura);
        humedad = findViewById(R.id.humedad);*/

        //Botones de acción de la base de datos
        /*insert = findViewById(R.id.);
        update = findViewById(R.id.);
        delete = findViewById(R.id.);
        view = findViewById(R.id.);*/



        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                }
                if (tab.getPosition() == 1) {
                    pagerAdapter.notifyDataSetChanged();
                }
                if (tab.getPosition() == 2) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    /*public List<flor_planta> obtenerFlor() {
        List<flor_planta> flor_array = new ArrayList<>();
        flor_array.add(new flor_planta("Margarita", "17°", "29", "Asteráceas", "Plantae", "Brotando", R.drawable.brotando));
        flor_array.add(new flor_planta("Rosa polyantha", "26°", "34", "Rosaceae", "Plantae", "En crecimiento", R.drawable.en_crecimiento));

        return  flor_array;
    }*/
}
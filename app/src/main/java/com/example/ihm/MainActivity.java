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
        db.agregaFlor(1,"Margarita","17", "29", "Asteráceas", "Plantae","Brotando","1");
        db.agregaFlor(2,"Rosa","26", "34", "Rosaceae", "Plantae","En crecimiento","1");
        db.agregaFlor(3,"Hortensia","21", "39", "Hydrangeaceae", "Plantae","Floreciendo","1");
        db.agregaFlor(4,"Corazón sangrante","23", "37", "Papaveraceae", "Plantae","Necesita atención","1");
        db.agregaFlor(5,"Orquídeas","21", "30", "Orchidaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(6,"Tulipán","25", "37", "Liliaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(7,"Peonía","27", "40", "Paeoniaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(8,"Freesia","24", "35", "Iridaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(9,"Nardo","26", "36", "Asparagaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(10,"Dalia","25", "34", "Asteraceae", "Plantae","En crecimiento","0");
        db.agregaFlor(11,"Crisantemo","21", "32", "Asteraceae", "Plantae","En crecimiento","0");
        db.agregaFlor(12,"Clavel","27", "40", "Caryophyllaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(13,"Campanilla","21", "30", "Campanulaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(14,"Gardenia","25", "34", "Rubiaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(15,"Girasol","17", "29", "Asteraceae", "Plantae","En crecimiento","0");
        db.agregaFlor(16,"Narcisos","27", "40", "Amaryllidaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(17,"Flor de Cempasúchil","17", "29", "Asteraceae", "Plantae","En crecimiento","0");
        db.agregaFlor(18,"Amapola","23", "36", "Papaveraceae", "Plantae","En crecimiento","0");
        db.agregaFlor(19,"Magnolia","17", "29", "Magnoliaceae", "Plantae","En crecimiento","0");
        db.agregaFlor(20,"Malva sylvestris","25", "34", "Malvaceae", "Plantae","En crecimiento","0");



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
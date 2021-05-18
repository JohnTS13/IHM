package com.example.ihm;

import android.os.Bundle;
import android.widget.Button;

import com.example.ihm.Controlador.PagerController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1, tab2, tab3;
    private PagerController pagerAdapter;

    private Button insert, update, delete, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tab1 = findViewById(R.id.tabGeneral);
        tab2 = findViewById(R.id.tabPlantas);
        tab3 = findViewById(R.id.tabConfiguraciones);

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
        view = findViewById(R.id.);
        */
        DatabaseHelper db = new DatabaseHelper(this,"chavas_garden", null,1);

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
}
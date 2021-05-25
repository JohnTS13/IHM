package com.example.ihm.Controlador;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ihm.R;

import java.util.ArrayList;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarPlanta#newInstance} factory method to
 * create an instance of this fragment.
 */



public class AgregarPlanta extends Fragment {

    private View view;
    private EditText nombre;
    TableLayout tlTabla;

    ArrayList<PlantaConstructor> listaUsuarios = new ArrayList<>();

    //TableLayout tlTabla;

    String id, nombreP;

    TableRow fila;

    TextView tvId, tvNombre, tvTemperatura;

    EditText nombrePlanta;

    private Button guardar;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AgregarPlanta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgregarPlanta.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarPlanta newInstance(String param1, String param2) {
        AgregarPlanta fragment = new AgregarPlanta();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_agregar_planta, container, false);

        ImageButton search = (ImageButton)view.findViewById(R.id.buscar);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tlTabla = view.findViewById(R.id.tlTabla);
                nombrePlanta = view.findViewById(R.id.nombrePlanta);

                nombre = (EditText)view.findViewById(R.id.nombrePlanta);
                String texto = nombre.getText().toString();

                listaUsuarios.add(new PlantaConstructor("1","Margarita","17","29","Asteráceas","Plantae","Brotando","1"));
                listaUsuarios.add(new PlantaConstructor("2","Rosa","26","34","Rosaceae","Plantae","En crecimiento","1"));
                listaUsuarios.add(new PlantaConstructor("3","Hortensia","21","39","Hydrangeaceae","Plantae","Floreciendo","1"));
                listaUsuarios.add(new PlantaConstructor("4","Corazón sangrante","23","37","Papaveraceae","Plantae","Necesita atención","1"));
                listaUsuarios.add(new PlantaConstructor("5","Orquídeas","21","30","Orchidaceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("6","Tulipan","25","37","Liliaceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("7","Peonía","27","40","Paeoniaceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("8","Freesia","24","35","Iridaceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("9","Nardo","26","36","Asparagaceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("10","Dalia","25","34","Asteraceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("11","Crisantemo","21","32","Asteraceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("12","Clavel","27","40","Caryophyllaceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("13","Campanilla","21","30","Campanulaceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("14","Gardenia","25","34","Rubiaceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("15","Girasol","17","29","Asteraceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("16","Narcisos","27","40","Amaryllidaceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("17","Flor de Cempasúchil","17","29","Asteraceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("18","Amapola","23","36","Papaveraceae","Plantae","En crecimiento","0"));
                listaUsuarios.add(new PlantaConstructor("19","Magnolia","17","29","Magnoliaceae","Plantae","En crecimiento","0"));
                //listaUsuarios.add(new PlantaConstructor("20","Malva sylvestris","25","34","Malvaceae","Plantae","En crecimiento","0"));

                TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                TableRow.LayoutParams layoutUsuario = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                TableRow.LayoutParams layoutTelefono = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                TableRow.LayoutParams layoutEmail = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

                // TABLA
                for(int i = -1 ; i < listaUsuarios.size() ; i++) {
                    fila = new TableRow(getContext());
                    fila.setLayoutParams(layoutFila);

                    if(i == -1) {

                        tvId = new TextView(getContext());
                        tvId.setText("ID");
                        tvId.setGravity(Gravity.CENTER);
                        tvId.setBackgroundColor(Color.BLACK);
                        tvId.setTextColor(Color.WHITE);
                        tvId.setPadding(10, 10, 10, 10);
                        tvId.setLayoutParams(layoutUsuario);
                        fila.addView(tvId);

                        tvNombre = new TextView(getContext());
                        tvNombre.setText("NOMBRE");
                        tvNombre.setGravity(Gravity.CENTER);
                        tvNombre.setBackgroundColor(Color.BLACK);
                        tvNombre.setTextColor(Color.WHITE);
                        tvNombre.setPadding(10, 10, 10, 10);
                        tvNombre.setLayoutParams(layoutUsuario);
                        fila.addView(tvNombre);

                        tvTemperatura = new TextView(getContext());
                        tvTemperatura.setText("TEMPERATURA");
                        tvTemperatura.setGravity(Gravity.CENTER);
                        tvTemperatura.setBackgroundColor(Color.BLACK);
                        tvTemperatura.setTextColor(Color.WHITE);
                        tvTemperatura.setPadding(10, 10, 10, 10);
                        tvTemperatura.setLayoutParams(layoutUsuario);
                        fila.addView(tvTemperatura);

                        tlTabla.addView(fila);
                    } else {

                        if (texto.equals(listaUsuarios.get(i).getNombre())){
                            tvId = new TextView(getContext());
                            tvId.setText(listaUsuarios.get(i).getId());
                            tvId.setPadding(10, 10, 10, 10);
                            tvId.setLayoutParams(layoutUsuario);
                            fila.addView(tvId);

                            tvNombre = new TextView(getContext());
                            tvNombre.setGravity(Gravity.CENTER);
                            tvNombre.setText(listaUsuarios.get(i).getNombre());
                            tvNombre.setPadding(10, 10, 10, 10);
                            tvNombre.setLayoutParams(layoutTelefono);
                            fila.addView(tvNombre);

                            tvTemperatura = new TextView(getContext());
                            tvTemperatura.setText(listaUsuarios.get(i).getTemperatura());
                            tvTemperatura.setPadding(10, 10, 10, 10);
                            tvTemperatura.setLayoutParams(layoutEmail);
                            fila.addView(tvTemperatura);

                            id = listaUsuarios.get(i).getId();
                            nombreP = listaUsuarios.get(i).getNombre();
                        }

                        tlTabla.addView(fila);
                    }
                }

            }
        });

        guardar = view.findViewById(R.id.btnGuardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), nombreP + " guardada", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();



                Plantas plantas =  new Plantas();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.body_plantas, plantas);
                transaction.commit();

            }
        });

        return view;
    }
}
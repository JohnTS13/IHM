package com.example.ihm.Controlador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ihm.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Configuraciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EstadoPlanta extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText temp, hum;
    private Button actualizarParametro;
    public EstadoPlanta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Configuraciones.
     */
    // TODO: Rename and change types and number of parameters
    public static Configuraciones newInstance(String param1, String param2) {
        Configuraciones fragment = new Configuraciones();
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
        View view = inflater.inflate(R.layout.fragment_estado_planta, container, false);

        actualizarParametro = view.findViewById(R.id.actualizarParametro);

        temp = view.findViewById(R.id.editTextTemperaturaE);
        hum = view.findViewById(R.id.editTextHumedadE);

        temp.setText("30.70");
        hum.setText("41.00");

        actualizarParametro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int cont = 0;
                Toast toast = Toast.makeText(getContext(), "Parámetros actualizados", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();

                /*temp.setText("30.70");
                hum.setText("41.00");*/

                /*cont = cont +1;
                if(cont>=1){
                    temp.setText("25.5");
                    hum.setText("55.5");
                }*/
            }
        });


        return view;
    }
}
package com.example.ktdie.sanantoniodepereira;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class DemoViewActivity extends AppCompatActivity {

    Lista_Entrada[] datos = new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.hotel_1, "$240,000", "Hotel Movich", "Hotel 5 estrellas"),
            new Lista_Entrada(R.drawable.hotel_2, "$204,000", "Hotel Rio Verde", "Hotel 5 estrellas"),
            new Lista_Entrada(R.drawable.hotel_3, "$195,000", "Casa Grande", "Hotel 4 estrellas"),

            new Lista_Entrada(R.drawable.rest_1, "$2,500", "Dulce Contigo", "Plato recomendado: Postres "),
            new Lista_Entrada(R.drawable.rest_2, "$23,000", "Mulata Criolla Parrilla Bar", "Plato recomendado: Costillas BBQ"),
            new Lista_Entrada(R.drawable.rest_3, "$19,500", "El Patio de San Antonio", "Este tampoc se queda atras"),

            new Lista_Entrada(R.drawable.disco_1, "$15,000", "Discoteca View", "Musica urbana"),
            new Lista_Entrada(R.drawable.disco_2, "$15,000", "Discoteca Gluck", "Musica urbana"),
            new Lista_Entrada(R.drawable.disco_3, "$10,000", "Fonda la Escena", "Musica parrandera"),
    };
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_view);

        Adapter adapter = new Adapter(this, datos);

        lista= (ListView) findViewById(R.id.lista);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               String opcion = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                //Da la posición Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                Toast.makeText(DemoViewActivity.this, opcion, Toast.LENGTH_SHORT).show();
            }
        });

    }

    class Adapter extends ArrayAdapter<Lista_Entrada>{


        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.listview_item, datos);

        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_item, null);

            TextView nombre = (TextView) item.findViewById(R.id.tName);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescripcion());

            TextView precio = (TextView) item.findViewById(R.id.tPrecio);
            precio.setText(String.valueOf(datos[position].getPrecio()));

            ImageView imagen = (ImageView) item.findViewById(R.id.iPhoto);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
        }


    }
}

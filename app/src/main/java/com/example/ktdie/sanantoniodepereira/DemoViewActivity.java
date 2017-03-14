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

    //String[] sitios = new String[] {"Panaca","Decameron", "Parque del cafe"};

    Lista_Entrada[] datos = new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.hotel_1, 240, "Hotel Movich", "Mera chimba de hotel"),
            new Lista_Entrada(R.drawable.hotel_2, 204, "Hotel Rio Verde", "Tambine mera chimba de hotel"),
            new Lista_Entrada(R.drawable.hotel_3, 195, "Casa Grande", "Este tampoc se queda atras"),
    };
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_view);

       // ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sitios);

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

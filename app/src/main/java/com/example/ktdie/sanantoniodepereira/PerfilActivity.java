package com.example.ktdie.sanantoniodepereira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String username, correo;
    TextView tUsername,tCorreo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername=(TextView) findViewById(R.id.tUsername);
        tCorreo=(TextView) findViewById(R.id.tCorreo);

        Bundle extras = getIntent().getExtras();

        tUsername.setText(extras.getString("username"));
        tCorreo.setText(extras.getString("correo"));

        username= extras.getString("username");
        correo= extras.getString("correo");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.mPerfil:
                /* Se quede en el perfil, no hace nada*/
                break;

            case R.id.mPrincipal:
                intent = new Intent(PerfilActivity.this, MainActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;

            case R.id.mHotel:
                intent = new Intent(PerfilActivity.this, HotelActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;

            case R.id.mRestaurantes:
                intent = new Intent(PerfilActivity.this, RestauranteActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;

            case R.id.mBares:
                intent = new Intent(PerfilActivity.this, DiscotecasActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;

            case R.id.mLogOut:
                intent= new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }
}

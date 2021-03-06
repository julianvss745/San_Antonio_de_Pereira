package com.example.ktdie.sanantoniodepereira;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NavegationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username, correo;
    TextView tUsername, tCorreo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegation_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View hView = navigationView.getHeaderView(0);

        tUsername=(TextView) hView.findViewById(R.id.tUsername);
        tCorreo=(TextView) hView.findViewById(R.id.tCorreo);

        Bundle extras = getIntent().getExtras();

        tUsername.setText(extras.getString("username"));
        tCorreo.setText(extras.getString("correo"));

        username = extras.getString("username");
        correo = extras.getString("correo");

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navegation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            intent = new Intent(NavegationDrawerActivity.this, DemoViewActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
        }

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_principal) {
            //Principal
            // Navegacion entre actividades

        } else if (id == R.id.nav_hotel) {
            //Hoteles
            // Navegacion entre actividades
            intent = new Intent(NavegationDrawerActivity.this, HotelDrawerActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_restaurante) {
            //Restaurantes
            //Navegacion entre actividades
            intent = new Intent(NavegationDrawerActivity.this, RestauranteDrawerActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_bar) {
            //Discotecas
            // Navegacion entre actividades
            intent = new Intent(NavegationDrawerActivity.this, DiscotecaDrawerActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();


        } else if (id == R.id.nav_cerrar_sesion) {
            // Cerrar sesión
            // Navegacion entre actividades
            intent = new Intent(NavegationDrawerActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

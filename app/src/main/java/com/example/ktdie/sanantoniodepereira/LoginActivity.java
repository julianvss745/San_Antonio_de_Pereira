package com.example.ktdie.sanantoniodepereira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, ePassword;
    Button bIniciar;
    TextView tRegistrarse;
    String username="", password="", correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        ePassword = (EditText) findViewById(R.id.ePassword);
        bIniciar = (Button) findViewById(R.id.bIniciar);
        tRegistrarse = (TextView) findViewById(R.id.tRegistrarse);



        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,RegistroActivity.class);
                startActivityForResult(intent,0000);
            }
        });

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (eUsuario.getText().toString().equals(username) && ePassword.getText().toString().equals(password)){

                    if (eUsuario.getText().toString().equals("") && ePassword.getText().toString().equals("")){

                        Toast.makeText(getApplicationContext(),"Ingresar usuario y contraseña",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //validar que el usuario y contrasña sean iguales a los recibidos

                        Intent intent= new Intent(LoginActivity.this, MainActivity.class);

                        //validar que el usuario y contrasña sean iguales a los recibidos
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        intent.putExtra("correo", correo);

                        startActivity(intent);
                    }
                }

                if (!(eUsuario.getText().toString().equals(username))){

                    Toast.makeText(getApplicationContext(),"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                }

                if (!(ePassword.getText().toString().equals(password))){

                    Toast.makeText(getApplicationContext(),"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==0000 && resultCode==RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");
            Log.d("nombre",data.getExtras().getString("username"));
            Log.d("password",data.getExtras().getString("password"));
            Log.d("correo",data.getExtras().getString("correo"));
        }
        if (requestCode == 0000 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Proceso de login cancelado",Toast.LENGTH_SHORT).show();
        }
    }
}

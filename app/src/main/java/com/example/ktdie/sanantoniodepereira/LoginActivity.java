package com.example.ktdie.sanantoniodepereira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, ePassword;
    Button bIniciar;
    TextView tRegistrarse;

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
                startActivity(intent);
            }
        });

    }
}

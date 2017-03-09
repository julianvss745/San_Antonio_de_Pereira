package com.example.ktdie.sanantoniodepereira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class RegistroActivity extends AppCompatActivity {


    EditText eRUsuario, eRRepPassword, eRPassword, eRCorreo;

    Button bRegistrarse, bRCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eRUsuario=(EditText) findViewById(R.id.eRUsuario);
        eRPassword=(EditText) findViewById(R.id.eRPassword);
        eRRepPassword=(EditText) findViewById(R.id.eRRepPassword);
        eRCorreo=(EditText) findViewById(R.id.eRCorreo);

        bRegistrarse=(Button) findViewById(R.id.bRregistrarse);
        bRCancelar=(Button) findViewById(R.id.bRcancelar);



        bRCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Comunicacion bidireccional
                Intent intent= new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });


        bRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Validar que todos los campos esten llenos
                if(!(eRUsuario.getText().toString().equals(""))&& !(eRPassword.getText().toString().equals(""))&& !(eRRepPassword.getText().toString().equals(""))&& !(eRCorreo.getText().toString().equals(""))){


                    //Validar que las dos contraseñas sean iguales
                    if(eRPassword.getText().toString().equals(eRRepPassword.getText().toString())){

                        //Comunicacion bidireccional
                        Intent intent= new Intent();
                        intent.putExtra("username",eRUsuario.getText().toString());
                        intent.putExtra("password",eRPassword.getText().toString());
                        intent.putExtra("correo",eRCorreo.getText().toString());
                        setResult(RESULT_OK,intent);
                        finish();

                        Toast.makeText(getApplicationContext(),"Proceso de registro exitoso",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                    }
                }

                else{
                    Toast.makeText(getApplicationContext(),"Por favor llenar todos los campos",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

package com.pruebas.tesiss_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    ImageButton registrar;
    Button ingresar;
    EditText usuario,passwrod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registrar = findViewById(R.id.btn_registrar);
        usuario = findViewById(R.id.usuario_id);
        passwrod = findViewById(R.id.passoword_id);
        ingresar = findViewById(R.id.ingresar_id);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Principal.class);
                startActivity(intent);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuario.getText().toString();
                String pass = passwrod.getText().toString();

                if (!pass.isEmpty() && !user.isEmpty()){
                    Intent intent=new Intent(Login.this, Principal.class);
                    Toast.makeText(getApplication(),"Bienvenido:"+ user,Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }else if (user.isEmpty()){
                    usuario.setError("Ingrese Usuario");
                }else if(pass.isEmpty()){
                    passwrod.setError(("Clave Incorrecta"));
                }else{
                    Toast.makeText(getApplication(),"Bienvenido:"+ user,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

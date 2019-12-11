package com.pruebas.tesiss_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    Button registrar;
    EditText usuario,password,validarpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        registrar=findViewById(R.id.reg_ingresar_id);;
        usuario = findViewById(R.id.reg_usuario_id);;
        password = findViewById(R.id.reg_passoword_id); ;
        validarpassword = findViewById(R.id.reg_vali_passoword_id);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuario.getText().toString();
                String pass = password.getText().toString();
                String valpass = validarpassword.getText().toString();
                if (!user.isEmpty() && !pass.isEmpty() && !valpass.isEmpty() && pass.equals(valpass)){
                    Intent intent=new Intent(Registrar.this,Principal.class);
                    startActivity(intent);
                    Toast.makeText(getApplication(),"Bienvenido"+ user,Toast.LENGTH_LONG).show();
                }else if (user.isEmpty()){
                    usuario.setError("Ingrese usuario");
                }else if (pass.isEmpty()){
                    password.setError("Ingrese pasword");
                }else if (!pass.equals(valpass)){
                    validarpassword.setError("No coiciden");
                }
                else{
                    Toast.makeText(getApplication(),"Bienvenido"+ user,Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}

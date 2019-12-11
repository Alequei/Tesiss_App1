package com.pruebas.tesiss_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Reservas extends AppCompatActivity {
    private ImageView imagen;
    private TextView nombre,precio,pago,nombredelpago;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reservas);
        String peluqueriaTitle=getIntent().getExtras().getString("title");
        String peluqueriaPrecio=getIntent().getExtras().getString("precio");
        int imagenurl=getIntent().getExtras().getInt("ImgUrl");

        pago=findViewById(R.id.pagotratmiento);
        nombredelpago=findViewById(R.id.nombrepago);

        imagen=findViewById(R.id.imagenUrl);
        imagen.setImageResource(imagenurl);
        nombre = findViewById(R.id.nombretratamiento);
        nombre.setText(peluqueriaTitle);
        precio = findViewById(R.id.costoreserv);
        precio.setText(peluqueriaPrecio);

        pago.setText(precio.getText());
       nombredelpago.setText(nombre.getText());
    }
}

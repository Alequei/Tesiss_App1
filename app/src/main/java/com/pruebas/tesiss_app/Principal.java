package com.pruebas.tesiss_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class    Principal extends AppCompatActivity implements MovieItemClick {
    List<Slider> sliderList;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView peluqueria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        sliderpager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator_id);
        peluqueria =findViewById(R.id.rv_peluqueria);
        sliderList = new ArrayList<>();
        sliderList.add(new Slider(R.drawable.servicio_corte,"Cortes"));
        sliderList.add(new Slider(R.drawable.servicio_maquillaje,"Maquillaje"));
        sliderList.add(new Slider(R.drawable.servicio_peinado_boda_2,"Peinado"));
        sliderList.add(new Slider(R.drawable.servicio_tt_facial,"Tratamietno Facil"));
        sliderList.add(new Slider(R.drawable.servicio_corte,"Cortes"));

        SliderAdapter adapter = new SliderAdapter(this,sliderList);
        sliderpager.setAdapter(adapter);
        indicator.setupWithViewPager(sliderpager,true);
        Timer time=new Timer();
        time.scheduleAtFixedRate(new Principal.sliderTimer(),4000,6000);


        //RecycleView Setup
        List<class_pelequeria > class_pelequerias =new ArrayList<>();
        class_pelequerias.add(new class_pelequeria("Corte","S./30.00",R.drawable.servicio_corte));
        class_pelequerias.add(new class_pelequeria("Maquillaje","S./20.00",R.drawable.servicio_maquillaje));
        class_pelequerias.add(new class_pelequeria("Peinado","S./15.00",R.drawable.servicio_peinado_boda_2));
        class_pelequerias.add(new class_pelequeria("Tratamiento","S./20.00",R.drawable.servicio_tt_facial));
        PeluqueriaAdapter peluqueriaAdapter=new PeluqueriaAdapter(this,class_pelequerias,this);
        peluqueria.setAdapter(peluqueriaAdapter);
        peluqueria.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }

    @Override
    public void onMovieclick(class_pelequeria class_pelequeria, ImageView movilImagen) {

        Intent intent= new Intent(this,Reservas.class);
        intent.putExtra("title",class_pelequeria.getNombre());
        intent.putExtra("ImgUrl",class_pelequeria.getImagen());
        intent.putExtra("precio",class_pelequeria.getPrecio());

        //Invia animacion
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Principal.this, movilImagen,"sharedName");


        startActivity(intent,options.toBundle());
        Toast.makeText(this,"Seleccion de  servicio de"+class_pelequeria.getNombre(),Toast.LENGTH_SHORT).show();

    }

    class sliderTimer extends TimerTask{

            @Override
            public void run() {
                Principal.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (sliderpager.getCurrentItem()<sliderList.size() - 1){
                            sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                        }else {
                            sliderpager.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }



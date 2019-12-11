package com.pruebas.tesiss_app;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
    private Context mContext;
    private List<Slider> mlis;

    public SliderAdapter(Context mContext,List<Slider>mlis){
        this.mContext=mContext;
        this.mlis=mlis;
    }
    @Override
    public int getCount() {
        return mlis.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderlayoud = inflater.inflate(R.layout.slider_items,null);
        ImageView sliderImg =sliderlayoud.findViewById(R.id.slider_id);
        TextView textView=sliderlayoud.findViewById(R.id.slidertext_id);
        sliderImg.setImageResource(mlis.get(position).getImagen());
        textView.setText(mlis.get(position).getNombre());
        container.addView(sliderlayoud);
        return  sliderlayoud;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;


    }
}

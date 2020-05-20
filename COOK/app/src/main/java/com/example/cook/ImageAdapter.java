package com.example.cook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Map;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public Integer[] images = {
            R.drawable.apple,
            R.drawable.bananabread,
            R.drawable.bolognese,
            R.drawable.friedeggs,
            R.drawable.garlichicken,
            R.drawable.pancakes,
            R.drawable.pizza,
            R.drawable.potatosoup,
            R.drawable.quiche,
            R.drawable.tarator,
            R.drawable.tomatosalad,
            R.drawable.vegsoup
    };

    public ImageAdapter(Context c) {
        context = c;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));
        return imageView;
    }
}
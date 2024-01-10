package com.example.myapppaises;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapPaises extends ArrayAdapter<lPaises> {

    public adapPaises(Context context, ArrayList<lPaises> datos) {
        super(context, R.layout.itempais, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.itempais, null);

        TextView nombrePais = (TextView) item.findViewById(R.id.lblpais);
        nombrePais.setText(getItem(position).getName());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgPais);
        Glide.with(this.getContext())
                .load(getItem(position).getIso2())
                .into(imageView);
        return (item);
    }
}

package com.example.electiva3_android_lista;

import android.content.Context;
import android.content.Entity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.electiva3_android_lista.Models.Elefante;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AdapterElefantes  extends BaseAdapter {
    private Context context;
    private ArrayList<Elefante> listaElefantes;

    public AdapterElefantes(Context context, ArrayList<Elefante> listaElefantes) {
        this.context = context;
        this.listaElefantes = listaElefantes;
    }

    @Override
    public int getCount() {
        return listaElefantes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaElefantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Elefante item = (Elefante) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.viewcard,null);
        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.fotoview);
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tituloview);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.descripcionview);

        imgFoto.setImageBitmap(ConverTobirmap(item.getFoto()));
        tvTitulo.setText(item.getNombre());
        tvDescription.setText(item.getDescripcion());

        return convertView;
    }

    public Bitmap ConverTobirmap(String urlstring)
    {
        Bitmap bmp  = null;
        URL url = null;

        try {
            url = new URL(urlstring);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bmp;
    }

}

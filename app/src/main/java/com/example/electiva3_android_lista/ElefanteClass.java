package com.example.electiva3_android_lista;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.View;
import com.example.electiva3_android_lista.Models.Elefante;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Integer.parseInt;

public class ElefanteClass extends AppCompatActivity {

    private com.example.electiva3_android_lista.Models.Elefante item;

    private TextView titulo,descrip, sesso, origen;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elefante);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Intent intent = getIntent();
        if (intent != null)
        {
            item = (Elefante) getIntent().getSerializableExtra("OBJETODATA");

            titulo = (TextView) findViewById(R.id.Titulo);
            descrip = (TextView) findViewById(R.id.descripcion);
            sesso = (TextView) findViewById(R.id.sesso);
            origen = (TextView) findViewById(R.id.origen);
            foto = (ImageView) findViewById(R.id.imgFoto);

            titulo.setText(item.getNombre());
            descrip.setText(item.getDescripcion());
            sesso.setText(item.getSexo());
            origen.setText(item.getorigen());
            foto.setImageBitmap(ConverTobirmap(item.getFoto()));

        }

    }
    public void regresar(View view) {
        Intent intent = new Intent(ElefanteClass.this, MainActivity.class);
        startActivity(intent);
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

    public static boolean isNullOrBlank(String param) {
        return param == null || param.trim().length() == 0;
    }
}
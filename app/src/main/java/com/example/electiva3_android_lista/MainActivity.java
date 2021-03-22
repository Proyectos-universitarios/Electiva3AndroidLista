package com.example.electiva3_android_lista;

import android.content.Intent;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.electiva3_android_lista.Helper.JSONDATA;
import com.example.electiva3_android_lista.Models.Elefante;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private AdapterElefantes adapterElefantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        new JSONDATA(this);
        ArrayList<Elefante> itemslist = new ArrayList<Elefante>();
        lv=(ListView) findViewById(R.id.listViewElefantes);
        adapterElefantes = new AdapterElefantes(this, JSONDATA.LISTAGLOBAL);
        lv.setAdapter(adapterElefantes);

      lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent intent = new Intent(MainActivity.this, ElefanteClass.class);

              intent.putExtra("OBJETODATA",JSONDATA.LISTAGLOBAL.get(position));
              startActivity(intent);
          }
      });

    }

    public void Salir(View view) {finish();}

    public void VerDatos(View view) {
        Intent intent = new Intent(this, Estudiante.class);
        startActivity(intent);
    }

}
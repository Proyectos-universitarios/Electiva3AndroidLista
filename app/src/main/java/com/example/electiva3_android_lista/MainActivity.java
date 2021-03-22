package com.example.electiva3_android_lista;

import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private AdapterElefantes adapterElefantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lv=(ListView) findViewById(R.id.listViewElefantes);
        adapterElefantes = new AdapterElefantes(this,null);
        lv.setAdapter(adapterElefantes);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Salir(View view) {finish();}

    public void VerDatos(View view) {}
}
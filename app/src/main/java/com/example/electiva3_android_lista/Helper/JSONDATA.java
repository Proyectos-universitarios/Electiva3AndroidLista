package com.example.electiva3_android_lista.Helper;
import android.content.Context;
import  com.example.electiva3_android_lista.R;
import  com.example.electiva3_android_lista.BuildConfig;

import com.example.electiva3_android_lista.Models.Elefante;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class JSONDATA {
    private Context context;


   public static  ArrayList<Elefante> LISTAGLOBAL = new ArrayList<Elefante>();

    public JSONDATA(Context context) {
        this.context = context;
        loadAnswers();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("elephants.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void loadAnswers() {
        ArrayList<Elefante> itemslist = new ArrayList<Elefante>();
        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray userArray = obj.getJSONArray("ELEFANTES");

            for (int i = 0; i < userArray.length(); i++) {

                JSONObject item = userArray.getJSONObject(i);

                itemslist.add(new Elefante(
                        "NOMBRE: " + item.getString("name").toUpperCase(Locale.ROOT),
                        item.getString("note"),
                        item.getString("image"),
                        item.getString("sex"),
                        item.getString("species")
                ));
                LISTAGLOBAL.addAll(itemslist);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}

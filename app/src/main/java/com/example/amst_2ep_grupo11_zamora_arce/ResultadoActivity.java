package com.example.amst_2ep_grupo11_zamora_arce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResultadoActivity extends AppCompatActivity {

    String abuscar;
    RequestQueue ListaRequest = null;
    TextView valor;
    private Map<String, TextView> heroesTWs;
    String token = "2961174840561847";
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        valor = findViewById(R.id.textView2);
        abuscar = getIntent().getStringExtra("busqueda");
        linearLayout = findViewById(R.id.cont_heroes);
        ListaRequest = Volley.newRequestQueue(this);

        this.buscarHeroe2();
    }


    public void buscarHeroe2(){
        String url = "https://superheroapi.com/api/2961174840561847/search/" + abuscar;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        mostrarHeroes(response);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        ListaRequest.add(jsonObjectRequest);
    }



    public void mostrarHeroes(JSONObject heroes) {
        JSONArray resultados;
        JSONObject personaje;
        String nombres;

        try {

            resultados = heroes.getJSONArray("results");
            valor.setText("Resultado: "+resultados.length());
            for (int i=0 ; i< resultados.length(); i++){
                personaje = (JSONObject) resultados.get(i);
                System.out.println(personaje.getString("name"));
                TextView nuevo = new TextView(this);
                nuevo.setText(personaje.getString("name"));
                linearLayout.addView(nuevo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }





        /*for (int i = 0; i < heroes.length(); i++) {
            try {
                System.out.println(i);
                objeto = (JSONObject) heroes.get(String.valueOf(i));
                nombres = objeto.getString("results");
                System.out.println(nombres);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }*/

    }

}
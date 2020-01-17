package com.example.amst_2ep_grupo11_zamora_arce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
                System.out.println();

                final JSONObject personaje_powe = (JSONObject) personaje.get("powerstats");
                final JSONObject nombre = (JSONObject) personaje.get("biography");
                TextView nuevo = new TextView(this);
                nuevo.setText(personaje.getString("name"));
                nuevo.setTextSize(50);
                final JSONObject finalPersonaje = personaje;
                nuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {

                            Intent intent = new Intent(ResultadoActivity.this,Grafica.class );
                            intent.putExtra("power",(personaje_powe.getString("power")));
                            intent.putExtra("intelligence",(personaje_powe.getString("intelligence")));
                            intent.putExtra("strength",(personaje_powe.getString("strength")));
                            intent.putExtra("speed",(personaje_powe.getString("speed")));
                            intent.putExtra("durability",(personaje_powe.getString("durability")));
                            intent.putExtra("combat",(personaje_powe.getString("combat")));
                            intent.putExtra("completo",nombre.getString("full-name"));
                            intent.putExtra("nombre", finalPersonaje.getString("name"));
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                linearLayout.addView(nuevo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

}
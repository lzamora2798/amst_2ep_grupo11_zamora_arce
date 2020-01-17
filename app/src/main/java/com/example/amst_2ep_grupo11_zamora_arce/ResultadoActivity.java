package com.example.amst_2ep_grupo11_zamora_arce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResultadoActivity extends AppCompatActivity {

    String abuscar;
    RequestQueue ListaRequest = null;
    String token  = "2961174840561847";
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        abuscar =getIntent().getStringExtra("busqueda");
        ListaRequest = Volley.newRequestQueue(this);
        buscarHeroe();
    }

    public void buscarHeroe(){
        String url_registros = "https://superheroapi.com/api/2961174840561847/search/"+abuscar;
        JsonArrayRequest requestRegistros = new JsonArrayRequest(Request.Method.GET, url_registros, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //mostrarTemperaturas(response);
                //actualizarGrafico(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("Authorization", "JWT " + "2961174840561847");
                return params;
            }
        };

        ListaRequest.add(requestRegistros);

    }
    public void imprimir(){
        System.out.println(ListaRequest.toString());

    }

}

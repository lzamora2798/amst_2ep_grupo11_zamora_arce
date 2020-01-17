package com.example.amst_2ep_grupo11_zamora_arce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ResultadoActivity extends AppCompatActivity {

    String abuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Volley.newRequestQueue(this);
        abuscar =getIntent().getStringExtra("ID");

        String url = "http://my-json-feed";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //textView.setText("Response: " + response.toString());
                    }}, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

    }
}

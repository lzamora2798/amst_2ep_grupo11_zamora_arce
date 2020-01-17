package com.example.amst_2ep_grupo11_zamora_arce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String Abuscar;
    Button cambio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        cambio = findViewById(R.id.button);
        cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Abuscar = editText.getText().toString();
                //Volley.newRequestQueue("https://superheroapi.com/api/access-token/2961174840561847");
                Intent intent = new Intent(MainActivity.this,ResultadoActivity.class );
                intent.putExtra("busqueda",Abuscar);
                startActivity(intent);
            }
        });

    }

}

/*
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);
        setTitle("Grafico de barras");
        temperaturasTVs = new HashMap<String,TextView>();
        fechasTVs = new HashMap<String,TextView>();
        ListaRequest = Volley.newRequestQueue(this);
        contexto= this;
        GRAFICO
            this.iniciarGrafico();
            this.solicitarTemperaturas(); }
            */
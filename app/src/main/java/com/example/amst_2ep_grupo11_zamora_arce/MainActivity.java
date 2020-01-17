package com.example.amst_2ep_grupo11_zamora_arce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String Abuscar= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editText = (EditText) findViewById(R.id.editText);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void busqueda(View view){
        //Abuscar = editText.getText().toString();
        //Volley.newRequestQueue("https://superheroapi.com/api/access-token/2961174840561847");
        Intent intent = new Intent(this,ResultadoActivity.class );
        intent.putExtra("busqueda","batman");
        startActivity(intent);


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
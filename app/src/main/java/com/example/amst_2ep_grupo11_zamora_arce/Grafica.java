package com.example.amst_2ep_grupo11_zamora_arce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Grafica extends AppCompatActivity {
    int inteligencia,fuerza,velocidad,durabilidad,poder,combate;
    String nombrecompleto,nombre;
    public BarChart graficoBarras;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica);
        textView = findViewById(R.id.habilidades);

        inteligencia = Integer.parseInt(getIntent().getStringExtra("intelligence"));
        fuerza = Integer.parseInt(getIntent().getStringExtra("strength"));
        velocidad = Integer.parseInt(getIntent().getStringExtra("speed"));
        durabilidad = Integer.parseInt(getIntent().getStringExtra("durability"));
        poder = Integer.parseInt(getIntent().getStringExtra("power"));
        combate = Integer.parseInt(getIntent().getStringExtra("combat"));
        nombrecompleto = getIntent().getStringExtra("completo");
        nombre = getIntent().getStringExtra("name");
        textView.setText(nombre+"\n"+nombrecompleto);


        ArrayList<BarEntry> dato_temp = new ArrayList<>();
        dato_temp.add(new BarEntry(0,inteligencia));
        dato_temp.add(new BarEntry(1,fuerza));
        dato_temp.add(new BarEntry(2,velocidad));
        dato_temp.add(new BarEntry(3,durabilidad));
        dato_temp.add(new BarEntry(4,poder));
        dato_temp.add(new BarEntry(0,combate));
        iniciarGrafico();
        llenarGrafico(dato_temp);
    }

    public void iniciarGrafico() {
        graficoBarras = findViewById(R.id.barChart);
        graficoBarras.getDescription().setEnabled(false);
        graficoBarras.setMaxVisibleValueCount(60);
        graficoBarras.setPinchZoom(false);
        graficoBarras.setDrawBarShadow(false);
        graficoBarras.setDrawGridBackground(false);
        XAxis xAxis = graficoBarras.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        graficoBarras.getAxisLeft().setDrawGridLines(false);
        graficoBarras.animateY(1500);
        graficoBarras.getLegend().setEnabled(false);
    }
    private void llenarGrafico(ArrayList<BarEntry> dato_temp){
        BarDataSet DataSet;
        if ( graficoBarras.getData() != null && graficoBarras.getData().getDataSetCount() > 0) {
            DataSet = (BarDataSet) graficoBarras.getData().getDataSetByIndex(0);
            DataSet.setValues(dato_temp);
            graficoBarras.getData().notifyDataChanged();
            graficoBarras.notifyDataSetChanged();
        } else {
            DataSet = new BarDataSet(dato_temp, "Data Set");
            DataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
            DataSet.setDrawValues(true);
            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(DataSet);
            BarData data = new BarData(dataSets);
            graficoBarras.setData(data);
            graficoBarras.setFitBars(true);
        }
        graficoBarras.invalidate();
    }

}

package br.edu.ifsp.pep.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

@RequestScoped
public class GraficoBarrasController {
    private BarChartModel barModel;

    @PostConstruct
    public void init(){
        createBarModel();
    }

    private void createBarModel() {
        this.barModel = new BarChartModel();
        ChartData data = new ChartData();   
        
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Label do DataSet");
        
        // Inclusão de valores para o gráfico, deve ser uma List de Number
        List<Number> valoresNumericos = new ArrayList<>();
        valoresNumericos.add(65);
        valoresNumericos.add(59);
        valoresNumericos.add(80);
        valoresNumericos.add(81);
        valoresNumericos.add(56);
        valoresNumericos.add(55);
        valoresNumericos.add(40);
        // Adicionando no dataSet do grafico
        barDataSet.setData(valoresNumericos);
        
        // Adicionando o dataSet no proprio dados do gráfico
        data.addChartDataSet(barDataSet);
        
        // Labels do gráfico
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        // Adicionando no dados do gráfico
        data.setLabels(labels);
        // Adicionando no modelo do gráfico
        barModel.setData(data);
        
        // Opcionais
        BarChartOptions opcoes = new BarChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Gráfico de Barras");
        opcoes.setTitle(title);
        barModel.setOptions(opcoes);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
}

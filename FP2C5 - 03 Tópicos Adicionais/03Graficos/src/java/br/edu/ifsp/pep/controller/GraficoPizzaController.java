package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.ValoresNumericos;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

@Named
@RequestScoped
public class GraficoPizzaController implements Serializable {

    private PieChartModel pieModel;
    private ValoresNumericos valoresNumericos = new ValoresNumericos();

    @PostConstruct()
    public void init() {
        createPieModel();
    }

    private void createPieModel() {
        this.pieModel = new PieChartModel();

        ChartData dataChart = createCharData();
        pieModel.setData(dataChart);
    }

    private ChartData createCharData() {
        ChartData data = new ChartData();
        PieChartDataSet dataSet = new PieChartDataSet();

        data.setLabels("Produtos Vendidos");
        dataSet.setData(valoresNumericos.gerarValores());
        data.addChartDataSet(dataSet);

        List<String> labels = new ArrayList<>();
        labels.add("Janeiro");
        labels.add("Fevereiro");
        labels.add("Março");
        labels.add("Abril");
        labels.add("Maio");
        labels.add("Junho");
        labels.add("Julho");
        labels.add("Agosto");
        labels.add("Setembro");
        labels.add("Outubro");
        labels.add("Novembro");
        labels.add("Dezembro");
        data.setLabels(labels);

        return data;
    }

    //
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
}

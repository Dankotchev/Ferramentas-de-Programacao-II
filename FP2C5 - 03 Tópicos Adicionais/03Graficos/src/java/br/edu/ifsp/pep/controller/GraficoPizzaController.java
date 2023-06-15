package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.ValoresNumericos;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.charts.pie.PieChartOptions;

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
        
        PieChartOptions chartOptions = defineOptions();
        pieModel.setOptions(chartOptions);
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

    private PieChartOptions defineOptions() {
        PieChartOptions opcoes = new PieChartOptions();
        
        // Titulo do Gráfico
        Title title = new Title();
        title.setDisplay(true);
        title.setFontSize(36);
        title.setPosition("top");
        title.setText("Produtos Vendidos");
        opcoes.setTitle(title);
        
        // Legenda dos conjntos de dados
        Legend legenda = new Legend();
        legenda.setDisplay(true);
        legenda.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("italic");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legenda.setLabels(legendLabels);
        opcoes.setLegend(legenda);
        
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setId("left-y-axis");
        linearAxes.setPosition("left");
        CartesianLinearAxes linearAxes2 = new CartesianLinearAxes();
        linearAxes2.setId("right-y-axis");
        linearAxes2.setPosition("right");
        
        return opcoes;
    }
    
    //
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
}

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
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;

@Named
@RequestScoped
public class GraficoBarrasController implements Serializable {

    private BarChartModel barModel;
    private ValoresNumericos ValoresNumericos = new ValoresNumericos();

    @PostConstruct
    public void init() {
        createBarModel();
    }

    private void createBarModel() {
        this.barModel = new BarChartModel();
        
        // Adicionando no modelo do gráfico
        ChartData data = createCharData();
        barModel.setData(data);

        // Opções
        BarChartOptions opcoes = defineOptions();
        barModel.setOptions(opcoes);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    private ChartData createCharData() {
        // Criando as informações de "dados" do gráfico
        ChartData data = new ChartData();
        
        // Criando os valores e informações de cada conjunto de valores
        BarChartDataSet barDataSet1 = createDataSet1();
        BarChartDataSet barDataSet2 = createDataSet2();
        
        // Adicionando os dataSets no Char Data
        data.addChartDataSet(barDataSet1);
        data.addChartDataSet(barDataSet2);
        
        // Labels "colunas" do gráfico
        List<String> labels = new ArrayList<>();
        labels.add("Janeiro");
        labels.add("Fevereiro");
        labels.add("Março");
        labels.add("Abril");
        labels.add("Mai0");
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

    private BarChartDataSet createDataSet1() {
        BarChartDataSet barChartDataSet = new BarChartDataSet();

        //Definir nome do DataSet, usado na legenda do gráfico
        barChartDataSet.setLabel("Receitas");

        // Atribuindo os valores a serem apresentados no gráfico
        barChartDataSet.setData(ValoresNumericos.gerarValores());
        
        // Atribuindo uma cor para os dados
        barChartDataSet.setBackgroundColor("rgb(75, 192, 192)");

        return barChartDataSet;
    }

    private BarChartDataSet createDataSet2() {
        BarChartDataSet barChartDataSet = new BarChartDataSet();
        barChartDataSet.setLabel("Despesas");
        barChartDataSet.setData(ValoresNumericos.gerarValores());
        barChartDataSet.setBackgroundColor("rgb(255, 99, 132)");
        return barChartDataSet;
    }

    private BarChartOptions defineOptions() {
        BarChartOptions opcoes = new BarChartOptions();
        
        // Titulo do Gráfico
        Title title = new Title();
        title.setDisplay(true);
        title.setFontSize(36);
        title.setPosition("top");
        title.setText("Fluxo de Caixa");
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
}

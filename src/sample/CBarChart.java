package sample;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import static sample.CDatabaseComm.getXsFromDB;
import static sample.CDatabaseComm.getYsFromDB;



public class CBarChart {

    private String[] X = getXsFromDB("warehouses","name").toArray(new String[getXsFromDB("warehouses","name").size()]);
    private Double[] Y = getYsFromDB("warehouses","capacity").toArray(new Double[getYsFromDB("warehouses","capacity").size()]);


    public CBarChart(){
    }

    public void DrawBarChart(){
        Stage stage = new Stage();
        stage.setTitle("TEST");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<>(xAxis, yAxis);
        bc.setTitle("Warehouse summary");
        xAxis.setLabel("Product");
        yAxis.setLabel("Amount");

        XYChart.Series series = new XYChart.Series();
        series.setName("Summary");
        for (int i =0;i<X.length;i++){
            series.getData().add(new XYChart.Data(X[i],Y[i]));
        }
        Scene scene = new Scene(bc,800,600);
        bc.getData().addAll(series);
        bc.setLegendVisible(false);
        stage.setScene(scene);
        stage.show();
    }

}

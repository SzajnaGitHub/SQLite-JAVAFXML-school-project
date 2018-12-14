package sample;

import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import static sample.CDatabaseComm.getXsFromDB;
import static sample.CDatabaseComm.getYsFromDB;

public class CLineChart {
    private static String[] X = getXsFromDB("balance","name").toArray(new String[getXsFromDB("balance","name").size()]);
    private static Double[] Y = getYsFromDB("balance","income").toArray(new Double[getYsFromDB("balance","income").size()]);

    public static void DrawLineChart(){
        Stage stage = new Stage();
        stage.setTitle("Balance");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        yAxis.setLabel("$$$");
        final LineChart<String,Number> lineChart = new LineChart<>(xAxis,yAxis);

        lineChart.setTitle("Balance");
        XYChart.Series series = new XYChart.Series();

        for (int i =0;i<X.length;i++){
            series.getData().add(new XYChart.Data(X[i],Y[i]));
        }
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        series.setName("Balance");
        stage.setScene(scene);
        stage.show();
    }
}

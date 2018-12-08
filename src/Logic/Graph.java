package Logic;

import Data.CSVHospital;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class Graph {

    public BarChart graphRatings(ArrayList<CSVHospital> hospitals){

        int rating1 = 0;
        int rating2 = 0;
        int rating3 = 0;
        int rating4 = 0;
        int rating5 = 0;
        int ratingNA = 0;

        for (CSVHospital h1 : hospitals){
            if (h1.getRating() != null)

                switch(h1.getRating()){
                    case "1":
                        rating1++;
                        break;

                    case "2":
                        rating2++;
                        break;

                    case "3":
                        rating3++;
                        break;

                    case "4":
                        rating4++;
                        break;

                    case "5":
                        rating5++;
                        break;

                    case "Not Available":
                        ratingNA++;
                        break;
                }

        }

        CategoryAxis xAxis    = new CategoryAxis();
        xAxis.setLabel("Number of Hospitals");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Hospital Rating");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();

        dataSeries1.getData().add(new XYChart.Data("1", rating1));
        dataSeries1.getData().add(new XYChart.Data("2"  , rating2));
        dataSeries1.getData().add(new XYChart.Data("3"  , rating3));
        dataSeries1.getData().add(new XYChart.Data("4"  , rating4));
        dataSeries1.getData().add(new XYChart.Data("5"  , rating5));
        dataSeries1.getData().add(new XYChart.Data("NA"  , ratingNA));

        barChart.getData().add(dataSeries1);

        return barChart;
    }



}

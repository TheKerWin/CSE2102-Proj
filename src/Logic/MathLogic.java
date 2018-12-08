package Logic;

import Data.CSVHospital;

import java.util.ArrayList;

public class MathLogic {

    public double averageRating(ArrayList<CSVHospital> hospitals){

        double count = 0;
        double result = 0;

        for (CSVHospital h1 : hospitals){
            if (h1.getRating() != null)
                if (!h1.getRating().equals("Not Available")){
                    result = result + Double.parseDouble(h1.getRating());
                    count++;
                }
        }

        return result/count;
    }



    public int total(ArrayList<CSVHospital> hospitals){

        int count = 0;

        for (CSVHospital h1 : hospitals){
            if (h1 != null)
                count++;
        }

        return count;
    }
}

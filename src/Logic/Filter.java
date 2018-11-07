package Logic;

import Data.CSVHospital;

import java.util.ArrayList;

public class Filter {

    public ArrayList<CSVHospital> filterOutRatingLowerThan(ArrayList<CSVHospital> x , int y){
        ArrayList<CSVHospital> result = new ArrayList<CSVHospital>();
        for (CSVHospital h1 : x) {
            if (h1.getRating() != null)
                if (!h1.getRating().equals("Not Available"))
                    if (Integer.parseInt(h1.getRating()) > y) {
                        result.add(h1);
                    }
        }
        return result;
    }

    public ArrayList<CSVHospital> filterOutRatingGreaterThan(ArrayList<CSVHospital> x , int y){
        ArrayList<CSVHospital> result = new ArrayList<CSVHospital>();
        for (CSVHospital h1 : x) {
            if (h1.getRating() != null)
                if (!h1.getRating().equals("Not Available"))
                    if (Integer.parseInt(h1.getRating()) < y) {
                        result.add(h1);
                    }
        }
        return result;
    }
}

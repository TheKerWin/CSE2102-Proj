package Logic;

import Data.CSVHospital;

import java.util.ArrayList;

public class Sort {

    public ArrayList<CSVHospital> sortByHighRating(ArrayList<CSVHospital> x){
        ArrayList<CSVHospital> result = new ArrayList<CSVHospital>();
        for (CSVHospital h1 : x) {
            if (h1.getRating() != null)
                if (!h1.getRating().equals("Not Available"))

                    for (int i = 5 ; i >0 ; i--){
                        if (Integer.parseInt(h1.getRating()) == i) {
                            result.add(h1);
                        }
                    }
        }
        return result;
    }



    public ArrayList<CSVHospital> sortStateAlphabetically(ArrayList<CSVHospital> x){
        ArrayList<CSVHospital> result = new ArrayList<CSVHospital>();
        for (CSVHospital h1 : x) {
            if (h1.getRating() != null)
                if (!h1.getRating().equals("Not Available"))

                    for (int i = 5 ; i >0 ; i--){
                        if (Integer.parseInt(h1.getRating()) == i) {
                            result.add(h1);
                        }
                    }
        }
        return result;
    }


}

package Logic;

import Data.CSVHospital;

import java.util.ArrayList;

public class Filter {

    public ArrayList<CSVHospital> filterOutRatingLowerOrEqual(ArrayList<CSVHospital> x , int y){
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

    public ArrayList<CSVHospital> filterOutRatingGreaterOrEqual(ArrayList<CSVHospital> x , int y){
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


    public ArrayList<CSVHospital> filterInExactMatch(ArrayList<CSVHospital> hospitalList , String choice, String value){
        ArrayList<CSVHospital> result = new ArrayList<CSVHospital>();

        for (CSVHospital h : hospitalList) {
            switch (choice) {
                case "Hospital Type": {
                    if (h.getType() != null)
                        if (h.getType().toLowerCase().contains(value.toLowerCase()))
                            result.add(h);
                }
                case "Hospital Ownership": {
                    if (h.getOwnership() != null)
                        if (h.getOwnership().toLowerCase().contains(value.toLowerCase()))
                            result.add(h);
                }


            }

        }

            ///if (h.getRating() != null)
            ///    if (!h1.getRating().equals("Not Available"))
                    ///if (Integer.parseInt(h1.getRating()) < y) {
                    ///    result.add(h1);
                    ///}

        return result;
    }


}

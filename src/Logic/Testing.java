package Logic;

import Data.CSVHospital;
import java.util.ArrayList;

public class Testing {

    public void printHospitals(ArrayList<CSVHospital> hosp) {
        int count = 0;
        for ( CSVHospital h1 : hosp) {
            System.out.println(h1.getName());
            System.out.println(h1.getRating());
            count++;
        }
        System.out.println("Number of entries: " + count);
    }
}

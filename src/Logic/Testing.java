package Logic;

import Data.CSVHospital;
import Data.CSVInput;

import java.util.ArrayList;

public class Testing {

    public void runTest() {
        ArrayList<CSVHospital> hospitals;
        ArrayList<CSVHospital> temp;

        CSVInput c1 = new CSVInput();
        c1.setkbdFilePath();
        c1.generateHospitalList();
        hospitals = c1.getHospitalList();

        ///Testing
        Filter f1 = new Filter();
        temp = f1.filterRatingLowerThan(hospitals, 3);
        for ( CSVHospital h1 : temp) {
            System.out.println(h1.getName());
        }
    }
}

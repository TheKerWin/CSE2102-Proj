package Controller;

import Data.CSVHospital;
import Data.CSVInput;
import Logic.Filter;
import Logic.Testing;
import java.util.ArrayList;

public class Controller {

    private String CSVLocation;
    private CSVInput csv1 = new CSVInput();
    private Filter f1 = new Filter();
    private Testing t1 = new Testing();
    private ArrayList<CSVHospital> hospitals;
    private ArrayList<CSVHospital> tempHospitals;



    public void IntakeCSV() {
        csv1.setFilePath(this.getCSVLocation());
        csv1.generateHospitalList();
        this.hospitals = csv1.getHospitalList();
        this.tempHospitals = this.hospitals;
    }

    public void filterOutLowerRating(int x){
        this.tempHospitals = f1.filterOutRatingLowerThan(this.tempHospitals , x);
    }

    public void printHospitals(){
        t1.printHospitals(this.tempHospitals);
    }



    public String getCSVLocation() {
        return CSVLocation;
    }

    public void setCSVLocation(String loc) {
        this.CSVLocation = loc;
    }

    public ArrayList<CSVHospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(ArrayList<CSVHospital> hospitals) {
        this.hospitals = hospitals;
    }

}

package Controller;

import Data.CSVHospital;
import Data.CSVInput;
import Logic.Filter;
import Logic.Sort;
import Logic.Testing;
import java.util.ArrayList;

public class DataController {

    private String CSVLocation;

    private CSVInput csv1 = new CSVInput();
    private Filter f1 = new Filter();
    private Sort s1 = new Sort();
    private Testing t1 = new Testing();

    private ArrayList<CSVHospital> hospitals;
    private ArrayList<CSVHospital> modHospitals;



    ///CSV input handling API methods
    public String getCSVLocation() {
        return CSVLocation;
    }

    public void setCSVLocation(String loc) {
        this.CSVLocation = loc;
    }

    public void intakeCSV() {
        csv1.setFilePath(this.getCSVLocation());
        csv1.generateHospitalList();
        this.hospitals = csv1.getHospitalList();
        this.modHospitals = this.hospitals;
    }



    ///Hospital list manual API methods.
    ///Note: Hospital list will auto populate when intakeCSV() is called
    public void resetHospitalList(){
        this.modHospitals = hospitals;
    }

    public void setHospitals(ArrayList<CSVHospital> hospitals) {
        this.hospitals = hospitals;
        this.modHospitals = hospitals;
        this.resetHospitalList();
    }

    public ArrayList<CSVHospital> getOriginalHospitals() {
        return hospitals;
    }

    public ArrayList<CSVHospital> getModifiedlHospitals() {
        return modHospitals;
    }



    ///Filter API methods
    public void filterOutRatingLowerOrEqual(int x){
        this.modHospitals = f1.filterOutRatingLowerOrEqual(this.modHospitals , x);
    }

    public void filterOutRatingGreaterOrEqual(int x){
        this.modHospitals = f1.filterOutRatingGreaterOrEqual(this.modHospitals , x);
    }



    ///Sort API Methods
    public void sortByHighRating(){
        this.modHospitals = s1.sortByHighRating(this.modHospitals);
    }

    public void filterInExactMatch(String choice, String value){
        this.modHospitals = f1.filterInExactMatch(this.modHospitals, choice, value);
    }



    ///Testing API methods
    public void printHospitals(){
        t1.printHospitals(this.modHospitals);
    }



    public StringBuilder makeTextViewPrintable(){
        StringBuilder builder = new StringBuilder();
        for (CSVHospital hospital : this.getModifiedlHospitals()){
            builder.append(hospital + "\n");
        }
        return builder;
    }

    public boolean hasData(){
        if (this.hospitals != null){
            return true;
        }
        else
            return false;
    }


}

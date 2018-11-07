package GUI;

import Data.CSVHospital;
import Data.CSVInput;
import Logic.Filter;

import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {

    public void runPrompt(){
        CSVInput c1 = new CSVInput();
        Scanner kbd = new Scanner(System.in);
        Filter f1 = new Filter();
        int select = 0;

        System.out.println("Select how to test");
        System.out.println("1.) Rating Lower than");
        System.out.println("2.) Rating Greater than");
        select = kbd.nextInt();

        if (select == 1){
            System.out.print("Enter File address of CSV file: ");
            c1.setkbdFilePath();
            System.out.println("Enter rating: ");
            int tempRating = kbd.nextInt();

            c1.generateHospitalList();

            ArrayList<CSVHospital> tempHosp = f1.filterRatingLowerThan(c1.getHospitalList() , tempRating);

            for (CSVHospital x : tempHosp){
                System.out.println(x.getName());
                System.out.println(x.getRating());
                System.out.println("==============");
            }
        }

    }

}

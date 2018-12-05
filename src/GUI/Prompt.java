package GUI;

import Controller.DataController;
import java.util.Scanner;

public class Prompt {

    public void runPrompt(){

        ///GUI should only implement a new instance of Controller
        DataController c1 = new DataController();



        Scanner kbd = new Scanner(System.in);
        int select = 0;
        boolean run = true;

        System.out.println("Set CSV File Location: ");
        c1.setCSVLocation(kbd.next());
        System.out.println("======Processing CSV File=======");
        c1.intakeCSV();

        while (run) {
            System.out.println("Select how to test: ");
            System.out.println("1.) Filter out ratings less than or equal to");
            System.out.println("2.) Filter out ratings greater than or equal to");
            select = kbd.nextInt();

            if (select == 1) {
                System.out.print("Filter out ratings Less than: ");
                c1.filterOutRatingLowerOrEqual(kbd.nextInt());
                c1.printHospitals();
                ///check greater or equal to condition on methods
            }

            if (select == 2) {
                System.out.print("Filter out ratings Greater than: ");
                c1.filterOutRatingGreaterOrEqual(kbd.nextInt());
                c1.printHospitals();
            }

            if (select == 3) {
                System.out.print("Resetting Hospital List");
                c1.resetHospitalList();
                c1.printHospitals();
            }

            if (select == 0){
                run = false;
            }
        }
    }

}

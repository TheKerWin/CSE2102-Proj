package GUI;

import Controller.Controller;
import java.util.Scanner;

public class Prompt {

    public void runPrompt(){

        ///GUI should only implement a new instance of Controller
        Controller c1 = new Controller();

        Scanner kbd = new Scanner(System.in);
        int select = 0;
        boolean run = true;

        System.out.println("Set CSV File Location: ");
        c1.setCSVLocation(kbd.next());
        System.out.println("======Processing CSV File=======");
        c1.IntakeCSV();

        while (run) {
            System.out.println("Select how to test: ");
            System.out.println("1.) Filter out ratings less than");
            System.out.println("2.) Filter out ratings less than");
            select = kbd.nextInt();

            if (select == 1) {
                System.out.print("Filter out ratings Less than: ");
                c1.filterOutLowerRating(kbd.nextInt());
                c1.printHospitals();
            }

            if (select == 2) {
                c1.filterOutLowerRating(3);
                c1.printHospitals();
            }

            if (select == 0){
                run = false;
            }
        }
    }

}

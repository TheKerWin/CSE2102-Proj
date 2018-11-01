package OpenCSVTesting;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try{
            CSVReader reader = new CSVReader( new FileReader("C:\\Users\\Sonny\\Desktop\\HospitalGeneralInformation.csv"));
            String[] nextLine;
            while((nextLine = reader.readNext()) != null){
                if (nextLine != null){
                    System.out.println(Arrays.toString(nextLine));
                }
            }
        }

        catch(Exception e){
            System.out.println(e);
        }

    }
}

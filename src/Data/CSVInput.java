package Data;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CSVInput {



    private ArrayList<CSVHospital> hospitals = new ArrayList<CSVHospital>();
    private String filePath;
    ///private String filePath = "C:\\Users\\Sonny\\Desktop\\HospitalGeneralInformation.csv";



    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setkbdFilePath() {
        Scanner kbd = new Scanner(System.in);
        this.filePath = kbd.nextLine();
    }

    public void generateHospitalList(){
        if (filePath != null) {
            try (
                    Reader reader = Files.newBufferedReader(Paths.get(filePath))
            )

            {
                CsvToBean<CSVHospital> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(CSVHospital.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                Iterator<CSVHospital> csvHospitalIterator = csvToBean.iterator();

                while (csvHospitalIterator.hasNext()) {
                    hospitals.add(csvHospitalIterator.next());
                    ///System.out.println("Name : " + csvHospital.getName());
                    ///System.out.println("==========================");
                }
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }

        else {
            System.out.println("***ERROR*** The filepath is null");
        }
    }

    public ArrayList<CSVHospital> getHospitalList(){
        return hospitals;
    }
}

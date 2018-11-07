package Data;

public class MainData {

    public static void main(String[] args){

        int count = 0;

        CSVInput c1 = new CSVInput();
        c1.setkbdFilePath();
        c1.generateHospitalList();
        for (CSVHospital h1 : c1.getHospitalList()){
            System.out.println(h1.getName());
            count++;
        }

        System.out.println("Number of entries: " + count);
    }
}
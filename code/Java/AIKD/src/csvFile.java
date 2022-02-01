import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class csvFile {

    public static String[][] Read(String filename, boolean printOrNot) {


        System.out.println("+------------------------------------------------+");
        System.out.println("|      1 . Functions that read the CSV file      |");
        System.out.println("+------------------------------------------------+");


        String [][] dataArray = new String[51][8];

        File file = new File(".");//full file path URL



        String path = file.getAbsolutePath()+"\\"+ filename+".csv";


        String line  =  "";

        try {

            BufferedReader br =  new BufferedReader(new FileReader(path));

            int rowCounter  = 0;

            while((line = br.readLine())  != null){

                //System.out.println(line);

                String[] values = line.split(";");


                for(int colCounter = 0;colCounter<=7; colCounter++){

                    if(printOrNot ==true){System.out.println(values[colCounter]+ " | ");}


                    dataArray[rowCounter][colCounter] = values[colCounter];
                }

                rowCounter++;
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("|");
        System.out.println("+--> CSV Data correctly read");
        return dataArray;
    }

    public static void collectId(){


        String [][] dataFrame = Read("AIKD_project", false);

        String [] collection = new String[dataFrame.length];

        System.out.println(dataFrame.length+" rows collected.");

        for(int i =0; i< dataFrame.length; i++){

            collection[i] =  dataFrame[i][0];
        }
    }
}

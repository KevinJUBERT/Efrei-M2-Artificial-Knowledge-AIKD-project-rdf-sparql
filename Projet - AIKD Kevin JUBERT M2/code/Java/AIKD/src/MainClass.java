import org.apache.jena.Jena;

import java.io.File;
import java.io.FileNotFoundException;

public class MainClass {

    public static void main(String...args) throws FileNotFoundException {

       // RDF file generator
        JenaModel.Build(csvFile.Read("AIKD_project", false));
        // Query menu executor
        JenaModel.QueryMenu();


    }
}

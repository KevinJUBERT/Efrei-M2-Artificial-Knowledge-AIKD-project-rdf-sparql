import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Scanner;



public class JenaModel {

    static String inputfile = "AIKDModel.rdf";

    //  -------------------------- Jena Model  --------------------------------

    public static void Build(String [][] dataFrame) throws FileNotFoundException {

        System.out.println("|");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|    2 . Functions that create a Jena model based on the lines of the CSV and the RDF/RDFS properties/classes/elements that you model   |");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");



        //dataFrame =  csvFile.Read("AIKD_project");


        // CREATION OF THE EMPTY MODEL
        Model model  = ModelFactory.createDefaultModel();

        // -------------------------- ARTICLE :  RESOURCE/PROPERTY ---------------------------

        // RESOURCE : ARTICLE
        //Resource articles = model.createResource( "urn:ex:article" );  // CHANGE/ADD ARTICLE BY ARTICLE ID

        // PROPERTY: ARTICLE
        Property id      = model.createProperty( "urn:ex:id" );
        Property title   = model.createProperty( "urn:ex:title" );
        Property domain  = model.createProperty( "urn:ex:domain" );
        Property topic   = model.createProperty( "urn:ex:topic" );
        Property date    = model.createProperty( "urn:ex:date" );
        Property urlarticle = model.createProperty( "urn:ex:urlarticle" );

        // SPECIAL PROPERTY :  ARTICLE
        Property writeBy = model.createProperty( "urn:ex:writeBy" );
        Property publishedBy = model.createProperty( "urn:ex:publishedBy" );

        // PROPERTY: AUTHOR
        Property name       = model.createProperty( "urn:ex:author:name" );
        Property lastname   = model.createProperty( "urn:ex:author:lastname");
        Property fullname   = model.createProperty( "urn:ex:author:fullname");

        // PROPERTY : SOURCE
        Property label       = model.createProperty( "urn:ex:source:label");
        Property url         = model.createProperty( "urn:ex:source:url");



        // ADD PROPERTY : ARTICLE
        for(int i=0; i<dataFrame.length; i++){

            if(i>0){

                String nameTest = "";  String lastnameTest  = "";
                String urlTest = dataFrame[i][7].split(" : ")[1];
                String labelTest = dataFrame[i][7].split(" : ")[0];

                String fullnameTest = dataFrame[i][4];

                if(dataFrame[i][4].contains(" ")){
                    nameTest     = dataFrame[i][4].split(" ")[0]; // Author first name
                    lastnameTest = dataFrame[i][4].split(" ")[1]; // Author last name
                }
                else{
                    nameTest     =    dataFrame[i][4]; // Author first name
                    lastnameTest =  ""; // Author last name
                }

                Resource articles        = model.createResource( "urn:ex:article:"+dataFrame[i][0] );
                Resource author = model.createResource( "urn:ex:article:"+dataFrame[i][0]+":author" );
                Resource source = model.createResource( "urn:ex:article:"+dataFrame[i][0]+":source" );



                author.addProperty(name,nameTest);
                author.addProperty(lastname,lastnameTest);
                author.addProperty(fullname,fullnameTest);

                source.addProperty(label, labelTest);
                source.addProperty(url,urlTest);


                String domainIt = (dataFrame[i][6].charAt(dataFrame[i][6].length() -1) == ' ') ? dataFrame[i][6].substring(0,dataFrame[i][6].length()-1).toUpperCase(Locale.ROOT) : dataFrame[i][6].toUpperCase() ;



                articles.addProperty(           id,   dataFrame[i][0])
                        .addProperty(        title,   dataFrame[i][2])
                        .addProperty(        topic,   dataFrame[i][5])
                        .addProperty(       domain,   domainIt)
                        .addProperty(         date,   dataFrame[i][3])
                        .addProperty(   urlarticle,   dataFrame[i][1])
                        .addProperty(      writeBy,   author)
                        .addProperty(  publishedBy,   source);


            }
        }

        System.out.println("|");
        System.out.println("+--> Jena Model is correctly built");



        // -------------------------- OUTPUT : SCRIPT -----------------------------------------
        model.write( System.out, "RDF/XML-ABBREV" );

        // -------------------------- OUTPUT : XML FILE -----------------------------------------
        //String file = "AIKDModel.txt"; // txt
        //String file = "AIKDModel.rdf"; // xml
        //OutputStream os = new FileOutputStream(file);
        //model.write(os);


        System.out.println("|");
        System.out.println("+--> Jena Model file has been correctly generated as \'"+inputfile+"\'");




    }

    //  --------------------------  Menu  --------------------------------

    public static void QueryMenu(){

        System.out.println("|");
        System.out.println("+=====================================+");
        System.out.println("|    Welcome to the Query AIKD menu   |");
        System.out.println("+=====================================+");

        Scanner sc = new Scanner(System.in);



        boolean check = false;
        int counter = 0;
        while(check !=true){

            System.out.println("Select the ID number of your operation");

            if (counter>0){
                System.out.print("*** ENTER A RANDOM NUMBER DIFFERENT OF THOSE IN THE LIST TO QUIT  ***  ");
            }
            System.out.println("+===========================================================+");
            System.out.println("| 0  | Read .csv file                                       |");
            System.out.println("| 1  | Consult all articles                                 |");
            System.out.println("| 2  | Consult the list of the last 20 articles             |");
            System.out.println("| 3  | Consult article published befor the 01 December 2021 |");
            System.out.println("| 4  | Research articles by a specific domain               |");
            System.out.println("| 5  | Consult the source of ours articles                  |");
            System.out.println("| 6  | Consult article published by a specific author       |");
            System.out.println("| 7  | Number of article published by author                |");
            System.out.println("| 8  | Number of article by year                            |");
            System.out.println("| 9  | Study of the variability of article by domains       |");
            System.out.println("| 10 | Study of the variability of article topics           |");
            System.out.println("| 11 | Search an author domain of speciality                |");
            System.out.println("| 12 | Articles source list                                 |");
            System.out.println("+===========================================================+");

            int choice =  sc.nextInt();

            switch(choice){

                case 0:
                    csvFile.Read("AIKD_project",true);
                    break;

                case 1:
                    QueryAllArticles();
                    break;

                case 2:
                    Query20LatestArticles();
                    break;

                case 3:
                    QueryArticlesAfter01December();
                    break;

                case 4:
                    QueryListDomain();

                    System.out.println("|");
                    System.out.println("+=====================================+");
                    System.out.println("|           Enter a domain            |");
                    System.out.println("+=====================================+");

                    System.out.println();

                    String domain = sc.next();


                    QueryArticlesByDomain(domain);
                    break;

                case 5:
                    Query20LatestArticles();
                    break;

                case 6:


                    QueryListAuthor();

                    System.out.println("|");
                    System.out.println("+=====================================+");
                    System.out.println("|           Enter an author           |");
                    System.out.println("+=====================================+");

                    System.out.println();

                    String author = sc.next();

                    QueryArticlePublishedByAuthor(author);
                    break;

                case 7:
                    QueryNumberofArticlesByAuthor();
                    break;

                case 8:
                    for(int i = 2019;i<=2022;i++){

                        System.out.print("Year : "+i);
                        QuerNumberofArticlesByYear(i);
                        System.out.println();
                    }
                    break;

                case 9 :
                    QueryPourcentageOfArticlesDomain();
                    break;
                case 10 :
                    QueryDomainVariability();
                    break;

                case 11:
                    QueryAuthorDomainSpeciality();
                    break;

                case 12:
                    QueryArticleSourceList();
                    break;
                default:

                    System.out.println("Goodbye 🖐️");
                    check =true;

            }
        }



    }

    //  -------------------------- Queries  --------------------------------

    public static void QueryAllArticles(){



        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }




        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT *  where { " +
                "?url_id <urn:ex:id>     ?ID ."    +
                "?url_id <urn:ex:topic>  ?Topic ." +
                "?url_id <urn:ex:domain> ?Domain ."+
                "?url_id <urn:ex:title>  ?Title ." +
                "?url_id <urn:ex:date>   ?Date . " +
                "?url_id <urn:ex:urlarticle>   ?url_article . }" );


        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //

    public static void Query20LatestArticles(){


        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }




        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT ?Domain ?Title ?Date ?url_article   \n" +
                "WHERE \n" +
                "{ \n" +
                "                ?url_id <urn:ex:domain> ?Domain .\n" +
                "                ?url_id <urn:ex:title>  ?Title .\n" +
                "                ?url_id <urn:ex:date>   ?Date .\n" +
                "                ?url_id <urn:ex:urlarticle>   ?url_article . \n" +
                "}\n" +
                "ORDER BY DESC(?Date)\n" +
                "LIMIT 20");


        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK

    public static void QueryArticlesAfter01December(){

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }




        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT ?Date ?Domain ?Title ?URL \n" +
                "WHERE {\n" +
                "    \t\t\t?url_id <urn:ex:domain> ?Domain .\n" +
                "    \t\t\t?url_id <urn:ex:title>  ?Title .\n" +
                "                ?url_id <urn:ex:date>   ?Date .\n" +
                "                ?url_id <urn:ex:urlarticle>   ?URL . \n" +
                "    \t\t\t\n" +
                "    FILTER(?Date > \"2021-12-01\")\n" +
                "\n" +
                "}");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK

    public static void QueryListDomain(){

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }




        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT DISTINCT ?Domain  where {     \n" +
                "                ?url_id <urn:ex:domain> ?Domain .\n" +
                " }");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK

    public static void QueryArticlesByDomain(String domain){


        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }




        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT ?Date ?Domain ?Topic ?URL \n" +
                "WHERE{     \n" +
                "                ?url_id <urn:ex:domain> ?Domain .\n" +
                "    \t\t\t?url_id <urn:ex:topic> ?Topic .\n" +
                "    \t\t\t?url_id <urn:ex:date> ?Date .\n" +
                "    \t\t\t?url_id <urn:ex:urlarticle> ?URL .\n" +
                "   \n" +
                "    FILTER regex(?Domain, ucase(\'"+domain.toString()+"\'), \"i\")\n" +
                " }\n" +
                "\n" +
                "ORDER BY DESC(?Date)");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK

    public static void QueryArticleSourceList(){


        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }




        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT DISTINCT ?author_name ?author_lastname  where {\n" +
                "\n" +
                "                ?url_id <urn:ex:publishedBy>/<urn:ex:source:label> ?author_name .\n" +
                "                ?url_id <urn:ex:publishedBy>/<urn:ex:source:url> ?author_lastname .\n" +
                "    \n" +
                "\n" +
                "}");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK

    public static void QueryListAuthor(){

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }

        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT DISTINCT ?Author  where {\n" +
                "                ?url_id <urn:ex:writeBy>/<urn:ex:author:fullname> ?Author .\n" +
                "}");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } // OK

    public static void QueryArticlePublishedByAuthor(String name){

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }




        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT ?Date ?Name ?Domain ?Title ?URL\n" +
                "WHERE{     \n" +
                "                ?url_id <urn:ex:domain> ?Domain .\n" +
                "    \t\t\t?url_id <urn:ex:title> ?Title .\n" +
                "    \t\t\t?url_id <urn:ex:date> ?Date .\n" +
                "    \t\t\t?url_id <urn:ex:urlarticle>   ?URL . \n" +
                "                ?url_id <urn:ex:writeBy>/<urn:ex:author:fullname> ?Name .\n" +
                "    \n" +
                "   \n" +
                "    FILTER regex(?Name, ucase(\""+name+"\"), \"i\")\n" +
                " }\n" +
                "\n" +
                "ORDER BY DESC(?Date)");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } // OK

    public static void QueryNumberofArticlesByAuthor(){

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }




        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT DISTINCT  ?author_name (COUNT(?author_name) as ?total)\n" +
                "WHERE { \n" +
                "\t\n" +
                "    ?url_id <urn:ex:writeBy>/<urn:ex:author:fullname> ?author_name .\n" +
                "\n" +
                "} GROUP BY ?author_name\n" +
                "ORDER BY DESC(COUNT(?author_name)) ?author_name");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK

    public static void QuerNumberofArticlesByYear(int year){

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }


        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT ( (COUNT(?id_article)) AS ?result)\n" +
                "WHERE {\n" +
                "    \t\t\t?url_id <urn:ex:id>          ?id_article .\n" +
                "    \t\t\t?url_id <urn:ex:date>        ?Date .\n" +
                "    \n" +
                "    FILTER regex(str(?Date), \""+String.valueOf(year)+"\") .\n" +
                "\n" +
                "}");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK

    public static void QueryPourcentageOfArticlesDomain(){

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }


        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT \t?Domain\n" +
                "\t\t(COUNT(distinct (?Id)) as ?Number_of_articles)\n" +
                "\t\t(COUNT(distinct (?Id))*100/50 as ?Pourcentage)\n" +
                "\n" +
                "WHERE{     \n" +
                "    \t\t\t?url_id <urn:ex:id> ?Id .\n" +
                "    \t\t\t?url_id <urn:ex:domain> ?Domain .\n" +
                "    \t\t\t?url_id <urn:ex:writeBy>/<urn:ex:author:fullname> ?Author_name.\n" +
                "    \n" +
                " }GROUP BY ?Domain\n" +
                "ORDER BY DESC(?Pourcentage) ?Domain");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK

    public static void QueryDomainVariability(){

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }


        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT\n" +
                "\t   (COUNT(distinct (?Id)) as ?Number_of_articles) \n" +
                "\t   (COUNT(distinct (?Domain)) as ?Nomber_of_domains) \n" +
                "\t   ((?Nomber_of_domains/?Number_of_articles)*100 as ?pourcentage_of_domain_variability) \n" +
                "WHERE{     \n" +
                "                ?url_id <urn:ex:id> ?Id .\n" +
                "    \t\t\t?url_id <urn:ex:domain> ?Domain .\n" +
                "    \t\t\t?url_id <urn:ex:writeBy>/<urn:ex:author:fullname> ?author_lastname .\n" +
                " }GROUP BY ?author_name");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK

    public static void QueryAuthorDomainSpeciality(){

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputfile);

        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputfile + " not found");
        }


        // read the RDF/XML file
        model.read(in, null);

        Query query = QueryFactory.create( "SELECT \t?Name ?Domain\n" +
                "\t\t(COUNT(?Name) as ?Number_of_articles)\n" +
                "\t\t(COUNT(?Name)*100/50 as ?Pourcentage)\n" +
                "\n" +
                "WHERE{     \n" +
                "    \t\t\t?url_id <urn:ex:id> ?Id .\n" +
                "    \t\t\t?url_id <urn:ex:domain> ?Domain .\n" +
                "    \t\t\t?url_id <urn:ex:writeBy>/<urn:ex:author:fullname> ?Name.\n" +
                "    \n" +
                " }GROUP BY ?Name ?Domain\n" +
                "ORDER BY DESC(?Pourcentage) ?Name");



        QueryExecution exec = QueryExecutionFactory.create( query, model );
        ResultSetFormatter.out( exec.execSelect() );

        // write it to standard out
        //model.write(System.out);



    } //OK
}

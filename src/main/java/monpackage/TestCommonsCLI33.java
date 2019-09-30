package monpackage;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import org.apache.commons.cli.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestCommonsCLI33 {


    public static void main(String[] args) {

        pathDirectoryCurrent(); // affiche le chemin du  répertoire courant

        Options options = new Options();

        Option help = new Option( "help", false,"print this message :  gradle run --stacktrace --args=\"-help \"  \n" );
        Option createZipFile = new Option( "c", true,"create zip file \n Example : \n gradle run --stacktrace --args=\"-c monfichier3.zip    tp1Gradle.pdf README.tx \"  \n \n  gradle run --stacktrace --args=\"-c monfichier2.zip     zipTest\\source\\file1.txt zipTest\\source\\file2.pdf zipTest\\source\\file3.png\n" +
                "\"\n ");
        Option extractZipFile = new Option( "x", true,"extract zip file \n Example : \n gradle run --stacktrace --args=\"-x monfichier3.zip     zipTest\\destination\"   \n " );

        options.addOption(help);
        options.addOption(createZipFile);
        options.addOption(extractZipFile);

        // create the parser
        CommandLineParser parser = new DefaultParser();

        CommandLine commande = null;

        try {
            // Parse the arguments according to the specified options.
            commande = parser.parse( options, args );
        }
        catch( ParseException exp ) {
            // oops, something went wrong
            System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
            // automatically generate the help statement
            help(options);
            System.exit(0);
        }

        if (commande.hasOption("help")) {
            // automatically generate the help statement
            help(options);
        }

        if (commande.hasOption("c")) {
            // required Option Argument Value
            String zipFileName = commande.getOptionValue("c");
            if(zipFileName != null) {
                System.out.println(" Option Argument Value  zipFileName = "+zipFileName);

                // Récupérer les options et les arguments non reconnus restants
                List<String> argsRestants= commande.getArgList();
                if(argsRestants.isEmpty()) {
                    // automatically generate the help statement
                    help(options);
                } else {
                    List<String> listeFichiers = new ArrayList();
                    for (String fichier : argsRestants) {
                        System.out.println("CREATE--files-- " + fichier);
                        listeFichiers.add(fichier);
                    }
                    creatingZip(zipFileName, listeFichiers);
                }
            }
            else {
                // automatically generate the help statement
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "TestCommonsCLI", options );
            }
        }

        if (commande.hasOption("x")) {
            // required Option Argument Value
            String zipFileName = commande.getOptionValue("x");
            if(zipFileName != null) {
                System.out.println(" Option Argument Value  zipFileName = "+zipFileName);

                // Récupérer les options et les arguments non reconnus restants
                String[] argsRestants= commande.getArgs();
                if(argsRestants.length==0) {
                    // automatically generate the help statement
                    help(options);
                } else {
                    String dirDestination = pathDirectoryCurrent();
                    String argRestant = argsRestants[0];
                    System.out.println("eXtract dirDestination: " + argRestant);
                    dirDestination = dirDestination+argRestant;

                    extractingZip(zipFileName, dirDestination);
                }
            }
            else {
                // automatically generate the help statement
                help(options);
            }
        }
    }

    private static void help(Options options)
    {
        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "TestCommonsCLI", options );
    }



    /**
     * Adds the list of input files to the zip file with default zip parameters. If zip file does not exist,
     * this method creates a new zip file.
     *
     * @param zipFileName
     * @param filesToAdd
     */
    private static void creatingZip(String zipFileName, List<String> filesToAdd)
    {
        String pathCurrentDir = pathDirectoryCurrent();
        // Creating a zip file with multiple files / Adding multiple files to an existing zip
        //  new ZipFile("filename.zip").addFiles(Arrays.asList(new File("first_file"), new File("second_file")));
        try {
           // new ZipFile(zipFileName).addFiles(filesToAdd);
            for (String fichier : filesToAdd) {
                new ZipFile(zipFileName).addFile(new File(pathCurrentDir+fichier));
            }
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     *   Extracts all the files in the given zip file to the input destination path.
     *  If zip file does not exist or destination path is invalid then an
     *  exception is thrown.
     * @param zipFileName
     * @param directoryDestination
     */
    private static void extractingZip(String zipFileName, String directoryDestination)
    {
        //  Extracting All files in a zip
        try {
            new ZipFile(zipFileName).extractAll(directoryDestination);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     * current directory path
     * @return
     */
    public static String  pathDirectoryCurrent()
    {
        String path=new File("").getAbsolutePath();
        System.out.println("Current Directory Path (Project Directory) : "+path+File.separator);
        return path+File.separator;
    }

}

package application.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReaderBase implements Reader{

    private Scanner reader;

    protected ReaderBase(String filePath) {

        this.reader = setScanner(filePath);
    }

    /**
     * The method takes a file path as parameter and returns a Scanner object that can read the file at the given path.
     * If the file is not found and the Scanner throws FileNotFoundException, the exception is caught and а new RuntimeException
     * with an error message "The file ... is not found!" is thrown.
     */

    private Scanner setScanner(String filePath) {

        try {
            Scanner scanner = new Scanner(new File(filePath));
            return scanner;
        } catch (FileNotFoundException e) {

            String[] fileInfo;

            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                fileInfo = filePath.split("\\\\");
            } else {
                fileInfo = filePath.split("/");
            }

            throw new RuntimeException(String.format("The file \"%s\" is not found!", fileInfo[fileInfo.length-1]));
        }
    }

    @Override
    public String nextLine() {

        return reader.nextLine();
    }

    @Override
    public boolean hasNextLine() {

        return reader.hasNextLine();
    }

    @Override
    public void close() {
        reader.close();
    }

}
